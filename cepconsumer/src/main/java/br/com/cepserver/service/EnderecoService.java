package br.com.cepserver.service;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cepconsumer.dao.impl.EnderecoDAO;
import br.com.cepconsumer.entities.Endereco;
import br.com.cepconsumer.rest.client.CepClient;
import br.com.cepserver.rest.exception.CepServiceException;

/**
 * Classe que implementa o acesso à dados e o consumo do serviço de busca de cep
 * para validaçoes
 * 
 * @author Gabz
 *
 */
public class EnderecoService {

	@Inject
	private CepClient cepClient;

	@Inject
	private EnderecoDAO daoEndereco;

	/**
	 * Incluí um endereço apenas se o cep informado existir. Validação realizada
	 * consumindo o serviço de busca de cep. Se der algum erro no consumo do
	 * serviço retorna a mensagem de erro informada no serviço.
	 * 
	 * @param cep
	 * @return response OK se gravou ou a mensagem retornada do serviço
	 */
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

	/**
	 * Busca um endereço, se ele existir então devemos alterar, se não devemos
	 * incluir, para isso chamamos o método de inserção que fizemos pois o mesmo
	 * já realiza a validação se o cep é válido etc.
	 * 
	 * @param endereco
	 * @return response
	 */
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