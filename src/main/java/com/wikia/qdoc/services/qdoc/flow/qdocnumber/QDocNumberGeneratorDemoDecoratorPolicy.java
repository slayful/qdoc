package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import java.time.LocalDateTime;

public class QDocNumberGeneratorDemoDecoratorPolicy implements QDocNumberGeneratorPolicy {

  private final QDocNumberGeneratorPolicy policy;
  private final boolean demoVersion;

  public QDocNumberGeneratorDemoDecoratorPolicy(QDocNumberGeneratorPolicy policy,
                                                boolean demoVersion) {
    this.policy = policy;
    this.demoVersion = demoVersion;
  }

  @Override
  public QDocNumber generate(String documentType, LocalDateTime createdAt) {
    QDocNumber generate = policy.generate(documentType, createdAt);
    if (demoVersion) {
      return generate.withPrefix("DEMO");
    }
    return generate;
  }
}
