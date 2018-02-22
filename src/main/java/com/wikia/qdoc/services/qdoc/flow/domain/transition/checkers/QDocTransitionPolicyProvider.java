package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocState;
import com.wikia.qdoc.services.qdoc.flow.domain.ports.SystemConfig;

import java.util.Collections;
import java.util.Set;

public class QDocTransitionPolicyProvider {

  private final SystemConfig config;

  public QDocTransitionPolicyProvider(SystemConfig config) {
    this.config = config;
  }

  private Set<QdocChecker> getCheckers(QDocState transitionTo) {
    if ("ISO".equals(config.getQDocumentType())) {
      if (QDocState.VERIFIED.equals(transitionTo)) {
        return Collections.singleton(new HasDocumentNumber());
      }

      if (QDocState.PUBLISHED.equals(transitionTo)) {
        return Collections.singleton(new HasExpirationDate());
      }

    }
    if ("QED".equals(config.getQDocumentType())) {
      if (QDocState.VERIFIED.equals(transitionTo)) {
        return Collections.singleton(new HasAuthor());
      }

      if (QDocState.PUBLISHED.equals(transitionTo)) {
        return Collections.singleton(new HasDocumentNumber());
      }
    }

    return Collections.emptySet();
  }


  public QDocTransitionPolicy provide(QDocState transitionTo) {
    return new ChainValidationPolicy(getCheckers(transitionTo));
  }

}
