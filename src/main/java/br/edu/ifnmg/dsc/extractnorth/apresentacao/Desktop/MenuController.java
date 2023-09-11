package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import org.springframework.stereotype.Component;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView("Template.fxml")
@Component
public class MenuController extends Controller {

  @FXML
  VBox principal;

  public MenuController() {

  }

  @FXML
  public void telaUsuarios(Event e) {
    carregarScene(principal, UsuarioController.class);
  }

  @FXML
  public void telaFuncionarios(Event e) {
    carregarScene(principal, FuncionarioController.class);
  }

  @FXML
  public void telaClientes(Event e) {
    carregarScene(principal, ClienteController.class);
  }

  @FXML
  public void telaFornecedores(Event e) {
    carregarScene(principal, FornecedorController.class);

  }

  @FXML
  public void telaSair(Event e) {
    carregarScene(principal, SairController.class);
  }

  @FXML
  public void telaProdutos(Event e) {
    carregarScene(principal, ProdutoController.class);
  }

}
