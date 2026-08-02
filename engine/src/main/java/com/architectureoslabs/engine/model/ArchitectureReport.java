package com.architectureoslabs.engine.report.model;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.rules.RuleResult;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a complete architecture analysis report.
 */
public class ArchitectureReport {

    private final String repositoryName;

    private final LocalDateTime generatedAt;

    private final ArchitectureGraph graph;

    private final List<RuleResult> ruleResults;

    public ArchitectureReport(
            String repositoryName,
            LocalDateTime generatedAt,
            ArchitectureGraph graph,
            List<RuleResult> ruleResults
    ) {

        this.repositoryName = repositoryName;
        this.generatedAt = generatedAt;
        this.graph = graph;
        this.ruleResults = ruleResults;

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

}