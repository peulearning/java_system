package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Funcionario;
import br.edu.ifnmg.dsc.extractnorth.servicos.FuncionarioRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioDAO extends DAO<Funcionario> implements FuncionarioRepositorio {

  @PersistenceContext
  private EntityManager entityManager;

  public FuncionarioDAO() {
    super(Funcionario.class);
  }

  @Override
  @Transactional
  public boolean Cadastrar(String novoFuncionaro) {
    Query consulta = (Query) getManager().createQuery("select f FROM Funcionario f WHERE f.cpf = :cpf");
    consulta.setParameter("cpf", novoFuncionaro);

    List<Funcionario> funcionarios = consulta.getResultList();

    if (!funcionarios.isEmpty()) {
      return false;
    }

    try {
      Funcionario funcionario = new Funcionario();
      funcionario.setNome(novoFuncionaro);
      funcionario.setCpf(novoFuncionaro);
      funcionario.setEmail(novoFuncionaro);
      funcionario.setTelefone(novoFuncionaro);
      funcionario.setStatus(false);
      funcionario.setSalario(null);

      entityManager().persist(funcionario);

      return true;
    } catch (Exception ex) {
      System.out.println("Erro ao cadastrar funcionário: " + ex.getMessage());
      return false;
    }
  }

  private EntityManager entityManager() {
    return entityManager;
  }

  @Override
  @Transactional
  public List<Funcionario> Buscar(Funcionario filtro) {
    try {
      String jpql = "select f from Funcionario f";

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
