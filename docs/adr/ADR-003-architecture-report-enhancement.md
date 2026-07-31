# ADR-003: Enhance Architecture Report Content


## Status

Accepted


## Context

The initial ArchitectOS report validates architecture rules
but provides limited information about the analyzed software
system.

For a practical architecture analysis tool, users need
additional context including analyzed components,
dependencies, and architecture summaries.


## Decision

ArchitectOS reports will include:

- Repository information
- Number of analyzed files
- Component count
- Dependency count
- Rule execution summary
- Architecture findings


## Consequences

Positive:

- Reports become more useful for developers
- Architecture reviews become easier
- CI/CD integration becomes more meaningful


Negative:

- Report generation requires additional model information
- Larger repositories may produce larger reports


## Future Extensions

- HTML reports
- Architecture diagrams
- Historical comparisons
- Architecture quality scores