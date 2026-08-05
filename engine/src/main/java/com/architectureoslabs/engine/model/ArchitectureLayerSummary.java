package com.architectureoslabs.engine.model;


import com.architectureoslabs.engine.architecture.layer.ArchitectureLayer;


/**
 * Represents a component and its detected architecture layer.
 */
public class ArchitectureLayerSummary {


    private final String componentName;


    private final ArchitectureLayer layer;



    public ArchitectureLayerSummary(
            String componentName,
            ArchitectureLayer layer
    ) {

        this.componentName = componentName;
        this.layer = layer;

    }



    public String getComponentName() {

        return componentName;

    }



    public ArchitectureLayer getLayer() {

        return layer;

    }

}