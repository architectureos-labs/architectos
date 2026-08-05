package com.architectureoslabs.engine.config;

import java.util.List;
import java.util.Map;

/**
 * Defines configurable architecture rules.
 */
public class ArchitectureRuleConfiguration {


    private final Map<String, List<String>> allowedDependencies;


    public ArchitectureRuleConfiguration(
            Map<String, List<String>> allowedDependencies
    ) {

        this.allowedDependencies =
                allowedDependencies;

    }


    public Map<String, List<String>> getAllowedDependencies() {

        return allowedDependencies;

    }

}