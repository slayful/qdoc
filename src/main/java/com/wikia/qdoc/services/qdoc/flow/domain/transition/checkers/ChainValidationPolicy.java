package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocState;
import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ChainValidationPolicy implements QDocTransitionPolicy {

  private final Set<QdocChecker> checkers;

  public ChainValidationPolicy(Set<QdocChecker> checkers) {
    this.checkers = checkers;
  }

  @Override
  public void validate(QDocState state, QDocument.QDocData data) {
    List<String> violations = checkers.stream()
        .map(checker -> checker.violation(data))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());

    if (!violations.isEmpty()) {
      throw new InvalidTransition(violations);
    }
  }


  private class InvalidTransition extends RuntimeException {

    private final List<String> violations;

    public InvalidTransition(List<String> violations) {
      this.violations = violations;
    }
  }
}
