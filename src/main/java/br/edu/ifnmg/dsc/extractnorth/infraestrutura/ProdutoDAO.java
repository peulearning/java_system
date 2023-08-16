package br.edu.ifnmg.dsc.extractnorth.infraestrutura;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.dsc.extractnorth.entidades.Produto;
import br.edu.ifnmg.dsc.extractnorth.servicos.ProdutoRepositorio;

@Service
public class ProdutoDAO extends DAO<Produto> implements ProdutoRepositorio {

  public ProdutoDAO() {
    super(Produto.class);
  }
}
