package br.edu.ifnmg.dsc.extractnorth.entidades;

public class Perfil extends Funcionario{
  private String atribuicao;


  public Perfil(String atribuicao) {
    this.atribuicao = atribuicao;
  }

  public String getAtribuicao() {
    return atribuicao;
  }

  public void setAtribuicao(String atribuicao) {
    this.atribuicao = atribuicao;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((atribuicao == null) ? 0 : atribuicao.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Perfil other = (Perfil) obj;
    if (atribuicao == null) {
      if (other.atribuicao != null)
        return false;
    } else if (!atribuicao.equals(other.atribuicao))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Perfil [atribuicao=" + atribuicao + "]";
  }


}
