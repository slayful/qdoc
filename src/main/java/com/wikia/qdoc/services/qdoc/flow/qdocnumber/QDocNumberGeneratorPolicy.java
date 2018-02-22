package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import java.time.LocalDateTime;

public interface QDocNumberGeneratorPolicy {

  QDocNumber generate(LocalDateTime createdAt);
}
