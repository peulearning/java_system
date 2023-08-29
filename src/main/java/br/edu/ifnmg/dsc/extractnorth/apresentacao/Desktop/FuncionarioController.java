package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;

import br.edu.ifnmg.dsc.extractnorth.entidades.Funcionario;
import br.edu.ifnmg.dsc.extractnorth.servicos.FuncionarioRepositorio;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("FuncionariosView.fxml")
public class FuncionarioController extends Controller {

  private Funcionario entidade;

  @Inject
  FuncionarioRepositorio funcionarios;

  @Autowired
  private FuncionarioRepositorio repositorio;

  @FXML
  private TextField txtNomeBusca;

  @FXML
  private TableView<Funcionario> tblBusca;

  @FXML
  private TextField txtnomeFuncionarios;

  @FXML
  private TextField txttelefoneFuncionarios;

  @FXML
  private TextField txtemailFuncionarios;

  @FXML
  private TextField txtenderecoFuncionarios;

  @FXML
  private TextField txtcpfFuncionarios;

  @FXML
  private TextField txtstatusFuncionarios;

  @FXML
  private TextField txtsalarioFuncionarios;

  @FXML
  private TabPane abas;

  public FuncionarioController() {

  }

  @FXML
  @Override
  public void initialize() {

    super.initialize();

    configurarTabela();

    abas.getTabs().get(1).setDisable(true);

  }

  private void configurarTabela() {

    tblBusca.getColumns().removeAll(tblBusca.getColumns());
    TableColumn<Funcionario, String> nome = new TableColumn<>("Nome");

    nome.setCellValueFactory(
        new PropertyValueFactory<>("nome"));

    tblBusca.getColumns().add(nome);

    // Confirugar o modo de seleção

    TableViewSelectionModel<Funcionario> selectionModel = tblBusca.getSelectionModel();

    selectionModel.setSelectionMode(SelectionMode.SINGLE);

    tblBusca.setSelectionModel(selectionModel);
  }

  public Funcionario getEntidade() {
    return entidade;
  }

  public void setEntidade(Funcionario entidade) {
    this.entidade = entidade;
  }

  public void carregarCampos() {
    txtnomeFuncionarios.setText(entidade.getNome());
    txtcpfFuncionarios.setText(entidade.getCpf());
  }

  public void carregarEntidade() {
    entidade.setNome(txtnomeFuncionarios.getText());
    entidade.setCpf(txtcpfFuncionarios.getText());
  }

  @FXML
  public void buscar(Event e) {

    Funcionario filtro = new Funcionario();

    filtro.setCpf(txtcpfFuncionarios.getText());

    List<Funcionario> resultado = repositorio.Buscar(filtro);

    tblBusca.getItems().removeAll(tblBusca.getItems());
    tblBusca.getItems().addAll(resultado);

  }

  @FXML
  public void editar(Event e) {
    setEntidade((Funcionario) tblBusca.getSelectionModel().getSelectedItem());
    carregarCampos();
    abas.getTabs().get(1).setDisable(false);
    abas.getSelectionModel().select(1);

  }

  @FXML
  public void novo(Event e) {
    setEntidade(new Funcionario());
    carregarCampos();
    abas.getTabs().get(1).setDisable(false);
    abas.getSelectionModel().select(1);
  }

  @FXML
  public void salvar(Event e) {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente salvar as alterações?", ButtonType.YES,
        ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      carregarEntidade();
      if (repositorio.Salvar(entidade)) {
        Alert confirmacao = new Alert(AlertType.INFORMATION, "Registro salvo com sucesso! ", ButtonType.OK);
        confirmacao.showAndWait();
      } else {
        Alert confirmacao = new Alert(AlertType.ERROR,
            "Falha ao salvar o registro! Contacte o administrador do sistema.", ButtonType.OK);
        confirmacao.showAndWait();
      }
    } else {
      Alert confirmacao = new Alert(AlertType.INFORMATION, "Operação cancelada! ", ButtonType.OK);
      confirmacao.showAndWait();
    }

  }

  @FXML
  public void cancelar(Event e) {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente cancelar a edição?", ButtonType.YES,
        ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      abas.getTabs().get(1).setDisable(true);
      abas.getSelectionModel().select(0);
    }
  }

  @FXML
  public void cadastrarNovoFuncionario(Event e) {
    String novoFuncionario = txtcpfFuncionarios.getText();

    if (funcionarios.Cadastrar(novoFuncionario)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Funcionário Cadastrado com SUCESSO ! ", ButtonType.OK);
      alert.showAndWait();

      txtcpfFuncionarios.clear();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar Funcionário !", ButtonType.OK);
      alert.showAndWait();

    }
  }

}
