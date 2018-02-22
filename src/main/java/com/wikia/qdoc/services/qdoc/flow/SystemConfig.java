package com.wikia.qdoc.services.qdoc.flow;

public class SystemConfig {

  private final boolean isDemoVersion;

  public SystemConfig(boolean isDemoVersion) {
    this.isDemoVersion = isDemoVersion;
  }

  public boolean isDemoVersion() {
    return isDemoVersion;
  }

  public String getQDocumentType() {
    return "ISO";
  }
}
