package br.com.fiap;

import br.com.fiap.beans.Cargo;
import br.com.fiap.bo.CargoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/cargo")
public class CargoResource {

    CargoBO cargoBO = new CargoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cargo> selecionarRs() throws SQLException, ClassNotFoundException {
        return  (ArrayList<Cargo>) cargoBO.selecionarBo();
    }

    //Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Cargo cargo, @Context UriInfo uriInfo ) throws SQLException, ClassNotFoundException {
        cargoBO.inserirBo(cargo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(cargo.getId_cargo()));
        return Response.created(builder.build()).build();
    }

    //Deletar
    @DELETE
    @Path("{/codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        cargoBO.deletarBo(codigo);
        return Response.ok().build();
    }

    //Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Cargo cargo, @PathParam("id") int id) throws SQLException, ClassNotFoundException {
        cargoBO.atualizarBo(cargo);
        return Response.ok().build();
    }

}