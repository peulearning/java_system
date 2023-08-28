package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Usuario;
import br.edu.ifnmg.dsc.extractnorth.servicos.UsuarioRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class UsuarioDAO extends DAO<Usuario> implements UsuarioRepositorio {

  @PersistenceContext
  private EntityManager entityManager;

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
  public boolean Autenticar(String login, String senha) {
    Query consulta = (Query) getManager()
        .createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
    consulta.setParameter("login", login);
    consulta.setParameter("senha", senha);
    try {
      Usuario tmp = (Usuario) consulta.getSingleResult();

      return tmp != null;

    } catch (Exception e) {

      return false;
    }
  }

  @Override
  @Transactional
  public List<Usuario> Buscar(Usuario filtro) {
    try {
      String jpql = "select u from Usuario u";

      if (!filtro.getLogin().isEmpty()) {
        jpql += " where u.login like :login";
      }
      Query consulta = getManager().createQuery(jpql);
      if (!filtro.getLogin().isEmpty()) {
        consulta.setParameter("login", filtro.getLogin());
      }
      return consulta.getResultList();
    } catch (Exception ex) {
      return null;
    }

  }

  @Override
  @Transactional
  public boolean Cadastrar(String novoUsuario, String novaSenha) {
    Query consulta = getManager().createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
    consulta.setParameter("login", novoUsuario);

    List<Usuario> usuarios = consulta.getResultList();

    if (!usuarios.isEmpty()) {
      // Usuário com o mesmo login já existe
      return false;
    }

    try {
      Usuario usuario = new Usuario();
      usuario.setLogin(novoUsuario);
      usuario.setSenha(novaSenha);
      usuario.setAtribuicao("Dono/Adm");

      entityManager().persist(usuario);

      return true; // Cadastro bem-sucedido

    } catch (Exception ex) {
      System.out.println("Erro ao cadastrar usuário: " + ex.getMessage());
      return false; // Falha no cadastro
    }
  }

  private EntityManager entityManager() {
    return entityManager;
  }

}
