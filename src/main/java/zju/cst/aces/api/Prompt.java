package zju.cst.aces.api;

import lombok.Data;
import zju.cst.aces.api.config.Config;
import zju.cst.aces.dto.ClassInfo;
import zju.cst.aces.dto.Message;
import zju.cst.aces.dto.MethodInfo;
import zju.cst.aces.dto.PromptInfo;
import zju.cst.aces.prompt.PromptGenerator;
import zju.cst.aces.runner.AbstractRunner;
import zju.cst.aces.util.TokenCounter;

import java.io.IOException;
import java.util.List;

@Data
public class Prompt {

    Config config;
    PromptInfo promptInfo;
    List<Message> messages;
    int tokenCount = 0;
    String testName;
    String fullTestName;
    static final String separator = "_";

    public Prompt(Config config) {
        this.config = config;
    }

    public List<Message> generate() throws IOException {
        if (promptInfo == null) {
            throw new RuntimeException("PromptInfo is null, you need to initialize it first.");
        }
        this.messages = new PromptGenerator(config).generateMessages(promptInfo);
        countToken();
        return this.messages;
    }

    public void setPromptInfoWithDep(ClassInfo classInfo, MethodInfo methodInfo) throws IOException {
        this.promptInfo = AbstractRunner.generatePromptInfoWithDep(config, classInfo, methodInfo);
    }

    public void setPromptInfoWithoutDep(ClassInfo classInfo, MethodInfo methodInfo) throws IOException {
        this.promptInfo = AbstractRunner.generatePromptInfoWithoutDep(config, classInfo, methodInfo);
    }

    public void setFullTestName(String fullTestName) {
        this.fullTestName = fullTestName;
        this.promptInfo.setFullTestName(this.fullTestName);
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void countToken() {
        for (Message p : messages) {
            this.tokenCount += TokenCounter.countToken(p.getContent());
        }
    }

    public boolean isExceedMaxTokens() {
        if (this.tokenCount > config.maxPromptTokens) {
            return true;
        } else {
            return false;
        }
    }
}
