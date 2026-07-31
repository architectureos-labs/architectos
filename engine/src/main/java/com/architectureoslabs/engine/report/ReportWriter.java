package com.architectureoslabs.engine.report;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Writes generated architecture reports to files.
 */
public class ReportWriter {


    /**
     * Write report content to markdown file.
     *
     * @param filePath output file path
     * @param content markdown content
     */
    public void write(
            String filePath,
            String content
    ) throws IOException {


        Files.writeString(
                Path.of(filePath),
                content
        );

    }

}
