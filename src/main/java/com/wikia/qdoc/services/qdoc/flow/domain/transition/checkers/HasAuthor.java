package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import com.wikia.qdoc.shared.QManagerId;

import java.util.Optional;

public class HasAuthor implements QdocChecker {

  private final Optional<String> violation;

  public HasAuthor(QManagerId author) {
    if (author != null) {
      this.violation = Optional.empty();
    } else {
      this.violation = Optional.of("Document must have an author");
    }
  }

  @Override
  public Optional<String> violation() {
    return violation;
  }

}
