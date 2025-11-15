package br.com.fiap.dto;

public class CargoCadastroDTO {
    private String nm_cargo;
    private String ds_cargo;
    // Dados para a IA
    private int repetitividade;
    private int criatividade;
    private int interacao;

    public String getNm_cargo() {
        return nm_cargo;
    }

    public void setNm_cargo(String nm_cargo) {
        this.nm_cargo = nm_cargo;
    }

    public String getDs_cargo() {
        return ds_cargo;
    }

    public void setDs_cargo(String ds_cargo) {
        this.ds_cargo = ds_cargo;
    }

    public int getRepetitividade() {
        return repetitividade;
    }

    public void setRepetitividade(int repetitividade) {
        this.repetitividade = repetitividade;
    }

    public int getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }

    public int getInteracao() {
        return interacao;
    }

    public void setInteracao(int interacao) {
        this.interacao = interacao;
    }
}