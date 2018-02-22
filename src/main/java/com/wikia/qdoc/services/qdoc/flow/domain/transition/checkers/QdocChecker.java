package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;

import java.util.Optional;

public interface QdocChecker {

  Optional<String> violation(QDocument.QDocData data);
}
