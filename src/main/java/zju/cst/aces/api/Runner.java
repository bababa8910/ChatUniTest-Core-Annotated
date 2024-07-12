package zju.cst.aces.api;

import zju.cst.aces.dto.MethodInfo;

/**
 * Interface for running tests or other executable components.
 */
public interface Runner {

    /**
     * Runs all tests in the specified class.
     *
     * @param fullClassName the fully qualified name of the class
     */
    public void runClass(String fullClassName);

    /**
     * Runs a specific method in the specified class.
     *
     * @param fullClassName the fully qualified name of the class
     * @param methodInfo the information about the method to run
     */
    public void runMethod(String fullClassName, MethodInfo methodInfo);

}