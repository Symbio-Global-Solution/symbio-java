package br.com.fiap.beans;

import java.util.Date;

public class Vaga {

    //Atributos
    private int id_vaga;
    private String ds_titulo;
    private Date dt_abertura;
    private String st_vaga;

    //Construtores


    public Vaga() {
    }

    public Vaga(int id_vaga, String ds_titulo, Date dt_abertura, String st_vaga) {
        this.id_vaga = id_vaga;
        this.ds_titulo = ds_titulo;
        this.dt_abertura = dt_abertura;
        this.st_vaga = st_vaga;
    }

    public int getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(int id_vaga) {
        this.id_vaga = id_vaga;
    }

    public String getDs_titulo() {
        return ds_titulo;
    }

    public void setDs_titulo(String ds_titulo) {
        this.ds_titulo = ds_titulo;
    }

    public Date getDt_abertura() {
        return dt_abertura;
    }

    public void setDt_abertura(Date dt_abertura) {
        this.dt_abertura = dt_abertura;
    }

    public String getSt_vaga() {
        return st_vaga;
    }

    public void setSt_vaga(String st_vaga) {
        this.st_vaga = st_vaga;
    }
}
