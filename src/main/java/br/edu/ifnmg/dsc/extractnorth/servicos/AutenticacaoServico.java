package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Usuario;

public interface AutenticacaoServico {
  public boolean autenticar(String usuario, String senha);

  public Usuario getUsuario();
}
