package com.architectureoslabs.engine.model;


import java.time.LocalDateTime;
import java.util.List;

import com.architectureoslabs.engine.rules.RuleResult;


/**
 * Represents a complete architecture analysis report.
 */
public class ArchitectureReport {


    private final String repositoryName;


    private final LocalDateTime generatedAt;


    private final ArchitectureGraph graph;


    private final List<RuleResult> ruleResults;


    private final ArchitectureMetrics metrics;


    private final ArchitectureHealth health;



    public ArchitectureReport(
            String repositoryName,
            LocalDateTime generatedAt,
            ArchitectureGraph graph,
            List<RuleResult> ruleResults,
            ArchitectureMetrics metrics,
            ArchitectureHealth health
    ) {

        this.repositoryName = repositoryName;
        this.generatedAt = generatedAt;
        this.graph = graph;
        this.ruleResults = ruleResults;
        this.metrics = metrics;
        this.health = health;

    }



    public String getRepositoryName() {

        return repositoryName;

    }



    public LocalDateTime getGeneratedAt() {

        return generatedAt;

    }



    public ArchitectureGraph getGraph() {

        return graph;

    }



    public List<RuleResult> getRuleResults() {

        return ruleResults;

    }



    public ArchitectureMetrics getMetrics() {

        return metrics;

    }



    public ArchitectureHealth getHealth() {

        return health;

    }

}