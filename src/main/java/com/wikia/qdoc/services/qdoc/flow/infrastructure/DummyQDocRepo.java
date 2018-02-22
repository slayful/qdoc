package com.wikia.qdoc.services.qdoc.flow.infrastructure;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;
import com.wikia.qdoc.services.qdoc.flow.domain.ports.QDocRepo;
import com.wikia.qdoc.shared.QdocId;

public class DummyQDocRepo implements QDocRepo {

  @Override
  public void save(QDocument qDocument) {

  }

  @Override
  public QDocument load(QdocId qdocId) {
    return null;
  }
}
