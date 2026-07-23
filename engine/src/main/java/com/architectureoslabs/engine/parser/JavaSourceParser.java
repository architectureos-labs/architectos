package com.architectureoslabs.engine.parser;


import com.architectureoslabs.engine.model.Dependency;
import com.architectureoslabs.engine.model.ParsedJavaFile;
import com.architectureoslabs.engine.model.SoftwareComponent;


import java.util.ArrayList;
import java.util.List;



/**
 * Parses Java source files and extracts architecture information.
 */
public class JavaSourceParser {



    /**
     * Parse Java source code.
     *
     * @param sourceCode Java source content
     * @return parsed Java representation
     */
    public ParsedJavaFile parse(String sourceCode) {


        String className =
                extractClassName(sourceCode);



        SoftwareComponent component =
                new SoftwareComponent(
                        className,
                        "class"
                );



        List<Dependency> dependencies =
                extractDependencies(
                        className,
                        sourceCode
                );



        return new ParsedJavaFile(
                component,
                dependencies
        );

    }




    private String extractClassName(String sourceCode) {


        String keyword = "class ";


        int index =
                sourceCode.indexOf(keyword);



        if (index == -1) {

            return "Unknown";

        }



        String remaining =
                sourceCode.substring(
                        index + keyword.length()
                );



        return remaining
                .split("\\s+")[0];

    }




    private List<Dependency> extractDependencies(
            String className,
            String sourceCode
    ) {


        List<Dependency> dependencies =
                new ArrayList<>();



        String[] lines =
                sourceCode.split("\\n");



        for (String line : lines) {


            line = line.trim();



            if (line.startsWith("import ")) {


                String importedClass =
                        line.substring(7)
                                .replace(
                                        ";",
                                        ""
                                );



                String simpleName =
                        importedClass.substring(
                                importedClass.lastIndexOf(".") + 1
                        );



                dependencies.add(
                        new Dependency(
                                className,
                                simpleName
                        )
                );

            }

        }


        return dependencies;

    }

}
