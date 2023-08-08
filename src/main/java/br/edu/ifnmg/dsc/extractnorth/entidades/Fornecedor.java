package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Fornecedores")
public class Fornecedor extends Pessoa {

  /* Attributes */

  @Column(length = 11, nullable = true, unique = true)
  private long cpf;

  @OneToOne
  @JoinColumn(name = "endereco")
  private Endereco endereco;

  /* Constructor */
  public Fornecedor(long id, String nome, Long telefone, String email, Endereco endereco, long cpf) {
    super(id, nome, telefone, email, endereco);
    this.cpf = cpf;
  }

  /* Getters and Setters */
  public long getCpf() {
    return cpf;
  }

  public void setCpf(long cpf) {
    this.cpf = cpf;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (int) (cpf ^ (cpf >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Fornecedor other = (Fornecedor) obj;
    if (cpf != other.cpf)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Fornecedor [cpf=" + cpf + "]";
  }

}
