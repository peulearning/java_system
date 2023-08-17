package br.edu.ifnmg.dsc.extractnorth.entidades;

public enum TipoTransacao {
  compra(1),
  venda(2);

  private final int TipoTransacao;

  private TipoTransacao(int TipoTransacao) {
    this.TipoTransacao = TipoTransacao;
  }

  public int getTipoTranscao() {
    return TipoTransacao;
  }

}
