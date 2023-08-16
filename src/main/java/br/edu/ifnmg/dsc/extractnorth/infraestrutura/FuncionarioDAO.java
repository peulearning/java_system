package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Funcionario;
import br.edu.ifnmg.dsc.extractnorth.servicos.FuncionarioRepositorio;

@Service
public class FuncionarioDAO extends DAO<Funcionario> implements FuncionarioRepositorio {

  public FuncionarioDAO() {
    super(Funcionario.class);
  }

}
