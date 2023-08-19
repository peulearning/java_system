package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Funcionario extends Pessoa {

  @Column(length = 11, unique = true)
  protected String cpf;

  @Column(nullable = false)
  protected boolean status;

  @Column(nullable = false)
  protected Double salario;

}
