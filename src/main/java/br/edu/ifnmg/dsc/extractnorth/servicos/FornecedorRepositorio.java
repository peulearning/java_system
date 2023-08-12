package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Fornecedor;

public interface FornecedorRepositorio extends Repositorio<Fornecedor> {

  public Fornecedor abrirPorCPF(String cpf);

}
