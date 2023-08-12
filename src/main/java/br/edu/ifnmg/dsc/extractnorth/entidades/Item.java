package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Item {

  /* Attributes */
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

  @Override
  public String toString() {
    return "Item [id=" + id + ", quantidade=" + quantidade + ", produtos=" + produtos + ", transacao=" + transacao
        + "]";
  }

}
