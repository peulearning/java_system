package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;

import br.edu.ifnmg.dsc.extractnorth.entidades.Produto;
import br.edu.ifnmg.dsc.extractnorth.servicos.ProdutoRepositorio;
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
@FxmlView("ProdutosView.fxml")
public class ProdutoController extends Controller {

  private Produto entidade;

  @Inject
  ProdutoRepositorio produtos;

  @Autowired
  private ProdutoRepositorio repositorio;

  @FXML
  private TextField txtProdutoBusca;

  @FXML
  private TableView<Produto> tblBusca;

  @FXML
  private TextField txtnomeProdutos;

  @FXML
  private TextField txtprecoProdutos;

  @FXML
  private TextField txtpreco2Produtos;

  @FXML
  private TextField quantidadeProdutos;

  @FXML
  private TextField txtloteProdutos;

  @FXML
  private TextField txtdescricaoProdutos;

  @FXML
  private TabPane abas;

  public ProdutoController() {

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
    TableColumn<Produto, String> nome = new TableColumn<>("Nome");

    nome.setCellValueFactory(
        new PropertyValueFactory<>("nome"));

    tblBusca.getColumns().add(nome);

    // Confirugar o modo de seleção

    TableViewSelectionModel<Produto> selectionModel = tblBusca.getSelectionModel();

    selectionModel.setSelectionMode(SelectionMode.SINGLE);

    tblBusca.setSelectionModel(selectionModel);
  }

  public Produto getEntidade() {
    return entidade;
  }

  public void setEntidade(Produto entidade) {
    this.entidade = entidade;
  }

  public void carregarCampos() {
    txtnomeProdutos.setText(entidade.getNome());
    txtprecoProdutos.setText(Double.toString(entidade.getPrecoCompra()));
    txtpreco2Produtos.setText(Double.toString(entidade.getPrecoVenda()));
  }

  public void carregarEntidade() {
    entidade.setNome(txtnomeProdutos.getText());
    entidade.setLote(null);
    entidade.setPrecoCompra(0);
    entidade.setPrecoVenda(0);
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

    Produto filtro = new Produto();

    filtro.setNome(txtnomeProdutos.getText());

    List<Produto> resultado = repositorio.Buscar(filtro);

    tblBusca.getItems().removeAll(tblBusca.getItems());
    tblBusca.getItems().addAll(resultado);
  }

  @FXML
  public void editar(Event e) {
    setEntidade((Produto) tblBusca.getSelectionModel().getSelectedItem());
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
  public void cadastrarnovoProduto(Event e) {
    String novoProduto = txtnomeProdutos.getText();

    if (produtos.Cadastrar(novoProduto)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Produto Cadastrado com SUCESSO ! ", ButtonType.OK);
      alert.showAndWait();

      txtnomeProdutos.clear();
    } else {
      Alert alert = new Alert(AlertType.ERROR, "Erro ao cadastrar Produto !", ButtonType.OK);
      alert.showAndWait();

    }
  }

}