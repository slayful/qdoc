package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import java.time.LocalDateTime;
import java.util.Optional;

public class HasExpirationDate implements QdocChecker {

  private final Optional<String> violation;

  public HasExpirationDate(LocalDateTime expirationDate) {
    if (expirationDate != null) {
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
