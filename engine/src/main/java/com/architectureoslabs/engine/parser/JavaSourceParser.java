package com.architectureoslabs.engine.parser;

import com.architectureoslabs.engine.model.SoftwareComponent;


/**
 * Parses Java source files and extracts architecture information.
 *
 * Initial responsibility:
 *
 * - Identify Java classes
 * - Create architecture components
 *
 * Future:
 * - Extract methods
 * - Extract dependencies
 * - Build relationships
 */
public class JavaSourceParser {


    /**
     * Parse a Java source file.
     *
     * @param sourceCode Java source content
     * @return discovered software component
     */
    public SoftwareComponent parse(String sourceCode) {


        String className =
                extractClassName(sourceCode);


        return new SoftwareComponent(
                className,
                "class"
        );
    }



    private String extractClassName(String sourceCode) {


        String keyword = "class ";


        int index =
                sourceCode.indexOf(keyword);



        if (index == -1) {

            return "Unknown";

        }



        String remaining =
                sourceCode.substring(
                        index + keyword.length()
                );



        return remaining
                .split("\\s+")[0];

    }

}
