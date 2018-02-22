package com.wikia.qdoc.services.qdoc.flow.domain;

import com.wikia.qdoc.services.qdoc.flow.domain.ports.SystemConfig;

public class FlowModule {


  //@Named("isDemoVersion")
  public boolean isDemoVersion(SystemConfig configuration) {
    return configuration.isDemoVersion();
  }

}
