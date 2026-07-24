package com.architectureoslabs.engine.analyzer;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;
import com.architectureoslabs.engine.model.ParsedJavaFile;
import com.architectureoslabs.engine.parser.JavaSourceParser;

/**
 * Coordinates repository analysis and produces an architecture graph.
 */
public class RepositoryAnalyzer {

    private final JavaSourceParser parser;

    public RepositoryAnalyzer() {
        this.parser = new JavaSourceParser();
    }

    /**
     * Analyze Java source code and produce an architecture graph.
     *
     * Future versions will:
     * - Scan directories
     * - Parse every Java file
     * - Merge all parsed files into one graph
     */
    public ArchitectureGraph analyze(String sourceCode) {

        ParsedJavaFile parsedFile =
                parser.parse(sourceCode);

        ArchitectureGraph graph =
                new ArchitectureGraph();

        graph.addComponent(
                parsedFile.getComponent()
        );

        for (Dependency dependency : parsedFile.getDependencies()) {
            graph.addDependency(dependency);
        }

        return graph;
    }

}
