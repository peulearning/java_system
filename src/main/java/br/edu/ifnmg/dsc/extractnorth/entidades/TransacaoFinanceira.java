package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Transacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TransacaoFinanceira {

  /* Attributes */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  @Override
  public String toString() {
    return "TransacaoFinanceira [id=" + id + ", itens=" + itens + ", formaPg=" + formaPg
        + ", pessoa=" + pessoa + ", estoque=" + estoque + ", status=" + status
        + "]";
  }

}
