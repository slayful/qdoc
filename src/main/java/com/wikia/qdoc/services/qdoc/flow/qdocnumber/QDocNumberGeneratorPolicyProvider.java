package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import com.wikia.qdoc.services.qdoc.flow.CurrentUserProvider;
import com.wikia.qdoc.services.qdoc.flow.SystemConfig;

public class QDocNumberGeneratorPolicyProvider {

  private final SystemConfig configuration;
  private final CurrentUserProvider provider;

  public QDocNumberGeneratorPolicyProvider(SystemConfig configuration,
                                           CurrentUserProvider provider) {
    this.configuration = configuration;
    this.provider = provider;
  }

  public QDocNumberGeneratorPolicy provide() {

    return
        new QDocNumberGeneratorAuditorDecoratorPolicy(
            new QDocNumberGeneratorDemoDecoratorPolicy(
                new QDocNumberGeneratorQDocumentTypeDecoratorPolicy(
                    new QDocNumberGeneratorDatePolicy(),
                    configuration.getQDocumentType()
                ),
                configuration.isDemoVersion()
            ),
            provider
        );
  }

}
