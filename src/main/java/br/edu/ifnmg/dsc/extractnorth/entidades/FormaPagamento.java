package br.edu.ifnmg.dsc.extractnorth.entidades;

public enum FormaPagamento {
  PIX(1),
  DINHEIRO(2),
  CARTAO(3);

  private final int formaPg;

  private FormaPagamento(int formaPg) {
    this.formaPg = formaPg;
  }

  public int getFormaPg() {
    return formaPg;
  }
}