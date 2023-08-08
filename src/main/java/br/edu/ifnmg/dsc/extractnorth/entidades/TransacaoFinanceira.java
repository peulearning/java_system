package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transacoes")
public class TransacaoFinanceira {

  /* Attributes */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Item itens;

  @ManyToOne
  private FormaPagamento formaPg;

  @OneToMany(mappedBy = "Transacoes", cascade = CascadeType.ALL)
  private ArrayList<Item> items;

  @ManyToOne
  private Pessoa pessoa;

  @ManyToOne
  private Estoque estoque;

  @Column(nullable = false)
  private int TipoTransacao;

  @Column(nullable = false)
  private StatusTransacao status;

  /* Getters and Setters */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Item getItens() {
    return itens;
  }

  public void setItens(Item itens) {
    this.itens = itens;
  }

  public FormaPagamento getFormaPg() {
    return formaPg;
  }

  public void setFormaPg(FormaPagamento formaPg) {
    this.formaPg = formaPg;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Estoque getEstoque() {
    return estoque;
  }

  public void setEstoque(Estoque estoque) {
    this.estoque = estoque;
  }

  public int getTipoTransacao() {
    return TipoTransacao;
  }

  public void setTipoTransacao(int TipoTransacao) {
    this.TipoTransacao = TipoTransacao;
  }

  public StatusTransacao getStatus() {
    return status;
  }

  public void setStatus(StatusTransacao status) {
    this.status = status;
  }

  /* Java Beans */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((itens == null) ? 0 : itens.hashCode());
    result = prime * result + ((formaPg == null) ? 0 : formaPg.hashCode());
    result = prime * result + ((items == null) ? 0 : items.hashCode());
    result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
    result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
    result = prime * result + TipoTransacao;
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TransacaoFinanceira other = (TransacaoFinanceira) obj;
    if (id != other.id)
      return false;
    if (itens == null) {
      if (other.itens != null)
        return false;
    } else if (!itens.equals(other.itens))
      return false;
    if (formaPg == null) {
      if (other.formaPg != null)
        return false;
    } else if (!formaPg.equals(other.formaPg))
      return false;
    if (items == null) {
      if (other.items != null)
        return false;
    } else if (!items.equals(other.items))
      return false;
    if (pessoa == null) {
      if (other.pessoa != null)
        return false;
    } else if (!pessoa.equals(other.pessoa))
      return false;
    if (estoque == null) {
      if (other.estoque != null)
        return false;
    } else if (!estoque.equals(other.estoque))
      return false;
    if (TipoTransacao != other.TipoTransacao)
      return false;
    if (status != other.status)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TransacaoFinanceira [id=" + id + ", itens=" + itens + ", formaPg=" + formaPg + ", items=" + items
        + ", pessoa=" + pessoa + ", estoque=" + estoque + ", TipoTransacao=" + TipoTransacao + ", status=" + status
        + "]";
  }

}
