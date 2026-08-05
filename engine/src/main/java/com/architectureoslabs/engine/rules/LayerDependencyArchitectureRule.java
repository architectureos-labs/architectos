package com.architectureoslabs.engine.rules;


import com.architectureoslabs.engine.architecture.layer.LayerDependencyRule;
import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;


/**
 * Architecture rule validating layer dependency direction.
 */
public class LayerDependencyArchitectureRule
        implements ArchitectureRule {


    private final LayerDependencyRule rule =
            new LayerDependencyRule();



    @Override
    public RuleResult evaluate(
            ArchitectureGraph graph
    ) {


        for (Dependency dependency :
                graph.getDependencies()) {


            if (rule.isViolation(dependency)) {


                return new RuleResult(
                        "LayerDependencyRule",
                        "HIGH",
                        true,
                        "Repository layer should not depend on Controller layer: "
                                + dependency.getSource()
                                + " -> "
                                + dependency.getTarget()
                );

            }

        }


        return new RuleResult(
                "LayerDependencyRule",
                "INFO",
                false,
                "No invalid layer dependencies detected"
        );

    }


}