package br.edu.ifnmg.dsc.extractnorth.entidades;

public enum StatusTransacao {
  emAberto(1),
  paga(2),
  cancelada(3),
  entregue(4),
  devolucao(5);

  private final int StatusTransacao;

  private StatusTransacao(int StatusTransacao) {
    this.StatusTransacao = StatusTransacao;
  }

  public int getStatusTransacao() {
    return StatusTransacao;
  }
}
