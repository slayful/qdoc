package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import com.wikia.qdoc.services.qdoc.flow.CurrentUserProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class QDocNumberGenerator implements QDocNumberGeneratorPolicy {

  private final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  //@Named("isDemoVersion")
  private final boolean isDemoVersion;
  private final CurrentUserProvider currentUserProvider;

  public QDocNumberGenerator(CurrentUserProvider currentUserProvider, boolean isDemoVersion) {
    this.currentUserProvider = currentUserProvider;
    this.isDemoVersion = isDemoVersion;
  }

  @Override
  public QDocNumber generate(String documentType, LocalDateTime createdAt) {
    StringJoiner stringJoiner = new StringJoiner("/");
    if (isDemoVersion) {
      stringJoiner.add("DEMO");
    }
    stringJoiner
        .add(documentType)
        .add(createdAt.format(FORMAT));
    if (currentUserProvider.isAuditor()) {
      stringJoiner.add("AUDIT");
    }

    return new QDocNumber(stringJoiner.toString());
  }
}
