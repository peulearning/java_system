package br.edu.ifnmg.dsc.extractnorth.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoTransacao {

  compra(1),
  venda(2);

  private final int TipoTransacao;

}
