package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Produto;
import br.edu.ifnmg.dsc.extractnorth.servicos.ProdutoRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class ProdutoDAO extends DAO<Produto> implements ProdutoRepositorio {

  @PersistenceContext
  private EntityManager entityManager;

  public ProdutoDAO() {
    super(Produto.class);
  }

  @Override
  @Transactional
  public boolean Cadastrar(String novoProduto) {
    Query consulta = (Query) getManager().createQuery("select p from Produto p WHERE p.nome = :nome");
    consulta.setParameter("nome", novoProduto);

    List<Produto> produtos = consulta.getResultList();

    if (!produtos.isEmpty()) {
      return false;
    }

    try {
      Produto produto = new Produto();
      produto.setNome(novoProduto);
      produto.setLote(null);
      produto.setPrecoCompra(0);
      produto.setPrecoVenda(0);

      entityManager().persist(produto);

      return true;
    } catch (Exception ex) {
      System.out.println("Erro ao cadastrar Produto ! :" + ex.getMessage());
      return false;
    }
  }

  private EntityManager entityManager() {
    return entityManager;
  }

  @Override
  @Transactional
  public List<Produto> Buscar(Produto filtro) {
    try {
      String jpql = "select p from Produto p";

      if (!filtro.getNome().isEmpty()) {
        jpql += "WHERE p.nome like :nome";
      }
      Query consulta = getManager().createQuery(jpql);
      if (!filtro.getNome().isEmpty()) {
        consulta.setParameter("nome", filtro.getNome());
      }
      return consulta.getResultList();

    } catch (Exception ex) {
      return null;
    }
  }
}
