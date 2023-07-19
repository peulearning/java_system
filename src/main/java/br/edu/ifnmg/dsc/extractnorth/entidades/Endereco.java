package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pessoas")
public class Endereco extends Pessoa {

  /* Atttibutes */
  @Column(name = "rua", length = 255)
  private String rua;

  @Column(name = "bairro", length = 255)
  private String bairro;

  @Column(name = "cidade", length = 255)
  private String cidade;


  /* Construct */
  public Endereco(long id, String nome, Long telefone, String email, Endereco endereco, String rua, String bairro,
      String cidade) {
    super(id, nome, telefone, email, endereco);
    this.rua = rua;
    this.bairro = bairro;
    this.cidade = cidade;
  }

  /* Getters and Setters */
  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  /* Java Beans */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((rua == null) ? 0 : rua.hashCode());
    result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
    result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
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
    Endereco other = (Endereco) obj;
    if (rua == null) {
      if (other.rua != null)
        return false;
    } else if (!rua.equals(other.rua))
      return false;
    if (bairro == null) {
      if (other.bairro != null)
        return false;
    } else if (!bairro.equals(other.bairro))
      return false;
    if (cidade == null) {
      if (other.cidade != null)
        return false;
    } else if (!cidade.equals(other.cidade))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return "Endereco [rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + "]";
  }


}
