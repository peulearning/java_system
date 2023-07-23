package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "FormaPagamentos")
public class FormaPagamento extends TransacaoFinanceira {
  public int dinheiro = 1;
  public int pix = 2;
  public int cartao = 3;
}
