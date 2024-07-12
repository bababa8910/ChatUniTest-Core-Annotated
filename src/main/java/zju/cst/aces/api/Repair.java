package zju.cst.aces.api;

import java.io.IOException;

/**
 * Interface for repairing code using different strategies.
 */
public interface Repair {

    /**
     * Repairs the given code using rule-based techniques.
     *
     * @param code the code to repair
     * @return the repaired code
     */
    String ruleBasedRepair(String code);

    /**
     * Repairs the given code using LLM-based techniques.
     *
     * @param code the code to repair
     * @return the repaired code
     */
    String LLMBasedRepair(String code);

    /**
     * Repairs the given code using LLM-based techniques with the specified number of rounds.
     *
     * @param code the code to repair
     * @param rounds the number of rounds to use for repair
     * @return the repaired code
     */
    String LLMBasedRepair(String code, int rounds);

}
