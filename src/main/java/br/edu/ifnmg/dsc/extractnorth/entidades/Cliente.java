package br.edu.ifnmg.dsc.extractnorth.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente extends Pessoa {

    /* Attributes */

    @Column(length = 14, nullable = false, unique = true)
    private long cnpj;

    @Column(name = "Atividade", length = 255, nullable = false)
    private String atividade;

    @OneToOne
    @JoinColumn(name = "endereco")
    private Endereco endereco;

    /* Constructor */

    public Cliente(long id, String nome, Long telefone, String email, Endereco endereco, long cnpj, String atividade) {
        super(id, nome, telefone, email, endereco);
        this.cnpj = cnpj;
        this.atividade = atividade;
    }

    /* Getters And Setters */

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    /* Java Beans */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int) (cnpj ^ (cnpj >>> 32));
        result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
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
        Cliente other = (Cliente) obj;
        if (cnpj != other.cnpj)
            return false;
        if (atividade == null) {
            if (other.atividade != null)
                return false;
        } else if (!atividade.equals(other.atividade))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [cnpj=" + cnpj + ", atividade=" + atividade + "]";
    }

}
