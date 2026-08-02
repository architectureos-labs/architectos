package com.architectureoslabs.engine.model;


/**
 * Represents architecture analysis metrics.
 */
public class ArchitectureMetrics {


    private final int filesAnalyzed;


    private final int components;


    private final int dependencies;



    public ArchitectureMetrics(
            int filesAnalyzed,
            int components,
            int dependencies
    ) {

        this.filesAnalyzed = filesAnalyzed;
        this.components = components;
        this.dependencies = dependencies;

    }



    public int getFilesAnalyzed() {

        return filesAnalyzed;

    }



    public int getComponents() {

        return components;

    }



    public int getDependencies() {

        return dependencies;

    }

}