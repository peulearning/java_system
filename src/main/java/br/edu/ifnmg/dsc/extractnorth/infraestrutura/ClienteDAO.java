package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Cliente;
import br.edu.ifnmg.dsc.extractnorth.servicos.ClienteRepositorio;

@Service
public class ClienteDAO extends DAO<Cliente> implements ClienteRepositorio {

  public ClienteDAO() {
    super(Cliente.class);
  }

}
