package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private double quantidade;

  @ManyToMany
  @JoinTable(name = "item_produto", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
  private List<Produto> produtos = new ArrayList<>();

  @ManyToOne
  private TransacaoFinanceira transacao;

}
