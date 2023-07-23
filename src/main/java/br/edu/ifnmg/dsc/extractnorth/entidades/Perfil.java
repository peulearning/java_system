package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Perfis")
public class Perfil extends Funcionario {

  /* Attributes */
  @Column(length = 255, nullable = false)
  private String atribuicao;

  /* Constructors */
  public Perfil(long id, String nome, Long telefone, String email, Endereco endereco, long cpf, boolean status,
      String atribuicao) {
    super(id, nome, telefone, email, endereco, cpf, status);
    this.atribuicao = atribuicao;
  }

  /* Getters and Setters */
  public String getAtribuicao() {
    return atribuicao;
  }

  public void setAtribuicao(String atribuicao) {
    this.atribuicao = atribuicao;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((atribuicao == null) ? 0 : atribuicao.hashCode());
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
    Perfil other = (Perfil) obj;
    if (atribuicao == null) {
      if (other.atribuicao != null)
        return false;
    } else if (!atribuicao.equals(other.atribuicao))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Perfil [atribuicao=" + atribuicao + "]";
  }

}
