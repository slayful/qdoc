package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import com.wikia.qdoc.services.qdoc.flow.SystemConfig;

public class QDocNumberGeneratorPolicyProvider {

  private final SystemConfig configuration;

  public QDocNumberGeneratorPolicyProvider(SystemConfig configuration) {
    this.configuration = configuration;
  }

  public QDocNumberGeneratorPolicy provide() {

    return new QDocNumberGeneratorDemoDecoratorPolicy(configuration.isDemoVersion());
  }

}
