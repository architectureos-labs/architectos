package com.architectureoslabs.engine.architecture.layer;


import java.util.List;

import com.architectureoslabs.engine.model.Dependency;


/**
 * Validates dependency direction between layers.
 */
public class LayerDependencyRule {


    private final ComponentLayerClassifier classifier =
            new ComponentLayerClassifier();



    public boolean isViolation(
            Dependency dependency
    ) {


        ArchitectureLayer source =
                classifier.classify(
                        dependency.getSource()
                );


        ArchitectureLayer target =
                classifier.classify(
                        dependency.getTarget()
                );



        return source == ArchitectureLayer.REPOSITORY
                && target == ArchitectureLayer.CONTROLLER;

    }



    public List<Dependency> findViolations(
            List<Dependency> dependencies
    ) {


        return dependencies.stream()
                .filter(
                        this::isViolation
                )
                .toList();

    }

}