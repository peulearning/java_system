package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Lote {

  @Id
  @Column(nullable = false)
  private int identificador;

  @Column(nullable = false)
  private String descricao;

  @ManyToOne
  @JoinColumn(name = "id_produto")
  private Produto produto;

  @Column(nullable = false)
  private double quantidade;

}
