package com.architectureoslabs.engine.report;


import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests report file writing.
 */
public class ReportWriterTest {


    @Test
    void shouldWriteReportToFile()
            throws Exception {


        Path file =
                Files.createTempFile(
                        "architectos",
                        ".md"
                );


        ReportWriter writer =
                new ReportWriter();


        writer.write(
                file.toString(),
                "# ArchitectOS Report"
        );


        String content =
                Files.readString(file);



        assertTrue(
                content.contains(
                        "ArchitectOS Report"
                )
        );


        Files.deleteIfExists(file);

    }

}
