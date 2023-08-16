package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AplicacaoJavaFX extends Application {

  private ConfigurableApplicationContext contextoSpring;

  @Override
  public void init() {
    String[] args = getParameters().getRaw().toArray(new String[0]);

    this.contextoSpring = new SpringApplicationBuilder()
        .sources(AplicacaoSpring.class)
        .run(args);
  }

  @Override
  public void stop() {
    this.contextoSpring.close();
    Platform.exit();
  }

  @Override
  public void start(Stage stage) {

  }

}
