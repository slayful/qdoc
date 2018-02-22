package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

public class QDocNumber {

  private static final String SEPARATOR = "/";
  private final String value;

  private QDocNumber(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public QDocNumber withPrefix(String value) {
    return new QDocNumber(SEPARATOR + value);
  }

  public QDocNumber withSuffix(String value) {
    return new QDocNumber(value + SEPARATOR);
  }

}
