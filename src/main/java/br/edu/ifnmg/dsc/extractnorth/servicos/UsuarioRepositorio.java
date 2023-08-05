package br.edu.ifnmg.dsc.extractnorth.servicos;

import br.edu.ifnmg.dsc.extractnorth.entidades.Usuario;

public interface UsuarioRepositorio
    extends Repositorio<UsuarioRepositorio> {

  public Usuario Abrir(String Login);

}
