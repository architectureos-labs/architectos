package com.architectureoslabs.engine.rules;


import com.architectureoslabs.engine.architecture.layer.ArchitectureLayer;
import com.architectureoslabs.engine.config.ArchitectureRuleConfiguration;
import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;


/**
 * Validates dependencies using configurable architecture rules.
 */
public class ConfigurableLayerDependencyRule implements ArchitectureRule {


    private final ArchitectureRuleConfiguration configuration;


    public ConfigurableLayerDependencyRule(
            ArchitectureRuleConfiguration configuration
    ) {

        this.configuration =
                configuration;

    }


    @Override
    public RuleResult evaluate(
            ArchitectureGraph graph
    ) {


        for (Dependency dependency
                : graph.getDependencies()) {


            ArchitectureLayer source =
                    resolveLayer(
                            dependency.getSource()
                    );


            ArchitectureLayer target =
                    resolveLayer(
                            dependency.getTarget()
                    );


            if (!isAllowed(
                    source,
                    target
            )) {


                return new RuleResult(
                        "ConfigurableLayerDependencyRule",
                        "HIGH",
                        true,
                        source
                                + " cannot depend on "
                                + target
                );

            }

        }


        return new RuleResult(
                "ConfigurableLayerDependencyRule",
                "INFO",
                false,
                "No invalid layer dependencies detected"
        );

    }



    private boolean isAllowed(
            ArchitectureLayer source,
            ArchitectureLayer target
    ) {


        return configuration
                .getAllowedDependencies()
                .getOrDefault(
                        source.name(),
                        java.util.List.of()
                )
                .contains(
                        target.name()
                );

    }



    private ArchitectureLayer resolveLayer(
            String componentName
    ) {


        String name =
                componentName.toLowerCase();


        if (name.endsWith("controller")) {

            return ArchitectureLayer.CONTROLLER;

        }


        if (name.endsWith("service")) {

            return ArchitectureLayer.SERVICE;

        }


        if (name.endsWith("repository")) {

            return ArchitectureLayer.REPOSITORY;

        }


        return ArchitectureLayer.DOMAIN;

    }

}