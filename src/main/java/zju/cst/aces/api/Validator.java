package zju.cst.aces.api;

import org.junit.platform.launcher.listeners.TestExecutionSummary;
import zju.cst.aces.dto.PromptInfo;

import java.nio.file.Path;

/**
 * Interface for validating code using various methods.
*/

public interface Validator {

    /**
     * Validates the syntax of the code.
     *
     * @param code the code to validate
     * @return true if the code is syntactically valid, false otherwise
     */
    boolean syntacticValidate(String code);

    /**
     * Validates the semantics of the code.
     *
     * @param code the code to validate
     * @param className the name of the class to validate
     * @param outputPath the path to the output directory
     * @param promptInfo the information about the prompt
     * @return true if the code is semantically valid, false otherwise
     */
    boolean semanticValidate(String code, String className, Path outputPath, PromptInfo promptInfo);
    
    /**
     * Validates the runtime of the code.
     *
     * @param fullTestName the fully qualified name of the test
     * @return true if the code runs successfully, false otherwise
     */
    boolean runtimeValidate(String fullTestName);

    /**
     * Compiles the code.
     *
     * @param className the name of the class to compile
     * @param outputPath the path to the output directory
     * @param promptInfo the information about the prompt
     * @return true if the code compiles successfully, false otherwise
     */
    public boolean compile(String className, Path outputPath, PromptInfo promptInfo);
    
    /**
     * Executes the specified test and returns the summary of the test execution.
     *
     * @param fullTestName the fully qualified name of the test
     * @return the summary of the test execution
     */
    public TestExecutionSummary execute(String fullTestName);
}
