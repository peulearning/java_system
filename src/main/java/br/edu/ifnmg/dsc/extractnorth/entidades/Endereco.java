package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Endereco {

  /* Atttibutes */
  @Column(name = "rua", length = 255)
  private String rua;

  @Column(name = "bairro", length = 255)
  private String bairro;

  @Column(name = "cidade", length = 255)
  private String cidade;

  @Id
  @OneToOne(mappedBy = "endereco")
  private Pessoa pessoa;

  @Override
  public String toString() {
    return "Endereco [rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + "]";
  }
}
