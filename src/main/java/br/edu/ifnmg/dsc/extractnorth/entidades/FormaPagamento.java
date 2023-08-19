package br.edu.ifnmg.dsc.extractnorth.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FormaPagamento {

  PIX(1),
  DINHEIRO(2),
  CARTAO(3);

  private final int formaPg;

}