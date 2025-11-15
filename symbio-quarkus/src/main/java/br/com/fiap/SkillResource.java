package br.com.fiap;

import br.com.fiap.beans.Skill;
import br.com.fiap.bo.SkillBO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/skills")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SkillResource {

    @Inject
    SkillBO skillBO;

    @GET
    public Response listar() {
        try {
            return Response.ok(skillBO.listar()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Skill skill) {
        try {
            skillBO.cadastrar(skill);
            return Response.status(Response.Status.CREATED).entity(skill).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}