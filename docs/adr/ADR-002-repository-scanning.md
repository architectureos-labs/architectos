# ADR-002: Introduce Repository Scanning Capability


## Status

Accepted


## Context

The initial ArchitectOS engine validated architecture analysis
using manually provided Java source input.

While useful for testing the analysis engine, a production
architecture analysis tool must operate on real software
repositories.

Developers need the ability to analyze an entire codebase,
identify components, discover dependencies, and generate
architecture reports automatically.


## Decision

ArchitectOS will introduce a Repository Scanner component.

The scanner will:

- Accept a repository path
- Discover Java source files
- Pass source files to the Java parser
- Aggregate results into an ArchitectureGraph


## Architecture


Repository

    |

    v

RepositoryScanner

    |

    v

JavaSourceParser

    |

    v

ArchitectureGraph

    |

    v

Rule Engine

    |

    v

Architecture Report



## Consequences

Positive:

- Enables real repository analysis
- Supports CI/CD integration
- Enables future language support
- Separates file discovery from parsing


Negative:

- Requires filesystem handling
- Requires handling invalid source files
- Requires larger test coverage


## Future Extensions

- Git repository integration
- Multi-language support
- Incremental analysis
- Large repository optimization