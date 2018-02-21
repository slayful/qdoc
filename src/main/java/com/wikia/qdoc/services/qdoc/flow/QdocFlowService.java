package com.wikia.qdoc.services.qdoc.flow;

import com.wikia.qdoc.shared.DepartmentId;
import com.wikia.qdoc.shared.QManagerId;
import com.wikia.qdoc.shared.QdocId;

import java.util.Set;

public interface QdocFlowService {

  void create(String qdocType, QdocId qdocId);

  void sendForVerification(QdocId qdocId, QManagerId verifier) throws IllegalStatusChange;

  void markAsVerified(QdocId qdocId) throws IllegalStatusChange;

  void publish(QdocId qdocId, Set<DepartmentId> receivingDepartments) throws IllegalStatusChange;

  void archive(QdocId qdocId) throws IllegalStatusChange;


  class IllegalStatusChange extends Exception {}
}
