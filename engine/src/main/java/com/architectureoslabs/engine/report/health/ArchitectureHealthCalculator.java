package com.architectureoslabs.engine.report.health;


import java.util.List;

import com.architectureoslabs.engine.model.ArchitectureHealth;
import com.architectureoslabs.engine.rules.RuleResult;


/**
 * Calculates architecture health score.
 */
public class ArchitectureHealthCalculator {


    public ArchitectureHealth calculate(
            List<RuleResult> results
    ) {


        int score = 100;



        for (RuleResult result : results) {


            if (result.isViolated()) {


                if ("CircularDependencyRule"
                        .equals(result.getRuleName())) {


                    score -= 30;


                } else {


                    score -= 10;

                }

            }

        }



        if (score < 0) {

            score = 0;

        }



        String rating;


        if (score >= 90) {

            rating = "HEALTHY";

        } else if (score >= 70) {

            rating = "WARNING";

        } else {

            rating = "CRITICAL";

        }



        return new ArchitectureHealth(
                score,
                rating
        );

    }

}