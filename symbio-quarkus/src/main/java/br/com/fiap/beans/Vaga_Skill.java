package br.com.fiap.beans;

public class Vaga_Skill {

    //Atributos
    private int id_vaga;
    private int id_skill;
    private int nr_peso;

    //Construtores


    public Vaga_Skill() {
    }

    public Vaga_Skill(int id_vaga, int id_skill, int nr_peso) {
        this.id_vaga = id_vaga;
        this.id_skill = id_skill;
        this.nr_peso = nr_peso;
    }

    public int getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(int id_vaga) {
        this.id_vaga = id_vaga;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public int getNr_peso() {
        return nr_peso;
    }

    public void setNr_peso(int nr_peso) {
        this.nr_peso = nr_peso;
    }
}
