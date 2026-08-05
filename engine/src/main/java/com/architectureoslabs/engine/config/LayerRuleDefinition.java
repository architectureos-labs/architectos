package com.architectureoslabs.engine.config;

import java.util.List;

/**
 * Defines allowed dependencies for a layer.
 */
public class LayerRuleDefinition {


    private final String layer;


    private final List<String> allowedLayers;


    public LayerRuleDefinition(
            String layer,
            List<String> allowedLayers
    ) {

        this.layer = layer;
        this.allowedLayers = allowedLayers;

    }


    public String getLayer() {

        return layer;

    }


    public List<String> getAllowedLayers() {

        return allowedLayers;

    }

}