package br.edu.ifnmg.dsc.extractnorth.apresentacao.Desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;

import br.edu.ifnmg.dsc.extractnorth.entidades.Funcionario;
import br.edu.ifnmg.dsc.extractnorth.entidades.Produto;
import br.edu.ifnmg.dsc.extractnorth.servicos.ProdutoRepositorio;
import javafx.fxml.FXML;
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

  public Produto getEntidade(){
    return entidade;
  }

  public void setEntidade(Produto entidade){
    this.entidade = entidade;
  }

  public void carregarCampos(){
    txtnomeProdutos.setText(entidade.getNome());
    txtprecoProdutos.setText(Double.toString(entidade.getPrecoCompra()));
    txtpreco2Produtos.setText(Double.toString(entidade.getPrecoVenda()));

  }

  public void carregarEntidade(){
    entidade.setNome(txtnomeProdutos.getText(0, 0));
  }
}