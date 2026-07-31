package com.architectureoslabs.engine.scanner;


import org.junit.jupiter.api.Test;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;



public class RepositoryScannerTest {


    @Test
    void shouldFindJavaFiles()
            throws Exception {


        Path directory =
                Files.createTempDirectory(
                        "architectos-test"
                );


        Files.createFile(
                directory.resolve(
                        "Test.java"
                )
        );


        Files.createFile(
                directory.resolve(
                        "README.md"
                )
        );


        RepositoryScanner scanner =
                new RepositoryScanner();



        List<Path> files =
                scanner.scan(
                        directory.toString()
                );



        assertEquals(
                1,
                files.size()
        );


        assertTrue(
                files.get(0)
                        .toString()
                        .endsWith(
                                "Test.java"
                        )
        );


    }

}