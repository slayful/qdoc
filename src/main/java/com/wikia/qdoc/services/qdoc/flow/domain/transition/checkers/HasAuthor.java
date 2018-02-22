package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocState;
import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;

import java.util.Optional;

public class HasAuthor implements QdocChecker {

  @Override
  public Optional<String> violation(QDocument.QDocData data) {
    if (data.hasAuthor()) {
      return Optional.empty();
    }
    return Optional.of("Author is required");
  }

}
