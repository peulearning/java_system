package br.edu.ifnmg.dsc.extractnorth.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusTransacao {
  emAberto(1),
  paga(2),
  cancelada(3),
  entregue(4),
  devolucao(5);

  private final int StatusTransacao;

}
