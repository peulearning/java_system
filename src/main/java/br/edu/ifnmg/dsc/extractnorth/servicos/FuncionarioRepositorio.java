package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Funcionario;

public interface FuncionarioRepositorio extends Repositorio<Funcionario> {

  public boolean Cadastrar(String novoFuncionario);

}
