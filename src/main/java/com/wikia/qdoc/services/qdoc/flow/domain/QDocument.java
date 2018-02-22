package com.wikia.qdoc.services.qdoc.flow.domain;

import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber;
import com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers.*;
import com.wikia.qdoc.shared.QManagerId;

import java.time.LocalDateTime;

public class QDocument {

  private final QManagerId author;
  private final LocalDateTime createdAt;
  private final LocalDateTime expirationDate;
  private final QDocNumber documentNr;

  public QDocument(
      QManagerId author,
      LocalDateTime createdAt,
      QDocNumber documentNr,
      String status
  ) {
    this.author = author;
    this.createdAt = createdAt;
    this.documentNr = documentNr;
    expirationDate = LocalDateTime.now();
  }

  public void transitionTo(String targetStatus) {

//    policy.validateTransition(targetStatus);
  }

  public QdocChecker documentNumberChecker() {
    return new HasDocumentNumber(documentNr);
  }

  public QdocChecker expirationDateChecker() {
    return new HasExpirationDate(expirationDate);
  }

  public QdocChecker authorChecker() {
    return new HasAuthor(author);
  }
}
