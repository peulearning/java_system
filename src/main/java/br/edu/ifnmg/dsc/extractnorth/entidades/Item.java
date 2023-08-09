package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

  @ManyToMany
  @JoinTable(name = "item_produto", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
  private List<Produto> produtos = new ArrayList<>();

  @ManyToOne
  private TransacaoFinanceira transacao;

  /* Constructor */
  public Item(int id, double quantidade, List<Produto> produtos) {
    this.id = id;
    this.quantidade = quantidade;
    this.produtos = produtos;
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
    return "Item [id=" + id + ", quantidade=" + quantidade + ", produtos=" + produtos + "]";
  }

}
