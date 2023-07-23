package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funcionarios")
public class Funcionario extends Pessoa {

  /* Attributes */

  @Column(length = 11, nullable = true, unique = true)
  protected long cpf;

  @Column(nullable = false)
  protected boolean status;

  /* Constructor */
  public Funcionario(long id, String nome, Long telefone, String email, Endereco endereco, long cpf, boolean status) {
    super(id, nome, telefone, email, endereco);
    this.cpf = cpf;
    this.status = status;
  }

  /* Getters and Setters */
  public long getCpf() {
    return cpf;
  }

  public void setCpf(long cpf) {
    this.cpf = cpf;
  }

  public boolean isStatus() {

    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (int) (cpf ^ (cpf >>> 32));
    result = prime * result + (status ? 1231 : 1237);
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
    Funcionario other = (Funcionario) obj;
    if (cpf != other.cpf)
      return false;
    if (status != other.status)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Funcionario [cpf=" + cpf + ", status=" + status + "]";
  }

}
