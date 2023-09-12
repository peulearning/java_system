package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

  @ManyToOne
  private Produto produto;

  @ManyToOne
  private TransacaoFinanceira transacao;

  @Column(precision = 8, scale = 2)
  private BigDecimal valorUnitario;

  @Column(precision = 8, scale = 2)
  private BigDecimal valorTotal;

}
