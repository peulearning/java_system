package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value = "3")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Pessoa {

  /* Attributes */

  @Column(length = 11, nullable = true, unique = true)
  protected String cpf;

  @Column(nullable = false)
  protected boolean status;

  @Column(nullable = false)
  protected Double salario;

  @Override
  public String toString() {
    return "Funcionario [cpf=" + cpf + ", status=" + status + ", endereco=" + endereco + "]";
  }

}
