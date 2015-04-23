package br.com.cepconsumer.rest.client;

import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.math.NumberUtils;

import br.com.cepconsumer.entities.Endereco;
import br.com.cepconsumer.rest.constants.URIConstants;
import br.com.cepconsumer.rest.enums.JsonEnderecoKeys;

import com.google.gson.JsonObject;

public class CepClient {
	@Inject
	private RestClient restClient;

	public Endereco buscarEnderecoPorCep(String cep) {
		Endereco endereco = null;
		JsonObject jsonEndereco = null;
		UriBuilder uri = null;

		try {
			uri = UriBuilder.fromPath(URIConstants.BUSCAR_CEP).path(cep);
			jsonEndereco = restClient.getJsonFromService(uri);
			endereco = new Endereco();

			endereco.setBairro(ObjectUtils.toString(jsonEndereco
					.get(JsonEnderecoKeys.BAIRRO.toString())));
			endereco.setCep(ObjectUtils.toString(jsonEndereco
					.get(JsonEnderecoKeys.CEP.toString())));
			endereco.setCidade(ObjectUtils.toString(jsonEndereco
					.get(JsonEnderecoKeys.CIDADE.toString()).getAsJsonObject()
					.get(JsonEnderecoKeys.NOME.toString())));
			endereco.setComplemento(ObjectUtils.toString(jsonEndereco
					.get(JsonEnderecoKeys.COMPLEMENTO.toString())));
			endereco.setEstado(ObjectUtils.toString(jsonEndereco
					.get(JsonEnderecoKeys.CIDADE.toString()).getAsJsonObject()
					.get(JsonEnderecoKeys.ESTADO.toString()).getAsJsonObject()
					.get(JsonEnderecoKeys.NOME.toString())));
			endereco.setNumero(jsonEndereco.get(JsonEnderecoKeys.NUMERO
					.toString()) == null ? NumberUtils.INTEGER_ZERO
					: jsonEndereco.get(JsonEnderecoKeys.NUMERO.toString())
							.getAsInt());
			endereco.setRua(ObjectUtils.toString(jsonEndereco
					.get(JsonEnderecoKeys.RUA.toString())));
		} catch (Exception err) {
			err.printStackTrace();
		}

		return endereco;
	}
}