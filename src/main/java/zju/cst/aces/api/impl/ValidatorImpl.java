package zju.cst.aces.api.impl;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import lombok.Data;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import zju.cst.aces.api.Validator;
import zju.cst.aces.api.config.Config;
import zju.cst.aces.dto.PromptInfo;
import zju.cst.aces.util.TestCompiler;

import java.nio.file.Path;
import zju.cst.aces.api.Validator;

@Data
public class ValidatorImpl implements Validator {

    TestCompiler compiler;

    public ValidatorImpl(Config config) {
        this.compiler = new TestCompiler(config);
    }

    @Override
    public boolean syntacticValidate(String code) {
        try {
            StaticJavaParser.parse(code);
            return true;
        } catch (ParseProblemException e) {
            return false;
        }
    }

    @Override
    public boolean semanticValidate(String className, Path outputPath, PromptInfo promptInfo) {
        return compiler.compileTest(className, outputPath, promptInfo);
    }

    @Override
    public boolean runtimeValidate(String fullTestName) {
        return compiler.executeTest(fullTestName).getTestsFailedCount() == 0;
    }

    public boolean compile(String className, Path outputPath, PromptInfo promptInfo) {
        return compiler.compileTest(className, outputPath, promptInfo);
    }

    public TestExecutionSummary execute(String fullTestName) {
        return compiler.executeTest(fullTestName);
    }
}