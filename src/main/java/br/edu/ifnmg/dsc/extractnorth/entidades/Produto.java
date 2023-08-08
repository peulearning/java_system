package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produto {

  /* Attributes */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 255, nullable = false)
  private String nome;

  @Column(nullable = false)
  private double precoCompra;

  @Column(nullable = false)
  private double precoVenda;

  /* Constructor */
  public Produto(int id, String nome, double precoCompra, double precoVenda) {
    this.id = id;
    this.nome = nome;
    this.precoCompra = precoCompra;
    this.precoVenda = precoVenda;
  }

  /* Getters and Setters */

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPrecoCompra() {
    return precoCompra;
  }

  public void setPrecoCompra(double precoCompra) {
    this.precoCompra = precoCompra;
  }

  public double getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(double precoVenda) {
    this.precoVenda = precoVenda;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    long temp;
    temp = Double.doubleToLongBits(precoCompra);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(precoVenda);
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
    Produto other = (Produto) obj;
    if (id != other.id)
      return false;
    if (Double.doubleToLongBits(precoCompra) != Double.doubleToLongBits(other.precoCompra))
      return false;
    if (Double.doubleToLongBits(precoVenda) != Double.doubleToLongBits(other.precoVenda))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Produto [nome=" + nome + "]";
  }

}
