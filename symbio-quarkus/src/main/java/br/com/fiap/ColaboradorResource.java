package br.com.fiap;

import br.com.fiap.beans.Colaborador;
import br.com.fiap.bo.ColaboradorBO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/colaboradores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ColaboradorResource {

    private ColaboradorBO colaboradorBO = new ColaboradorBO();

    @GET
    public Response selecionarTodos() {
        try {
            List<Colaborador> lista = colaboradorBO.selecionarBo();
            return Response.ok(lista).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar colaboradores: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        try {
            Colaborador c = colaboradorBO.buscarPorIdBo(id);
            if (c == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Colaborador não encontrado").build();
            }
            return Response.ok(c).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar colaborador: " + e.getMessage()).build();
        }
    }

    @POST
    public Response inserir(Colaborador colaborador) {
        try {
            colaboradorBO.inserirBo(colaborador);
            return Response.status(Response.Status.CREATED).entity(colaborador).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao inserir colaborador: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Colaborador colaborador) {
        try {
            colaborador.setId_colaborador(id); // Garante que o ID da URL seja usado
            colaboradorBO.atualizarBo(colaborador);
            return Response.ok(colaborador).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar colaborador: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        try {
            colaboradorBO.deletarBo(id);
            return Response.noContent().build(); // 204
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar colaborador: " + e.getMessage()).build();
        }
    }
}