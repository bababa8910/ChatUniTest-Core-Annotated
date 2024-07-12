package zju.cst.aces.api;

import zju.cst.aces.dto.ChatMessage;

import java.util.List;

/**
 * Interface for constructing prompts.
 */
public interface PromptConstructor {

    /**
     * Generates a list of messages as prompts.
     *
     * @return the list of generated messages
     */
    List<ChatMessage> generate();

}

