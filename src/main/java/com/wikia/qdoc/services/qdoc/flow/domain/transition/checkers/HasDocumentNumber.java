package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;
import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber;

import java.util.Optional;

public class HasDocumentNumber implements QdocChecker {

  @Override
  public Optional<String> violation(QDocument.QDocData data) {
    if (data.hasDocumentNr()) {
      return Optional.empty();
    }
    return Optional.of("Doc number required");
  }
}
