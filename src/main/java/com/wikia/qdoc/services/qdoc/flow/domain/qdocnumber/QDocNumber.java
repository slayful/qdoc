package com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber;

public class QDocNumber {

  private static final String SEPARATOR = "/";
  private final String value;

  QDocNumber(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public QDocNumber withPrefix(String prefix) {
    return new QDocNumber(prefix + SEPARATOR + value);
  }

  public QDocNumber withSuffix(String suffix) {
    return new QDocNumber(value + SEPARATOR + suffix);
  }

}
