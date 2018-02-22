package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import java.time.LocalDateTime;

public class QDocNumberGeneratorQDocumentTypeDecoratorPolicy implements QDocNumberGeneratorPolicy {

  private final QDocNumberGeneratorPolicy policy;
  private final String qDocumentType;

  public QDocNumberGeneratorQDocumentTypeDecoratorPolicy(
      QDocNumberGeneratorPolicy policy,
      String qDocumentType
  ) {
    this.policy = policy;
    this.qDocumentType = qDocumentType;
  }

  @Override
  public QDocNumber generate(LocalDateTime createdAt) {
    QDocNumber generate = policy.generate(createdAt);
    return generate.withPrefix(qDocumentType);
  }
}
