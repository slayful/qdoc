package com.wikia.qdoc.services.qdoc.flow.infrastructure;

import com.wikia.qdoc.services.qdoc.flow.domain.ports.CurrentUserProvider;
import com.wikia.qdoc.shared.QManagerId;

public class DummyCurrentUserProvider implements CurrentUserProvider {

  @Override
  public QManagerId getQManagerId() {
    return new QManagerId();
  }

  @Override
  public boolean isAuditor() {
    return false;
  }
}
