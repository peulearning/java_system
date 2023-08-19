package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private double precoCompra;

  @Column(nullable = false)
  private double precoVenda;

  @OneToMany(mappedBy = "produto")
  private Collection<Lote> lote;

}
