package com.wikia.qdoc.services.qdoc.flow;

public class FlowModule {


  //@Named("isDemoVersion")
  public boolean isDemoVersion(SystemConfig configuration) {
    return configuration.isDemoVersion();
  }

}
