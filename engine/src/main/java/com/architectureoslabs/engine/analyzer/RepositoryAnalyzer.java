package com.architectureoslabs.engine.analyzer;


import com.architectureoslabs.engine.model.ParsedJavaFile;
import com.architectureoslabs.engine.parser.JavaSourceParser;



/**
 * Analyzes software repositories and extracts architecture information.
 *
 * This class coordinates:
 *
 * - Source parsing
 * - Component discovery
 * - Dependency extraction
 */
public class RepositoryAnalyzer {


    private final JavaSourceParser parser;



    public RepositoryAnalyzer() {

        this.parser =
                new JavaSourceParser();

    }



    /**
     * Analyze Java source content.
     *
     * @param sourceCode Java source code
     * @return parsed architecture information
     */
    public ParsedJavaFile analyze(
            String sourceCode
    ) {


        return parser.parse(
                sourceCode
        );

    }

}
