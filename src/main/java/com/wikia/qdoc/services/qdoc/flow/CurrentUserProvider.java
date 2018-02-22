package com.wikia.qdoc.services.qdoc.flow;

import com.wikia.qdoc.shared.QManagerId;

public interface CurrentUserProvider {

  QManagerId getQManagerId();

  boolean isAuditor();
}
