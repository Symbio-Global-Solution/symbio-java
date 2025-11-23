package br.com.fiap.service;

import br.com.fiap.dto.AiRequestDTO;
import br.com.fiap.dto.AiResponseDTO;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/prever")
@RegisterRestClient(configKey = "ai-api")
public interface AiIntegrationService {

    @POST
    @Path("/risco") 
    AiResponseDTO preverRisco(AiRequestDTO request);
}