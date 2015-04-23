package br.com.cepserver.rest.service;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.cepconsumer.entities.Endereco;

@Path("/endereco")
public class EnderecoCrudService implements Serializable {
	private static final long serialVersionUID = -2434608870284261408L;
	
	@POST
	@Path("incluir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response incluirEndereco(@Valid Endereco endereco) {
		return null;
	}
	
	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarEndereco(@Valid Endereco endereco) {
		return null;
	}
	
	@GET
	@Path("buscar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarEndereco(@PathParam("id")
		@Min(1) int id) {
		return null;
	}
	
	@DELETE
	@Path("excluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirEndereco(@PathParam("id")
		@Min(1) int id) {
		return null;
	}
}