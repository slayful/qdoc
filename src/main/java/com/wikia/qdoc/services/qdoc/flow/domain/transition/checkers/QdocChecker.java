package com.wikia.qdoc.services.qdoc.flow.domain.transition.checkers;

import java.util.Optional;

public interface QdocChecker {

  Optional<String> violation();

}
