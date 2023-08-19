package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 50, unique = true, nullable = false)
  private String login;

  @Column(nullable = false)
  private String senha;

  @Column(nullable = false)
  private String atribuicao;

  @OneToOne
  @JoinColumn(name = "id_funcionario")
  private Funcionario funcionario;

}
