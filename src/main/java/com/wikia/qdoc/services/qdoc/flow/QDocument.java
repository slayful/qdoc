package com.wikia.qdoc.services.qdoc.flow;

import com.wikia.qdoc.services.qdoc.flow.qdocnumber.QDocNumber;
import com.wikia.qdoc.shared.QManagerId;

import java.time.LocalDateTime;

public class QDocument {

  private final QManagerId author;
  private final LocalDateTime createdAt;
  private final QDocNumber documentNr;

  public QDocument(
      QManagerId author,
      LocalDateTime createdAt,
      QDocNumber documentNr
  ) {
    this.author = author;
    this.createdAt = createdAt;
    this.documentNr = documentNr;
  }
}
