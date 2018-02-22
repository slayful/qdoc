package com.wikia.qdoc.services.qdoc.flow.domain.ports;

import com.wikia.qdoc.shared.QManagerId;

public interface CurrentUserProvider {

  QManagerId getQManagerId();

  boolean isAuditor();
}
