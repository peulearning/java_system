package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;

@EntityScan("br.edu.ifnmg.dsc.extractnorth")
@ComponentScan("br.edu.ifnmg.dsc.extractnorth")
@SpringBootApplication
public class AplicacaoSpring {
  public static void main(String[] args) {
    Application.launch(AplicacaoJavaFX.class, args);
  }

  @Bean
  public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
    return new SpringFxWeaver(applicationContext);
  }

}
