package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.TransacaoFinanceira;

public interface TransacaoRepositorio extends Repositorio<TransacaoFinanceira> {

  public boolean Cadastrar(String novaTransacao);
}
