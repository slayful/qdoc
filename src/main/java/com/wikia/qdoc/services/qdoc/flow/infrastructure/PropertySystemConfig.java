package com.wikia.qdoc.services.qdoc.flow.infrastructure;

import com.wikia.qdoc.services.qdoc.flow.domain.ports.SystemConfig;

public class PropertySystemConfig implements SystemConfig {

  private final boolean isDemoVersion;

  public PropertySystemConfig(boolean isDemoVersion) {
    this.isDemoVersion = isDemoVersion;
  }

  @Override
  public boolean isDemoVersion() {
    return isDemoVersion;
  }

  @Override
  public String getQDocumentType() {
    return "ISO";
  }
}
