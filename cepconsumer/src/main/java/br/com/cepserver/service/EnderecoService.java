package br.com.cepserver.service;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cepconsumer.dao.impl.EnderecoDAO;
import br.com.cepconsumer.entities.Endereco;
import br.com.cepconsumer.rest.client.CepClient;
import br.com.cepserver.rest.exception.CepServiceException;

public class EnderecoService {

	@Inject
	private CepClient cepClient;

	@Inject
	private EnderecoDAO daoEndereco;

	public Response incluirEndereco(String cep) {
		Endereco endereco = null;
		Response response = null;

		try {
			endereco = cepClient.buscarEnderecoPorCep(cep);
			response = Response.ok(daoEndereco.inserir(endereco)).build();
		} catch (CepServiceException e) {
			response = Response.status(Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}

		return response;
	}

	public Response alterarEndereco(Endereco endereco) {
		Response response = null;

		response = this.buscarEndereco(endereco.getId());
		
		if (response.getStatus() == Status.OK.getStatusCode()) {
			response = Response.ok(daoEndereco.atualizar(endereco)).build();
		} else {
			response = this.incluirEndereco(endereco.getCep());
		}

		return response;
	}

	public Response buscarEndereco(int id) {
		Endereco endereco = daoEndereco.localizar(id);
		Response response = null;

		if (endereco == null) {
			response = Response.status(Status.NOT_FOUND)
					.entity("Endereço com esse ID não encontrado!").build();
		} else {
			response = Response.ok(endereco).build();
		}

		return response;
	}

	public Response excluirEndereco(int id) {
		Response response = null;
		try {
			daoEndereco.excluir(id);
			response = Response.ok().build();
		} catch (NotFoundException e) {
			response = Response.status(Status.NOT_FOUND)
					.entity("Endereço com esse ID não encontrado!").build();
		}
		return response;
	}
}