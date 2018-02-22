package com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber;

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
  public QDocNumber generate(LocalDateTime createdAt) {
    QDocNumber generate = policy.generate(createdAt);
    if (demoVersion) {
      return generate.withPrefix("DEMO");
    }
    return generate;
  }
}
