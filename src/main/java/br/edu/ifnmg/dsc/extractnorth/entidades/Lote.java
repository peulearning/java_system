package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lotes")
public class Lote {

  /* Attributes */
  private int identificador;
  private String descricao;
  private Produto produto;
  private double quantidade;

  /* Getters and Setters */
  public int getIdentificador() {
    return identificador;
  }

  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(double quantidade) {
    this.quantidade = quantidade;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + identificador;
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((produto == null) ? 0 : produto.hashCode());
    long temp;
    temp = Double.doubleToLongBits(quantidade);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Lote other = (Lote) obj;
    if (identificador != other.identificador)
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (produto == null) {
      if (other.produto != null)
        return false;
    } else if (!produto.equals(other.produto))
      return false;
    if (Double.doubleToLongBits(quantidade) != Double.doubleToLongBits(other.quantidade))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Lote [identificador=" + identificador + ", descricao=" + descricao + ", produto=" + produto
        + ", quantidade=" + quantidade + "]";
  }

}
