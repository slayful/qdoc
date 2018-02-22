package com.wikia.qdoc.services.qdoc.flow.domain;

import com.wikia.qdoc.services.qdoc.flow.domain.ports.CurrentUserProvider;
import com.wikia.qdoc.services.qdoc.flow.domain.ports.QDocRepo;
import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumber;
import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumberGeneratorPolicy;
import com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers.QDocTransitionPolicyProvider;
import com.wikia.qdoc.shared.DepartmentId;
import com.wikia.qdoc.shared.QManagerId;
import com.wikia.qdoc.shared.QdocId;

import java.time.LocalDateTime;
import java.util.Set;

public class QdocFlowService {

  private final CurrentUserProvider currentUserProvider;
  private final QDocNumberGeneratorPolicy numberGeneratorPolicy;
  private final QDocTransitionPolicyProvider transitionProvider;
  private final QDocRepo qDocRepo;

  public QdocFlowService(
      CurrentUserProvider currentUserProvider,
      QDocNumberGeneratorPolicy numberGeneratorPolicy,
      QDocTransitionPolicyProvider transitionProvider,
      QDocRepo qDocRepo
  ) {
    this.currentUserProvider = currentUserProvider;
    this.numberGeneratorPolicy = numberGeneratorPolicy;
    this.transitionProvider = transitionProvider;
    this.qDocRepo = qDocRepo;
  }

  void create(String qdocType, QdocId qdocId) {
    QManagerId author = currentUserProvider.getQManagerId();
    LocalDateTime createdAt = LocalDateTime.now();
    QDocNumber documentNr = numberGeneratorPolicy.generate(createdAt);

    QDocument qDocument = new QDocument(
        author,
        createdAt,
        documentNr,
        qdocType,
        QDocState.DRAFT
    );

    qDocRepo.save(qDocument);
  }

  void sendForVerification(QdocId qdocId) throws IllegalStatusChange {
    QDocument qDocument = qDocRepo.load(qdocId);
    qDocument.verify(transitionProvider.provide(QDocState.VERIFIED));
  }

  void markAsVerified(QdocId qdocId) throws IllegalStatusChange {

  }

  void publish(QdocId qdocId, Set<DepartmentId> receivingDepartments) throws IllegalStatusChange {
  }

  void archive(QdocId qdocId) throws IllegalStatusChange {
  }


  class IllegalStatusChange extends Exception {

    private IllegalStatusChange(String message) {
      super(message);
    }

    IllegalStatusChange success() {
      return new IllegalStatusChange("success");
    }

    IllegalStatusChange fail() {
      return new IllegalStatusChange("fail");
    }

  }
}
