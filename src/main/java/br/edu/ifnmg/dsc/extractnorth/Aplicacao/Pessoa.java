package br.edu.ifnmg.dsc.extractnorth.Aplicacao;

public class Pessoa {
    protected String nome;
    protected Long telefone;
    protected String email;


    public Pessoa () {
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
    }

    public String getNome() {
      return nome;
    }

    public Long getTelefone() {
      return telefone;
    }

    public String getEmail() {
      return email;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public void setTelefone(Long telefone) {
      this.telefone = telefone;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
      Pessoa other = (Pessoa) obj;
      if (nome == null) {
        if (other.nome != null)
          return false;
      } else if (!nome.equals(other.nome))
        return false;
      return true;
    }

    @Override
    public String toString() {
      return "Pessoa [nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
    }



}
