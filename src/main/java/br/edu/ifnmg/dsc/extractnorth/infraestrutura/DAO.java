package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import com.mysql.cj.Query;

import br.edu.ifnmg.dsc.extractnorth.servicos.Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class DAO<T> implements Repositorio<T> {

  @PersistenceContext
  private EntityManager manager;
  private Class<T> classe;

  public DAO(Class<T> classe) {
    this.classe = classe;
  }

  public EntityManager getManager() {
    return manager;
  }

  public Class<T> getClasse() {
    return classe;
  }

  @Override
  public T Abrir(Long id) {
    try {
      return (T) manager.find(this.classe, id);
    } catch (Exception ex) {
      return null;
    }
  }

  @Override
  @Transactional
  public boolean Salvar(T obj) {
    try {
      obj = manager.merge(obj);
      manager.flush();
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  @Transactional
  public boolean Apagar(T obj) {
    try {
      manager.remove(obj);
      manager.flush();
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  @Override
  @Transactional
  public List<T> Buscar(T filtro) {
    try {
      CriteriaBuilder cb = manager.getCriteriaBuilder();
      CriteriaQuery<T> cr = cb.createQuery(classe);
      Root<T> root = cr.from(classe);
      cr.select(root);

      Query consulta = (Query) manager.createQuery(cr);

      return ((TypedQuery<T>) consulta).getResultList();
    } catch (Exception ex) {
      return null;
    }
  }

}
