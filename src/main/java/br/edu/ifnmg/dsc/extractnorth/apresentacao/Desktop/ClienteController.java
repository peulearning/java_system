package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;

import br.edu.ifnmg.dsc.extractnorth.entidades.Cliente;
import br.edu.ifnmg.dsc.extractnorth.servicos.ClienteRepositorio;
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
@FxmlView("ClientesView.fxml")
public class ClienteController extends Controller {

  private Cliente entidade;

  @Inject
  ClienteRepositorio clientes;

  @Autowired
  private ClienteRepositorio repositorio;

  @FXML
  private TextField txtNomeBusca;

  @FXML
  private TableView<Cliente> tblBusca;

  @FXML
  private TextField txtnomeClientes;

  @FXML
  private TextField txttelefoneClientes;

  @FXML
  private TextField txtemailClientes;

  @FXML
  private TextField txtenderecoClientes;

  @FXML
  private TextField txtcnpjClientes;

  @FXML
  private TextField txtatividadeClientes;

  @FXML
  private TabPane abas;

  public ClienteController() {

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
    TableColumn<Cliente, String> nome = new TableColumn<>("Nome");

    nome.setCellValueFactory(
        new PropertyValueFactory<>("nome"));

    tblBusca.getColumns().add(nome);

    TableViewSelectionModel<Cliente> selectionModel = tblBusca.getSelectionModel();

    selectionModel.setSelectionMode(SelectionMode.SINGLE);

    tblBusca.setSelectionModel(selectionModel);

  }

  public Cliente getEntidade() {
    return entidade;
  }

  public void setEntidade(Cliente entidade) {
    this.entidade = entidade;
  }

  public void carregarCampos() {
    txtnomeClientes.setText(entidade.getNome());
    txtcnpjClientes.setText(entidade.getCnpj());
  }

  public void carregarEntidade() {
    entidade.setNome(txtnomeClientes.getText());
    entidade.setCnpj(txtcnpjClientes.getText());
  }

  @FXML
  public void buscar(Event e) {

    Cliente filtro = new Cliente();

    filtro.setCnpj(txtcnpjClientes.getText());

    List<Cliente> resultado = repositorio.Buscar(filtro);

    tblBusca.getItems().removeAll(tblBusca.getItems());
    tblBusca.getItems().addAll(resultado);

  }

  @FXML
  public void editar(Event e) {
    setEntidade((Cliente) tblBusca.getSelectionModel().getSelectedItem());
    carregarCampos();
    abas.getTabs().get(1).setDisable(false);
    abas.getSelectionModel().select(1);

  }

  @FXML
  public void novo(Event e) {
    setEntidade(new Cliente());
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
  public void cadastrarNovoCliente(Event e) {
    String novoCliente = txtcnpjClientes.getText();

    if (clientes.Cadastrar(novoCliente)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Cliente Cadastrado com SUCESSO ! ", ButtonType.OK);
      alert.showAndWait();

      txtcnpjClientes.clear();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar Funcionário !", ButtonType.OK);
      alert.showAndWait();

    }
  }

}
