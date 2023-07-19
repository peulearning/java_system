package br.edu.ifnmg.dsc.extractnorth.entidades;

public class Estoque {

  /* Attributes */
  private Double quantidade;
  private Lote lote;
  private Produto produto;

  /* Getters and Setters */
  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public Lote getLote() {
    return lote;
  }

  public void setLote(Lote lote) {
    this.lote = lote;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
    result = prime * result + ((lote == null) ? 0 : lote.hashCode());
    result = prime * result + ((produto == null) ? 0 : produto.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Estoque other = (Estoque) obj;
    if (quantidade == null) {
      if (other.quantidade != null)
        return false;
    } else if (!quantidade.equals(other.quantidade))
      return false;
    if (lote == null) {
      if (other.lote != null)
        return false;
    } else if (!lote.equals(other.lote))
      return false;
    if (produto == null) {
      if (other.produto != null)
        return false;
    } else if (!produto.equals(other.produto))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Estoque [quantidade=" + quantidade + ", lote=" + lote + ", produto=" + produto + "]";
  }

}
