package com.wikia.qdoc.services.qdoc.flow;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.wikia.qdoc.services.qdoc.flow.domain.ports.CurrentUserProvider;
import com.wikia.qdoc.services.qdoc.flow.domain.SystemConfig;
import com.wikia.qdoc.services.qdoc.flow.domain.qdocnumber.QDocNumberGeneratorPolicyProvider;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class QDocNumberGeneratorTest {

  private CurrentUserProvider mock;

  @Before
  public void setup() {
    this.mock = mock(CurrentUserProvider.class);
  }

  @Test
  public void basicNumber() {
    when(mock.isAuditor()).thenReturn(false);
    QDocNumberGeneratorPolicyProvider provider = new QDocNumberGeneratorPolicyProvider(
        new SystemConfig(false),
        mock
    );

    LocalDateTime now = LocalDateTime.of(2000, 12, 28, 0, 0, 0);

    String generate = provider.provide().generate(now).getValue();
    assertThat(generate).isEqualTo("ISO/28-12-2000");
  }

  @Test
  public void basicNumberForAuditor() {
    when(mock.isAuditor()).thenReturn(true);
    QDocNumberGeneratorPolicyProvider provider = new QDocNumberGeneratorPolicyProvider(
        new SystemConfig(false),
        mock
    );

    LocalDateTime now = LocalDateTime.of(2000, 12, 28, 0, 0, 0);

    String generate = provider.provide().generate(now).getValue();
    assertThat(generate).isEqualTo("ISO/28-12-2000/AUDIT");
  }

  @Test
  public void basicNumberForDemo() {
    when(mock.isAuditor()).thenReturn(false);
    QDocNumberGeneratorPolicyProvider provider = new QDocNumberGeneratorPolicyProvider(
        new SystemConfig(true),
        mock
    );

    LocalDateTime now = LocalDateTime.of(2000, 12, 28, 0, 0, 0);

    String generate = provider.provide().generate(now).getValue();
    assertThat(generate).isEqualTo("DEMO/ISO/28-12-2000");
  }

  @Test
  public void basicNumberForDemoAudit() {
    when(mock.isAuditor()).thenReturn(true);
    QDocNumberGeneratorPolicyProvider provider = new QDocNumberGeneratorPolicyProvider(
        new SystemConfig(true),
        mock
    );

    LocalDateTime now = LocalDateTime.of(2000, 12, 28, 0, 0, 0);

    String generate = provider.provide().generate(now).getValue();
    assertThat(generate).isEqualTo("DEMO/ISO/28-12-2000/AUDIT");
  }

}