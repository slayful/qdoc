package com.wikia.qdoc.services.qdoc.flow.domain;

import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber;
import com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers.QDocTransitionPolicy;
import com.wikia.qdoc.shared.QManagerId;

import java.time.LocalDateTime;

public class QDocument {

  private final QManagerId author;
  private final LocalDateTime createdAt;
  private final LocalDateTime expirationDate;
  private final QDocNumber documentNr;
  private final String qdocType;
  private final QDocState state;

  public QDocument(
      QManagerId author,
      LocalDateTime createdAt,
      QDocNumber documentNr,
      String qdocType,
      QDocState state
  ) {
    this.author = author;
    this.createdAt = createdAt;
    this.documentNr = documentNr;
    this.qdocType = qdocType;
    this.state = state;
    expirationDate = LocalDateTime.now();
  }

  public void verify(QDocTransitionPolicy validationPolicy) {
    validationPolicy.validate(QDocState.VERIFIED, new QDocData(
        documentNr != null,
        expirationDate != null,
        author != null
    ));
  }

  public static class QDocData {

    private final boolean hasDocumentNr;
    private final boolean hasExpirationDate;
    private final boolean hasAuthor;

    public QDocData(boolean hasDocumentNr, boolean hasExpirationDate, boolean hasAuthor) {
      this.hasDocumentNr = hasDocumentNr;
      this.hasExpirationDate = hasExpirationDate;
      this.hasAuthor = hasAuthor;
    }

    public boolean hasAuthor() {
      return hasAuthor;
    }

    public boolean hasDocumentNr() {
      return hasDocumentNr;
    }

    public boolean hasExpirationDate() {
      return hasExpirationDate;
    }
  }
}
