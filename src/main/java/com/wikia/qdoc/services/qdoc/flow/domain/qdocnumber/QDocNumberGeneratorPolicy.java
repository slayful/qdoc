package com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber;

import java.time.LocalDateTime;

public interface QDocNumberGeneratorPolicy {

  QDocNumber generate(LocalDateTime createdAt);
}
