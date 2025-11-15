package br.com.fiap.beans;

public class VagaSkill {

    //Visiblidade, tipo e atributos
    private int id_vaga;
    private int id_skill;
    private int nr_peso;

    //Construtor vazio
    public VagaSkill() {
    }

    // Costrutor Cheio
    public VagaSkill(int id_vaga, int id_skill, int nr_peso) {
        this.id_vaga = id_vaga;
        this.id_skill = id_skill;
        this.nr_peso = nr_peso;
    }

    // Metodo Setter e Getter
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
