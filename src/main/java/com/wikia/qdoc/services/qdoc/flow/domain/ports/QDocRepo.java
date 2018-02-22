package com.wikia.qdoc.services.qdoc.flow.domain.ports;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;
import com.wikia.qdoc.shared.QdocId;

public interface QDocRepo {

  void save(QDocument qDocument);

  QDocument load(QdocId qdocId);
}
