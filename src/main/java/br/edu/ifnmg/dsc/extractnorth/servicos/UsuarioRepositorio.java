package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Usuario;

public interface UsuarioRepositorio
    extends Repositorio<Usuario> {

  public Usuario Abrir(String Login);

  public boolean Autenticar(String login, String senha);

}
