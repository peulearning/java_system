package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import java.util.Optional;

import org.springframework.stereotype.Service;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("SairView.fxml")
public class SairController extends Controller {

  @FXML
  private Button btnSair;

  public SairController() {

  }

  @FXML
  public void exit() {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmação de Saída");
    alert.setHeaderText("Você está prestes a sair do sistema.");
    alert.setContentText("Deseja realmente sair?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      // Implemente aqui a lógica para sair do sistema, se necessário.
      // Por exemplo, System.exit(0) para encerrar o aplicativo.
      System.exit(0);
    }
  }
}
