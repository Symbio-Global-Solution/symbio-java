package br.com.fiap.beans;

public class ColabSkill {

    // Visibilidade, tipo e atributos
    private int id_colaborador;
    private int id_skill;
    private int nr_nivel_proficiencia;

    // Construtor vazio
    public ColabSkill() {
    }

    // Construtor cheio
    public ColabSkill(int id_colaborador, int id_skill, int nr_nivel_proficiencia) {
        this.id_colaborador = id_colaborador;
        this.id_skill = id_skill;
        this.nr_nivel_proficiencia = nr_nivel_proficiencia;
    }

    // Metodo Setter e Getter
    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public int getNr_nivel_proficiencia() {
        return nr_nivel_proficiencia;
    }

    public void setNr_nivel_proficiencia(int nr_nivel_proficiencia) {
        this.nr_nivel_proficiencia = nr_nivel_proficiencia;
    }
}
