package br.edu.ifnmg.dsc.extractnorth.entidades;

public class Funcionario extends Pessoa {
  protected long cpf;
  protected boolean status;

  public long getCpf() {
    return cpf;
  }

  public void setCpf(long cpf) {
    this.cpf = cpf;
  }

  public boolean isStatus() {


    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}


