package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Lotes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Lote {

  /* Attributes */
  @Id
  @Column(nullable = false)
  private int identificador;

  @Column(length = 255, nullable = false)
  private String descricao;

  @ManyToOne
  @JoinColumn(name = "id_produto")
  private Produto produto;

  @Column(nullable = false)
  private double quantidade;

}
