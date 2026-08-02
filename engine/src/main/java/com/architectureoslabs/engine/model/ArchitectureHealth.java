package com.architectureoslabs.engine.model;


/**
 * Represents overall architecture health.
 */
public class ArchitectureHealth {


    private final int score;


    private final String rating;



    public ArchitectureHealth(
            int score,
            String rating
    ) {

        this.score = score;
        this.rating = rating;

    }



    public int getScore() {

        return score;

    }



    public String getRating() {

        return rating;

    }

}