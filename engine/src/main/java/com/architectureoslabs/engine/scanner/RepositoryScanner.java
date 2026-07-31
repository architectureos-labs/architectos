package com.architectureoslabs.engine.scanner;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Scans repositories and discovers Java source files.
 */
public class RepositoryScanner {


    /**
     * Find all Java files inside a repository.
     *
     * @param repositoryPath repository location
     * @return list of Java source files
     */
    public List<Path> scan(
            String repositoryPath
    ) throws IOException {


        return Files.walk(
                    Path.of(repositoryPath)
                )
                .filter(
                    Files::isRegularFile
                )
                .filter(
                    path ->
                        path.toString()
                            .endsWith(".java")
                )
                .collect(
                    Collectors.toList()
                );

    }

}