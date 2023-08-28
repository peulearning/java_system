package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.servicos.UsuarioRepositorio;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("RegistroView.fxml")
public class RegistroController extends Controller {

  @Inject
  UsuarioRepositorio usuarios;

  @FXML
  private TextField txtNovoUsuario;

  @FXML
  private PasswordField pwdNovaSenha;

  @FXML
  private Button btnCadastrar;

  @FXML
  TitledPane RegistroView;

  public RegistroController() {

  }

  @FXML
  public void cadastrarNovoUsuario(Event e) {
    String novoUsuario = txtNovoUsuario.getText();
    String novaSenha = pwdNovaSenha.getText();

    if (usuarios.Cadastrar(novoUsuario, novaSenha)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Usuário cadastrado com sucesso ! ", ButtonType.OK);
      alert.showAndWait();

      txtNovoUsuario.clear();
      pwdNovaSenha.clear();
    } else {
      Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar usuário.", ButtonType.OK);
      alert.showAndWait();
    }

  }

  @FXML
  public void retornarTelaLogin() {
    carregarScene(RegistroView, LoginController.class);
  }

}
