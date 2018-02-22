package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;

import java.time.LocalDateTime;
import java.util.Optional;

public class HasExpirationDate implements QdocChecker {

  @Override
  public Optional<String> violation(QDocument.QDocData data) {
    if (data.hasExpirationDate()) {
      return Optional.empty();
    }
    return Optional.of("Expiration date required");
  }
}
