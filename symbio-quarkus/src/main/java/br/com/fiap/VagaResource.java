package br.com.fiap;

import br.com.fiap.beans.Vaga;
import br.com.fiap.bo.VagaBO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/vagas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VagaResource {

    @Inject
    VagaBO vagaBO;

    @GET
    public Response listar() {
        try {
            return Response.ok(vagaBO.listar()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Vaga vaga) {
        try {
            vagaBO.cadastrar(vaga);
            return Response.status(Response.Status.CREATED).entity(vaga).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}