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
@DiscriminatorValue(value = "2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends Pessoa {

  /* Attributes */
  @Column(length = 11, nullable = true, unique = true)
  private String cpf;

  @Override
  public String toString() {
    return "Fornecedor [cpf=" + cpf + "]";
  }

}
