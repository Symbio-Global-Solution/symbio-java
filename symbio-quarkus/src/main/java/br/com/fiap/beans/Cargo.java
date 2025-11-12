package br.com.fiap.beans;

public class Cargo {

    //Atributos
    private int id_cargo;
    private String nm_cargo;
    private String ds_cargo;
    private String nivel_risco_ia;

    //Construtores
    public Cargo() {
    }

    public Cargo(int id_cargo, String nm_cargo, String ds_cargo, String nivel_risco_ia) {
        this.id_cargo = id_cargo;
        this.nm_cargo = nm_cargo;
        this.ds_cargo = ds_cargo;
        this.nivel_risco_ia = nivel_risco_ia;
    }

    //Getter e Setters
    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

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

    public String getNivel_risco_ia() {
        return nivel_risco_ia;
    }

    public void setNivel_risco_ia(String nivel_risco_ia) {
        this.nivel_risco_ia = nivel_risco_ia;
    }
}
