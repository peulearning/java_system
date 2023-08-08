package br.edu.ifnmg.dsc.extractnorth.entidades;

import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {

  /* Attributes */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private double quantidade;

  @OneToMany
  @Column(name = "id_produtos")
  private List Produto;

  /* Constructor */
  public Item(int id, double quantidade, List produto) {
    this.id = id;
    this.quantidade = quantidade;
    Produto = produto;
  }

  /* Getters and Setters */
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

  public List getProduto() {
    return Produto;
  }

  public void setProduto(List produto) {
    Produto = produto;
  }

  /* Java Beans */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
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
    Item other = (Item) obj;
    if (id != other.id)
      return false;
    if (Double.doubleToLongBits(quantidade) != Double.doubleToLongBits(other.quantidade))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Item [Produto=" + Produto + "]";
  }

}
