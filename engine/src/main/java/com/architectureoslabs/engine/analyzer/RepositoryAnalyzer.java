package com.architectureoslabs.engine.analyzer;


import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.ParsedJavaFile;
import com.architectureoslabs.engine.parser.JavaSourceParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


/**
 * Coordinates repository analysis.
 */
public class RepositoryAnalyzer {


    private final JavaSourceParser parser;


    public RepositoryAnalyzer() {

        this.parser =
                new JavaSourceParser();

    }



    /**
     * Analyze Java source files.
     *
     * @param files Java source files
     * @return architecture graph
     */
    public ArchitectureGraph analyze(
            List<Path> files
    ) throws IOException {


        ArchitectureGraph graph =
                new ArchitectureGraph();



        for (Path file : files) {


            String source =
                    Files.readString(file);



            ParsedJavaFile parsed =
                    parser.parse(
                            source
                    );



            graph.addComponent(
                    parsed.getComponent()
            );



            parsed.getDependencies()
                    .forEach(
                            graph::addDependency
                    );


        }



        return graph;

    }

}