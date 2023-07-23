package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

  @ManyToOne
  @JoinColumn(name = "produto_id", nullable = false)
  private ArrayList<String> Produto;

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

  public ArrayList<String> getProduto() {
    return Produto;
  }

  public void setProduto(ArrayList<String> produto) {
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
    result = prime * result + ((Produto == null) ? 0 : Produto.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", quantidade=" + quantidade + ", Produto=" + Produto + "]";
  }

}
