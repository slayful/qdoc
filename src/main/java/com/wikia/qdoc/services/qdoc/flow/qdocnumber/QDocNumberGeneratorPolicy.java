package com.wikia.qdoc.services.qdoc.flow.qdocnumber;

import java.time.LocalDateTime;

public interface QDocNumberGeneratorPolicy {

  QDocNumber generate(String documentType, LocalDateTime createdAt);
}
