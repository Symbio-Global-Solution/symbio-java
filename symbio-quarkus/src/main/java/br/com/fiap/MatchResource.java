package br.com.fiap;

import br.com.fiap.bo.MatchBO;
import br.com.fiap.dto.MatchDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/match")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatchResource {

    @Inject
    MatchBO matchBO;

    @GET
    @Path("/{idColaborador}/{idVaga}")
    public Response verificarMatch(@PathParam("idColaborador") int idColaborador,
                                   @PathParam("idVaga") int idVaga) {
        try {
            MatchDTO resultado = matchBO.calcularMatch(idColaborador, idVaga);
            return Response.ok(resultado).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao calcular match: " + e.getMessage()).build();
        }
    }
}