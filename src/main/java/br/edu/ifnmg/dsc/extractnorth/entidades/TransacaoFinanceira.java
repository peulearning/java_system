package br.edu.ifnmg.dsc.extractnorth.entidades;

import java.util.ArrayList;


public class TransacaoFinanceira {
  private int id;
  private Item itens;
  private FormaPagamento formaPg;
  private ArrayList<Item> items;
  private Pessoa pessoa;
  private Estoque estoque;
  private int TiStatuspoTransacao;
  private StatusTransacao status;

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
  public int getTiStatuspoTransacao() {
    return TiStatuspoTransacao;
  }
  public void setTiStatuspoTransacao(int tiStatuspoTransacao) {
    TiStatuspoTransacao = tiStatuspoTransacao;
  }
  public StatusTransacao getStatus() {
    return status;
  }
  public void setStatus(StatusTransacao status) {
    this.status = status;
  }




}
