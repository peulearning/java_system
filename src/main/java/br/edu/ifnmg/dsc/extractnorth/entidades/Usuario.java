package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {

  /* Attributes */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 50, unique = true, nullable = false)
  private String login;

  @Column(nullable = false)
  private String senha;

  @Column(length = 255, nullable = false)
  private String atribuicao;

  @OneToOne
  @JoinColumn(name = "id_funcionario")
  private Funcionario funcionario;

  /* Constructor */
  public Usuario(long id, String login, String senha, String atribuicao, Funcionario funcionario) {
    this.id = id;
    this.login = login;
    this.senha = senha;
    this.atribuicao = atribuicao;
    this.funcionario = funcionario;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getAtribuicao() {
    return atribuicao;
  }

  public void setAtribuicao(String atribuicao) {
    this.atribuicao = atribuicao;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  /* Java Beans */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((login == null) ? 0 : login.hashCode());
    result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
    Usuario other = (Usuario) obj;
    if (id != other.id)
      return false;
    if (login == null) {
      if (other.login != null)
        return false;
    } else if (!login.equals(other.login))
      return false;
    if (senha == null) {
      if (other.senha != null)
        return false;
    } else if (!senha.equals(other.senha))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Usuario [login=" + login + ", atribuicao=" + atribuicao + ", funcionario=" + funcionario + "]";
  }

}
