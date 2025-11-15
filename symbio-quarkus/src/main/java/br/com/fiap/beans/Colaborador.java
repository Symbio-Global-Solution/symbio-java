package br.com.fiap.beans;

import java.time.LocalDate;
import java.util.Date;

public class Colaborador {

    // Visibilidadem, tipo e atributos
    private int id_colaborador;
    private String nm_colaborador;
    private String ds_email;
    private LocalDate dt_admissao;
    private double salario;
    private int id_cargo;

    // Construtor vazio
    public Colaborador() {
    }

    // Construtor Cheio
    public Colaborador(int id_colaborador, String nm_colaborador, String ds_email, LocalDate dt_admissao, double salario, int id_cargo) {
        this.id_colaborador = id_colaborador;
        this.nm_colaborador = nm_colaborador;
        this.ds_email = ds_email;
        this.dt_admissao = dt_admissao;
        this.salario = salario;
        this.id_cargo = id_cargo;
    }

    // Metodo Setter e Getter
    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public String getNm_colaborador() {
        return nm_colaborador;
    }

    public void setNm_colaborador(String nm_colaborador) {
        this.nm_colaborador = nm_colaborador;
    }

    public String getDs_email() {
        return ds_email;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public LocalDate getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(LocalDate dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
}
