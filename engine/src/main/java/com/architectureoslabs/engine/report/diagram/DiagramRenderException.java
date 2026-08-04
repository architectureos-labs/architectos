package com.architectureoslabs.engine.report.diagram;


/**
 * Exception thrown when a diagram cannot be rendered.
 */
public class DiagramRenderException
        extends RuntimeException {


    public DiagramRenderException(
            String message
    ) {

        super(message);

    }



    public DiagramRenderException(
            String message,
            Throwable cause
    ) {

        super(
                message,
                cause
        );

    }

}