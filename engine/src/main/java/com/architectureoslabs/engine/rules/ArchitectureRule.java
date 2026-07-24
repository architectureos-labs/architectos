package com.architectureoslabs.engine.rules;


import com.architectureoslabs.engine.model.ArchitectureGraph;


/**
 * Represents an architecture validation rule.
 *
 * Rules inspect the architecture graph
 * and identify violations.
 */
public interface ArchitectureRule {


    /**
     * Evaluate architecture.
     *
     * @param graph architecture graph
     * @return rule evaluation result
     */
    RuleResult evaluate(
            ArchitectureGraph graph
    );

}
