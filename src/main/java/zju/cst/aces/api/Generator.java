package zju.cst.aces.api;

import zju.cst.aces.dto.ChatMessage;

import java.util.List;

/**
 * Interface for generating test cases or other necessary components.
 */

public interface Generator {

    /**
     * Generates output based on the provided list of messages.
     *
     * @param chatMessages the list of messages used for generation
     * @return the generated output as a String
     */
    String generate(List<ChatMessage> chatMessages);

}
