package zju.cst.aces.api;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * Interface representing a project and its related operations.
 */

public interface Project {

    /**
     * Gets the parent project.
     *
     * @return the parent project
     */
    Project getParent();

    /**
     * Gets the base directory of the project.
     *
     * @return the base directory as a File
     */
    File getBasedir();

    /**
     * Get the project packaging type.
     * 
     * @return the packaging type as a String
     */
    String getPackaging();

    /**
     * Get the group ID of the project.
     * 
     * @return the group ID as a String
     */
    String getGroupId();

    /**
     * Get the artifact ID of the project.
     * 
     * @return the artifact ID as a String
     */
    String getArtifactId();

    /**
     * Get the list of compile source roots.
     * 
     * @return the list of compile source roots
     */
    List<String> getCompileSourceRoots();

    /**
     * Get the path to the artifact.
     * 
     * @return the artifact path as a Path
     */
    Path getArtifactPath();

    /**
     * Get the build path of the project.
     * 
     * @return the build path as a Path
     */
    Path getBuildPath();

    /**
     * Get the list of class paths.
     * 
     * @return the list of class paths
     */
    List<String> getClassPaths();

}
