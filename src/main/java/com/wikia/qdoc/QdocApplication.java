package com.wikia.qdoc;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class QdocApplication extends Application {

  @Override
  public void run(Configuration configuration, Environment environment) throws Exception {

  }

  public static void main(String[] args) throws Exception {
    new QdocApplication().run(args);
  }
}
