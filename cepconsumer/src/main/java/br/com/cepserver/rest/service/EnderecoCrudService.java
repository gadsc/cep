package br.com.cepserver.rest.service;

import java.io.Serializable;

import javax.inject.Inject;
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

import br.com.cepconsumer.dao.DAO;
import br.com.cepconsumer.entities.Endereco;

@Path("/endereco")
public class EnderecoCrudService implements Serializable {
	private static final long serialVersionUID = -2434608870284261408L;

	@Inject
	private DAO<Endereco> daoEndereco;

	@POST
	@Path("incluir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response incluirEndereco(@Valid Endereco endereco) {
		return Response.ok(daoEndereco.adicionar(endereco)).build();
	}

	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarEndereco(@Valid Endereco endereco) {
		return Response.ok(daoEndereco.atualizar(endereco)).build();
	}

	@GET
	@Path("buscar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarEndereco(@PathParam("id") @Min(1) int id) {
		return Response.ok(daoEndereco.pesquisarPorId(id)).build();
	}

	@DELETE
	@Path("excluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirEndereco(@PathParam("id") @Min(1) int id) {
		daoEndereco.apagarPorId(id);
		return Response.ok().build();
	}
}