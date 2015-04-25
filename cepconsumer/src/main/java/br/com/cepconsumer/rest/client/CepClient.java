package br.com.cepconsumer.rest.client;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.cepconsumer.entities.Endereco;
import br.com.cepconsumer.rest.constants.URIConstants;
import br.com.cepconsumer.rest.enums.JsonEnderecoKeys;
import br.com.cepserver.rest.exception.CepServiceException;

import com.google.gson.JsonObject;

public class CepClient {
	@Inject
	private RestClient restClient;

	public Endereco buscarEnderecoPorCep(String cep) throws CepServiceException {
		Endereco endereco = null;

		UriBuilder uri = null;
		Response response = null;

		uri = UriBuilder.fromPath(URIConstants.BUSCAR_CEP).path(cep);
		response = restClient.getResponseFromService(uri);

		if (Status.OK.getStatusCode() == response.getStatus()) {
			endereco = this.jsonToEndereco(restClient
					.getJsonFromResponse(response));
		} else {
			throw new CepServiceException(response.readEntity(String.class));
		}

		return endereco;
	}

	private Endereco jsonToEndereco(JsonObject jsonEndereco) {
		Endereco endereco = new Endereco();

		endereco.setBairro(jsonEndereco.get(JsonEnderecoKeys.BAIRRO.toString())
				.isJsonNull() ? null : jsonEndereco.get(
				JsonEnderecoKeys.BAIRRO.toString()).getAsString());
		endereco.setCep(jsonEndereco.get(JsonEnderecoKeys.CEP.toString())
				.getAsString());
		endereco.setCidade(jsonEndereco.get(JsonEnderecoKeys.CIDADE.toString())
				.getAsJsonObject().get(JsonEnderecoKeys.NOME.toString())
				.getAsString());
		endereco.setComplemento(jsonEndereco.get(
				JsonEnderecoKeys.COMPLEMENTO.toString()).isJsonNull() ? null
				: jsonEndereco.get(JsonEnderecoKeys.COMPLEMENTO.toString())
						.getAsString());
		endereco.setEstado(jsonEndereco.get(JsonEnderecoKeys.CIDADE.toString())
				.getAsJsonObject().get(JsonEnderecoKeys.ESTADO.toString())
				.getAsJsonObject().get(JsonEnderecoKeys.NOME.toString())
				.getAsString());
		endereco.setNumero(jsonEndereco.get(JsonEnderecoKeys.NUMERO.toString())
				.getAsInt());
		endereco.setRua(jsonEndereco.get(JsonEnderecoKeys.RUA.toString())
				.getAsString());

		return endereco;
	}
}