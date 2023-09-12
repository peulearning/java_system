package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.TransacaoFinanceira;
import br.edu.ifnmg.dsc.extractnorth.servicos.TransacaoRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class TransacaoDAO extends DAO<TransacaoFinanceira> implements TransacaoRepositorio {

  @PersistenceContext
  private EntityManager entityManager;

  public TransacaoDAO() {
    super(TransacaoFinanceira.class);
  }

  @Override
  @Transactional
  public boolean Cadastrar(String novaTransacao) {
    Query consulta = (Query) getManager().createNamedQuery("select t from transacao_financeira t WHERE t.id  = :id");

    consulta.setParameter("id", novaTransacao);

    List<TransacaoFinanceira> transacoes = consulta.getResultList();

    if (!transacoes.isEmpty()) {
      return false;
    }

    try {
      TransacaoFinanceira transacao = new TransacaoFinanceira();
      transacao.setId(0);
      transacao.setTipoTransacao(null);
      transacao.setStatus(null);
      transacao.setItens(null);
      transacao.setFormaPg(null);
      transacao.setPessoa(null);

      entityManager().persist(transacao);

      return true;
    } catch (Exception ex) {
      System.out.println("Erro ao cadastrar Transacao ! " + ex.getMessage());
      return false;
    }
  }

  private EntityManager entityManager() {
    return entityManager;
  }

  @Override
  @Transactional
  public List<TransacaoFinanceira> Buscar(TransacaoFinanceira filtro) {
    try {
      String jpql = "select t from transacao_financeira t";

      if (!filtro.getIdentificador().isEmpty()) {
        jpql += "WHERE t.identificador = :identificador";
      }
      Query consulta = getManager().createQuery(jpql);
      if (!filtro.getIdentificador().isEmpty()) {
        consulta.setParameter("Identificador", filtro.getIdentificador());
      }
      return consulta.getResultList();
    } catch (Exception ex) {
      return null;
    }
  }
}
