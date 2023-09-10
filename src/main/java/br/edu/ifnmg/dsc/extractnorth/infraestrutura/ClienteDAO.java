package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Cliente;
import br.edu.ifnmg.dsc.extractnorth.servicos.ClienteRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class ClienteDAO extends DAO<Cliente> implements ClienteRepositorio {

  @PersistenceContext
  private EntityManager entityManager;

  public ClienteDAO() {
    super(Cliente.class);
  }

  @Override
  @Transactional
  public boolean Cadastrar(String novoCliente) {
    Query consulta = (Query) getManager().createQuery("select c from Cliente c WHERE c.cpnj = :cnpj");
    consulta.setParameter("cnpj", novoCliente);

    List<Cliente> clientes = consulta.getResultList();

    if (!clientes.isEmpty()) {
      return false;
    }

    try {
      Cliente cliente = new Cliente();
      cliente.setNome(novoCliente);
      cliente.setCnpj(novoCliente);
      cliente.setEmail(novoCliente);
      cliente.setTelefone(novoCliente);
      cliente.setAtividade(novoCliente);

      entityManager().persist(cliente);

      return true;
    } catch (Exception ex) {
      System.out.println("Erro ao cadastrar cliente ! : " + ex.getMessage());
      return false;
    }
  }

  private EntityManager entityManager() {
    return entityManager;
  }

  @Override
  @Transactional
  public List<Cliente> Buscar(Cliente filtro) {
    try {
      String jpql = "select c from Cliente c";

      if (!filtro.getCnpj().isEmpty()) {
        jpql += " WHERE c.cpnj like :cnpj";
      }

      Query consulta = getManager().createQuery(jpql);
      if (!filtro.getCnpj().isEmpty()) {
        consulta.setParameter("cnpj", filtro.getCnpj());
      }
      return consulta.getResultList();
    } catch (Exception ex) {
      return null;
    }

  }

}
