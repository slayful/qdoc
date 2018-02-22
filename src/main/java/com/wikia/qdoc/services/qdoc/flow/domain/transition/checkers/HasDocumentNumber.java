package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber;

import java.util.Optional;

public class HasDocumentNumber implements QdocChecker {

  private final Optional<String> violation;

  public HasDocumentNumber(QDocNumber number) {
    if (number != null) {
      this.violation = Optional.empty();
    } else {
      this.violation = Optional.of("Document must have a number");
    }
  }

  @Override
  public Optional<String> violation() {
    return violation;
  }
}
