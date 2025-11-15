package br.com.fiap.bo;

import br.com.fiap.beans.Cargo;
import br.com.fiap.dao.CargoDAO;
import br.com.fiap.dto.AiRequestDTO;
import br.com.fiap.dto.AiResponseDTO;
import br.com.fiap.dto.CargoCadastroDTO;
import br.com.fiap.service.AiIntegrationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class CargoBO {

    private CargoDAO cargoDAO = new CargoDAO();

    @Inject
    @RestClient
    AiIntegrationService aiService;

    public List<Cargo> listar() throws SQLException, ClassNotFoundException {
        return cargoDAO.selecionar();
    }

    public Cargo cadastrarInteligente(CargoCadastroDTO dto) throws SQLException, ClassNotFoundException {
        // Prepara dados para a IA
        int[] features = {dto.getRepetitividade(), dto.getCriatividade(), dto.getInteracao()};
        AiRequestDTO requestIA = new AiRequestDTO(features);

        // Chama a IA
        String risco = "ANALISE_PENDENTE";
        try {
            System.out.println(">>> SYMBIO: Conectando com a IA no Render...");
            AiResponseDTO responseIA = aiService.preverRisco(requestIA);

            // Verificação de segurança
            if (responseIA != null && responseIA.getRiscoPredito() != null) {
                risco = responseIA.getRiscoPredito();
                System.out.println(">>> SYMBIO SUCESSO: Risco calculado = " + risco);
            } else {
                System.out.println(">>> SYMBIO AVISO: IA retornou resposta vazia.");
            }

        } catch (Exception e) {
            System.err.println(">>> SYMBIO ERRO DE CONEXÃO: " + e.getMessage());
            e.printStackTrace();
        }

        // Cria o objeto Cargo
        Cargo cargo = new Cargo();
        cargo.setNm_cargo(dto.getNm_cargo());
        cargo.setDs_cargo(dto.getDs_cargo());
        cargo.setNivel_risco_ia(risco);

        // Salva no Banco Oracle
        cargoDAO.inserir(cargo);

        return cargo;
    }
}