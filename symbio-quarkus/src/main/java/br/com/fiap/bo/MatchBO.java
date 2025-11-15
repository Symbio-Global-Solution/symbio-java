package br.com.fiap.bo;

import br.com.fiap.beans.ColabSkill;
import br.com.fiap.beans.Colaborador;
import br.com.fiap.beans.VagaSkill;
import br.com.fiap.dao.ColaboradorDAO;
import br.com.fiap.dao.MatchDAO;
import br.com.fiap.dao.VagaDAO;
import br.com.fiap.dto.MatchDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MatchBO {

    @Inject MatchDAO matchDAO;
    @Inject ColaboradorDAO colaboradorDAO;
    @Inject VagaDAO vagaDAO;

    public MatchDTO calcularMatch(int idColaborador, int idVaga) throws SQLException, ClassNotFoundException {
        // Busca dados
        Colaborador colab = colaboradorDAO.buscarPorId(idColaborador);

        List<VagaSkill> requisitosVaga = matchDAO.buscarSkillsDaVaga(idVaga);
        List<ColabSkill> competenciasColab = matchDAO.buscarSkillsDoColaborador(idColaborador);

        if (requisitosVaga.isEmpty()) {
            MatchDTO dto = new MatchDTO();
            dto.setPorcentagemMatch(100.0);
            dto.setTituloVaga("Vaga sem requisitos");
            return dto;
        }

        // Match
        double pontuacaoMaxima = 0;
        double pontuacaoColaborador = 0;
        List<String> skillsEmComum = new ArrayList<>();
        List<String> skillsFaltantes = new ArrayList<>();

        for (VagaSkill requisito : requisitosVaga) {
            pontuacaoMaxima += (requisito.getNr_peso() * 5.0);

            boolean temSkill = false;
            for (ColabSkill habilidade : competenciasColab) {
                if (habilidade.getId_skill() == requisito.getId_skill()) {
                    pontuacaoColaborador += (requisito.getNr_peso() * habilidade.getNr_nivel_proficiencia());
                    skillsEmComum.add(matchDAO.getNomeSkill(requisito.getId_skill()) + " (Nível " + habilidade.getNr_nivel_proficiencia() + ")");
                    temSkill = true;
                    break;
                }
            }
            if (!temSkill) {
                skillsFaltantes.add(matchDAO.getNomeSkill(requisito.getId_skill()));
            }
        }

        // Calcula Porcentagem
        double porcentagem = 0;
        if (pontuacaoMaxima > 0) {
            porcentagem = (pontuacaoColaborador / pontuacaoMaxima) * 100;
        }

        // Monta o DTO
        MatchDTO resultado = new MatchDTO();
        resultado.setNomeColaborador(colab != null ? colab.getNm_colaborador() : "Desconhecido");
        resultado.setTituloVaga("Vaga ID: " + idVaga);
        resultado.setPorcentagemMatch(Math.round(porcentagem * 100.0) / 100.0);
        resultado.setSkillsEmComum(skillsEmComum);
        resultado.setSkillsFaltantes(skillsFaltantes);

        return resultado;
    }
}