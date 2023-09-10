package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Fornecedor;

public interface FornecedorRepositorio extends Repositorio<Fornecedor> {

  public boolean Cadastrar(String novoFornecedor);

}
