package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;

import br.edu.ifnmg.dsc.extractnorth.entidades.TransacaoFinanceira;
import br.edu.ifnmg.dsc.extractnorth.servicos.TransacaoRepositorio;
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
@FxmlView("TransacoesView.fxml")
public class TransacaoController extends Controller {

  private TransacaoFinanceira entidade;

  @Inject
  TransacaoRepositorio transacoes;

  @Autowired
  private TransacaoRepositorio repositorio;

  @FXML
  private TextField txttransacaoBusca;

  @FXML
  private TableView<TransacaoFinanceira> tblBusca;

  @FXML
  private TextField txtidentificador;

  @FXML
  private TextField txtformaPagamento;

  @FXML
  private TextField txtitens;

  @FXML
  private TextField txtestoque;

  @FXML
  private TextField txtcomprador;

  @FXML
  private TextField txtvendedor;

  @FXML
  private TextField txtprecoTotal;

  @FXML
  private TextField txttipo;

  @FXML
  private TextField txtstatus;

  @FXML
  private TextField btnCadastrar;

  @FXML
  private TabPane abas;

  public TransacaoController() {

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
    TableColumn<TransacaoFinanceira, String> nome = new TableColumn<>("Identificador");
    nome.setCellValueFactory(
        new PropertyValueFactory<>("Identificador"));

    tblBusca.getColumns().add(nome);

    // Confirugar o modo de seleção

    TableViewSelectionModel<TransacaoFinanceira> selectionModel = tblBusca.getSelectionModel();

    selectionModel.setSelectionMode(SelectionMode.SINGLE);

    tblBusca.setSelectionModel(selectionModel);
  }

  public TransacaoFinanceira getEntidade() {
    return entidade;
  }

  public void setEntidade(TransacaoFinanceira entidade) {
    this.entidade = entidade;
  }

  public void carregarCampos() {
    txtidentificador.setText(entidade.getIdentificador());
    txtformaPagamento.setText(entidade.getFormaPg().toString());
    txtstatus.setText(entidade.getStatus().toString());

  }

  public void carregarEntidade() {
    entidade.setIdentificador(entidade.getIdentificador());

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
  public void buscar(Event e) {

    TransacaoFinanceira filtro = new TransacaoFinanceira();

    filtro.setIdentificador(txtidentificador.getText());

    List<TransacaoFinanceira> resultado = repositorio.Buscar(filtro);

    tblBusca.getItems().removeAll(tblBusca.getItems());
    tblBusca.getItems().addAll(resultado);
  }

  @FXML
  public void editar(Event e) {
    setEntidade((TransacaoFinanceira) tblBusca.getSelectionModel().getSelectedItem());
    carregarCampos();
    abas.getTabs().get(1).setDisable(false);
    abas.getSelectionModel().select(1);

  }

  @FXML
  public void novo(Event e) {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente salvar as alterações ? ", ButtonType.YES,
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
  public void cadastrarnovaTransacao(Event e) {
    String novaTransacao = txtidentificador.getText();

    if (transacoes.Cadastrar(novaTransacao)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Produto Cadastrado com SUCESSO ! ", ButtonType.OK);
      alert.showAndWait();

      txtidentificador.clear();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar Produto !", ButtonType.OK);
      alert.showAndWait();

    }
  }

}
