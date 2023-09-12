package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TransacaoFinanceira {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String identificador;

  @Enumerated(EnumType.ORDINAL)
  private FormaPagamento formaPg;

  @OneToMany(mappedBy = "transacao", cascade = CascadeType.ALL)
  private ArrayList<Item> itens;

  @ManyToOne
  private Pessoa pessoa;

  @ManyToOne
  private Estoque estoque;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private TipoTransacao tipoTransacao;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private StatusTransacao status;

  @Column(precision = 8, scale = 2)
  private BigDecimal valor;

}
