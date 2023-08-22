package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.servicos.UsuarioRepositorio;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("/javafx/br/edu/ifnmg/dsc/extractnorth/apresentacao_javafx/LoginView.fxml")
public class LoginController extends Controller {

    @Inject
    UsuarioRepositorio usuarios;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField pwdSenha;

    @FXML
    TitledPane LoginView;

    @FXML
    private Hyperlink hyperlinkRegistro;

    public LoginController() {

    }

    @FXML
    public void autenticar(Event e) {
        String login = txtLogin.getText();
        String senha = pwdSenha.getText();

        if (usuarios.Autenticar(login, senha)) {

            Alert alert = new Alert(AlertType.INFORMATION, "Bem vindo ao sistema! ", ButtonType.OK);
            alert.showAndWait();
        } else {

            Alert alert = new Alert(AlertType.CONFIRMATION, "Erro ao acessar o sistema. Deseja sair?", ButtonType.YES,
                    ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.NO) {
                Platform.exit();
            }

        }
    }

}
