package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pessoas")
@DiscriminatorColumn(name = "perfil")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pessoa {

  /* Attributes */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int perfil;

  @Column(name = "nome", length = 500, nullable = false)
  protected String nome;

  @Column(name = "telefone", length = 255, nullable = false)
  protected String telefone;

  @Column(name = "email", length = 255, nullable = false)
  protected String email;

  @OneToOne(mappedBy = "pessoa")
  protected Endereco endereco;
}
