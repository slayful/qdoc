package com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber;

import com.wikia.qdoc.services.qdoc.flow.domain.ports.CurrentUserProvider;

import java.time.LocalDateTime;

public class QDocNumberGeneratorAuditorDecoratorPolicy implements QDocNumberGeneratorPolicy {

  private final QDocNumberGeneratorPolicy
      policy;
  private final CurrentUserProvider currentUserProvider;

  public QDocNumberGeneratorAuditorDecoratorPolicy(
      QDocNumberGeneratorPolicy policy,
      CurrentUserProvider currentUserProvider
  ) {
    this.policy = policy;
    this.currentUserProvider = currentUserProvider;
  }

  @Override
  public com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber generate(
      LocalDateTime createdAt) {
    com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber
        qDocNumber = policy.generate(createdAt);
    if (currentUserProvider.isAuditor()) {
      return qDocNumber.withSuffix("AUDIT");
    }
    return qDocNumber;
  }
}
