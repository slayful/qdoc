package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocState;
import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;

public interface QDocTransitionPolicy {

  void validate(QDocState state, QDocument.QDocData data);
}
