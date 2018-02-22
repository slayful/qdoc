package com.wikia.qdoc.services.qdoc.flow.domain.transition;

import com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers.QdocChecker;

import java.util.List;

public class TransitionPolicy {

  void validateTransition(List<QdocChecker> checkers) throws InvalidTransition {

  }


  class InvalidTransition extends RuntimeException {

    List<String> violations;

  }
}
