package br.com.fiap.beans;

public class Skill {
    // Visibilidade, tipo e atributo
    private int id_skill;
    private String nm_skill;
    private String tp_skill;
    private String ds_skill;

    // Construtor vazio
    public Skill() {}

    //Construtor cheio
    public Skill(int id_skill, String nm_skill, String tp_skill, String ds_skill) {
        this.id_skill = id_skill;
        this.nm_skill = nm_skill;
        this.tp_skill = tp_skill;
        this.ds_skill = ds_skill;
    }

    // Metodo Setter e Getter
    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public String getNm_skill() {
        return nm_skill;
    }

    public void setNm_skill(String nm_skill) {
        this.nm_skill = nm_skill;
    }

    public String getTp_skill() {
        return tp_skill;
    }

    public void setTp_skill(String tp_skill) {
        this.tp_skill = tp_skill;
    }

    public String getDs_skill() {
        return ds_skill;
    }

    public void setDs_skill(String ds_skill) {
        this.ds_skill = ds_skill;
    }
}