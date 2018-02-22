package com.wikia.qdoc.services.qdoc.flow.domain.ports;

import com.wikia.qdoc.services.qdoc.flow.domain.QDocument;

public interface QDocRepo {

  void save(QDocument qDocument);
}
