package br.edu.ifnmg.dsc.extractnorth.entidades;

public class Cliente extends Pessoa {
    private long cnpj;
    private String atividade;



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
}

