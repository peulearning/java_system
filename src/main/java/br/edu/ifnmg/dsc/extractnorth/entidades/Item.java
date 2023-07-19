package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;



public class Item {
  private int id;
  private double quantidade;
  private ArrayList<String> Produto;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(double quantidade) {
    this.quantidade = quantidade;
  }

  public ArrayList<String> getProduto() {
    return Produto;
  }

  public void setProduto(ArrayList<String> produto) {
    Produto = produto;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    long temp;
    temp = Double.doubleToLongBits(quantidade);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((Produto == null) ? 0 : Produto.hashCode());
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
    Item other = (Item) obj;
    if (id != other.id)
      return false;
    if (Double.doubleToLongBits(quantidade) != Double.doubleToLongBits(other.quantidade))
      return false;
    if (Produto == null) {
      if (other.Produto != null)
        return false;
    } else if (!Produto.equals(other.Produto))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", quantidade=" + quantidade + ", Produto=" + Produto + "]";
  }


}
