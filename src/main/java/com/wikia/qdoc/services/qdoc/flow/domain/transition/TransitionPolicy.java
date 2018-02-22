package com.wikia.qdoc.services.qdoc.flow.domain.transition;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;
import com.wikia.qdoc.services.qdoc.flow.domain.ports.SystemConfig;
import com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers.QdocChecker;

import java.util.*;
import java.util.stream.Collectors;

public class TransitionPolicy {

  private final SystemConfig config;

  public TransitionPolicy(SystemConfig config) {
    this.config = config;
  }


  void validateTransition(QDocument document, String transitionTo)
      throws InvalidTransition {
    List<String> violations = getCheckers(document, transitionTo)
        .stream()
        .map(QdocChecker::violation)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());

    if (violations.isEmpty()) {
      throw new InvalidTransition(violations);
    }
  }

  private Set<QdocChecker> getCheckers(QDocument document, String transitionTo)
      throws InvalidTransition {
    if ("ISO".equals(config.getQDocumentType())) {
      if ("VERIFIED".equals(transitionTo)) {
        return Collections.singleton(document.documentNumberChecker());
      }

      if ("PUBLISHED".equals(transitionTo)) {
        return Collections.singleton(document.expirationDateChecker());
      }

    }
    if ("QED".equals(config.getQDocumentType())) {
      if ("VERIFIED".equals(transitionTo)) {
        return Collections.singleton(document.authorChecker());
      }

      if ("PUBLISHED".equals(transitionTo)) {
        return Collections.singleton(document.expirationDateChecker());
      }
    }

    return Collections.emptySet();
  }

  class InvalidTransition extends RuntimeException {

    private final List<String> violations;

    public InvalidTransition(List<String> violations) {
      this.violations = violations;
    }
  }
}
