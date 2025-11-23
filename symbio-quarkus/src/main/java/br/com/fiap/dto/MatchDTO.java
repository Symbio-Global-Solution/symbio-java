package br.com.fiap.dto;

import java.util.List;

public class MatchDTO {
    private String nomeColaborador;
    private String tituloVaga;
    private double porcentagemMatch; 
    private List<String> skillsEmComum;
    private List<String> skillsFaltantes;

    // Getters e Setters
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public double getPorcentagemMatch() {
        return porcentagemMatch;
    }

    public void setPorcentagemMatch(double porcentagemMatch) {
        this.porcentagemMatch = porcentagemMatch;
    }

    public List<String> getSkillsEmComum() {
        return skillsEmComum;
    }

    public void setSkillsEmComum(List<String> skillsEmComum) {
        this.skillsEmComum = skillsEmComum;
    }

    public List<String> getSkillsFaltantes() {
        return skillsFaltantes;
    }

    public void setSkillsFaltantes(List<String> skillsFaltantes) {
        this.skillsFaltantes = skillsFaltantes;
    }
}