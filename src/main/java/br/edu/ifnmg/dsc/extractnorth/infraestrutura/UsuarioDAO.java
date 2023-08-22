package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Usuario;
import br.edu.ifnmg.dsc.extractnorth.servicos.UsuarioRepositorio;
import jakarta.persistence.Query;

@Service
public class UsuarioDAO extends DAO<Usuario> implements UsuarioRepositorio {

  public UsuarioDAO() {
    super(Usuario.class);
  }

  @Override
  public Usuario Abrir(String login) {
    try {
      Query consulta = (Query) getManager()
          .createQuery("select u from Usuario u where u.login = :login");
      consulta.setParameter("login", login);

      return (Usuario) consulta.getSingleResult();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }
  }

  @Override
  public boolean Autenticar(String login, String senha){
    Query consulta = (Query) getManager()
          .createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
    consulta.setParameter("login", login);
    consulta.setParameter("senha", senha);
    Usuario tmp = (Usuario)consulta.getSingleResult();
      return tmp != null;
  }

}
