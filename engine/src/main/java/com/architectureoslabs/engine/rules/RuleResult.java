package com.architectureoslabs.engine.rules;


/**
 * Represents the result of an architecture rule evaluation.
 */
public class RuleResult {


    private final boolean violated;


    private final String message;



    public RuleResult(
            boolean violated,
            String message
    ) {

        this.violated = violated;
        this.message = message;

    }



    public boolean isViolated() {

        return violated;

    }



    public String getMessage() {

        return message;

    }

}
