package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estoques")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Estoque {

  /* Attributes */
  @Id
  @Column(nullable = false)
  private Double quantidade;

  @ManyToOne
  private Lote lote;

  @ManyToOne
  private Produto produto;

  @Override
  public String toString() {
    return "Estoque [quantidade=" + quantidade + ", lote=" + lote + ", produto=" + produto + "]";
  }

}
