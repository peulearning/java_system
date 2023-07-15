package br.edu.ifnmg.dsc.extractnorth.persistencia;

import br.edu.ifnmg.dsc.extractnorth.entidades.Pessoa;

public class PessoaDAO<T extends Pessoa extends DAO<T> {

  @AutoWired
  protected AutenticacaoServico autenticacao;

  @AutoWired
  protected LogServico log;

  public PessoaDAO(Class<T> classe){
    super(classe);
  }

  @Override
  @Transactional
  public boolean Salvar(T obj) {
    if(obj.getId() == 0){
      obj.setDataCriacao(new Date());
      obj.setCriador(autenticacao.getUsuario());
    }
      obj.setDataUltimateModificacao(new Date());
      obj.setUltimoModificador(autenticacao.getUsuario());

      return super.Salvar(obj);
  }
}