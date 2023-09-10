package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Fornecedor;
import br.edu.ifnmg.dsc.extractnorth.servicos.FornecedorRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class FornecedorDAO extends DAO<Fornecedor> implements FornecedorRepositorio {

  @PersistenceContext
  private EntityManager entityManager;

  public FornecedorDAO() {
    super(Fornecedor.class);
  }

  @Override
  @Transactional
  public boolean Cadastrar(String novoFornecedor) {
    Query consulta = (Query) getManager().createQuery("select f from Fornecedor f WHERE f.cpf = :cpf");
    consulta.setParameter("cpf", novoFornecedor);

    List<Fornecedor> fornecedores = consulta.getResultList();

    if (!fornecedores.isEmpty()) {
      return false;
    }

    try {
      Fornecedor fornecedor = new Fornecedor();
      fornecedor.setNome(novoFornecedor);
      fornecedor.setCpf(novoFornecedor);
      fornecedor.setEmail(novoFornecedor);
      fornecedor.setTelefone(novoFornecedor);

      entityManager().persist(fornecedor);

      return true;
    } catch (Exception ex) {
      System.out.println("Erro ao cadastrar fornecedor ! : " + ex.getMessage());
      return false;
    }
  }

  private EntityManager entityManager() {
    return entityManager;

  }

  @Override
  @Transactional
  public List<Fornecedor> Buscar(Fornecedor filtro) {
    try {
      String jpql = "select f from Fornecedor f";

      if (!filtro.getCpf().isEmpty()) {
        jpql += " WHERE f.cpf like :cpf";
      }

      Query consulta = getManager().createQuery(jpql);
      if (!filtro.getCpf().isEmpty()) {
        consulta.setParameter("cpf", filtro.getCpf());
      }
      return consulta.getResultList();
    } catch (Exception ex) {
      return null;
    }
  }
}