package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import br.edu.ifnmg.dsc.extractnorth.entidades.Pessoa;

public class PessoaDAO<T extends Pessoa> extends DAO<T> {

  public PessoaDAO(Class<T> classe) {
    super(classe);
  }

}
