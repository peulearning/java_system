package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import org.springframework.stereotype.Component;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView("Template.fxml")
@Component
public class MenuController extends Controller {

  @FXML
  TitledPane principal;

  public MenuController() {

  }

  @FXML
  public void telaUsuario(Event e) {
    carregarScene(principal, UsuarioController.class);
  }
}
