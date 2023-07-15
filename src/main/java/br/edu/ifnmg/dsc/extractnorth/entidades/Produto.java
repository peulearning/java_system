package br.edu.ifnmg.dsc.extractnorth.entidades;

public class Produto {
  private String nome;
  private double preco;



  public Produto(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    long temp;
    temp = Double.doubleToLongBits(preco);
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
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Produto [nome=" + nome + ", preco=" + preco + "]";
  }


}
