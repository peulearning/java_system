package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;

import br.edu.ifnmg.dsc.extractnorth.entidades.Fornecedor;
import br.edu.ifnmg.dsc.extractnorth.servicos.FornecedorRepositorio;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("FornecedoresView.fxml")
public class FornecedorController extends Controller {

  private Fornecedor entidade;

  @Inject
  FornecedorRepositorio fornecedores;

  @Autowired
  private FornecedorRepositorio repositorio;

  @FXML
  private TextField txtNomeBusca;

  @FXML
  private TableView<Fornecedor> tblBusca;

  @FXML
  private TextField txtnomeFornecedores;

  @FXML
  private TextField txttelefoneFornecedores;

  @FXML
  private TextField txtemailFornecedores;

  @FXML
  private TextField txtenderecoFornecedores;

  @FXML
  private TextField txtcpfFornecedores;

  @FXML
  private TabPane abas;

  public FornecedorController() {

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
    TableColumn<Fornecedor, String> nome = new TableColumn<>("Nome");

    nome.setCellValueFactory(
        new PropertyValueFactory<>("nome"));

    tblBusca.getColumns().add(nome);

    TableViewSelectionModel<Fornecedor> selectionModel = tblBusca.getSelectionModel();

    selectionModel.setSelectionMode(SelectionMode.SINGLE);

    tblBusca.setSelectionModel(selectionModel);

  }

  public Fornecedor getEntidade() {
    return entidade;
  }

  public void setEntidade(Fornecedor entidade) {
    this.entidade = entidade;

  }

  public void carregarCampos() {
    txtnomeFornecedores.setText(entidade.getNome());
    txtcpfFornecedores.setText(entidade.getCpf());
  }

  public void carregarEntidade() {
    entidade.setNome(txtnomeFornecedores.getText());
    entidade.setCpf(txtcpfFornecedores.getText());
  }

  @FXML
  public void buscar(Event e) {

    Fornecedor filtro = new Fornecedor();

    filtro.setCpf(txtcpfFornecedores.getText());

    List<Fornecedor> resultado = repositorio.Buscar(filtro);

    tblBusca.getItems().removeAll(tblBusca.getItems());
    tblBusca.getItems().addAll(resultado);

  }

  @FXML
  public void editar(Event e) {
    setEntidade((Fornecedor) tblBusca.getSelectionModel().getSelectedItem());
    carregarCampos();
    abas.getTabs().get(1).setDisable(false);
    abas.getSelectionModel().select(1);

  }

  @FXML
  public void novo(Event e) {
    setEntidade(new Fornecedor());
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
  public void cadastrarNovoFornecedor(Event e) {
    String novoFornecedor = txtcpfFornecedores.getText();

    if (fornecedores.Cadastrar(novoFornecedor)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Cliente Fornecedores com SUCESSO ! ", ButtonType.OK);
      alert.showAndWait();

      txtcpfFornecedores.clear();
    } else {
      Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar Fornecedores !", ButtonType.OK);
      alert.showAndWait();

    }
  }
}