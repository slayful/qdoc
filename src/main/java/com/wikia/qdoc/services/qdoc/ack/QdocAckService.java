package com.wikia.qdoc.services.qdoc.ack;

import java.util.Set;

public interface QdocAckService {

  void markAsRead(Qdoc qdoc, Worker worker);

  void markAsRead(Qdoc qdoc, Set<Worker> worker);


  class Qdoc {}

  class Worker {}
}
