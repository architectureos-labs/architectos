package com.architectureoslabs.engine.rules;


import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;


/**
 * Detects circular dependencies between components.
 */
public class CircularDependencyRule
        implements ArchitectureRule {


    @Override
    public RuleResult evaluate(
            ArchitectureGraph graph
    ) {


        for (Dependency first :
                graph.getDependencies()) {


            for (Dependency second :
                    graph.getDependencies()) {


                boolean cycle =
                        first.getSource()
                                .equals(
                                        second.getTarget()
                                )
                        &&
                        first.getTarget()
                                .equals(
                                        second.getSource()
                                );



                if (cycle) {


                    return new RuleResult(

                            "CircularDependencyRule",

                            "HIGH",

                            true,

                            "Circular dependency detected between "
                                    + first.getSource()
                                    + " and "
                                    + first.getTarget()

                    );

                }

            }

        }



        return new RuleResult(

                "CircularDependencyRule",

                "INFO",

                false,

                "No circular dependencies detected"

        );

    }

}
