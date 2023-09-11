package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Produto;

public interface ProdutoRepositorio extends Repositorio<Produto> {

  public boolean Cadastrar(String novoProduto);

}
