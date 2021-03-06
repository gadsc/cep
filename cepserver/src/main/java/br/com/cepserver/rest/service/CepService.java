package br.com.cepserver.rest.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.cepserver.entities.Endereco;
import br.com.cepserver.service.bean.CepBean;

/**
 * Serviço de busca de CEP com JAX-RS
 * 
 * @author Gabz
 *
 */
@Path("/buscarcep")
public class CepService implements Serializable {
	private static final long serialVersionUID = -2434608870284261408L;

	@Inject
	private CepBean cepBean;

	private final String MENSAGEM_ERRO_VALIDACAO_CEP = "CEP inválido!";

	/**
	 * Método para buscar endereço a partir de um cep
	 * 
	 * @param cep
	 *            validado na requisição através de bean validation
	 * @return se o cep for válido retorna um endereço se não retorna a mensagem
	 *         MENSAGEM_ERRO_VALIDACAO_CEP("CEP inválido!")
	 */
	@Path("{cep}")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarEnderecoPorCep(
			@Size(min = 9, max = 9, message = MENSAGEM_ERRO_VALIDACAO_CEP) @NotNull(message = MENSAGEM_ERRO_VALIDACAO_CEP) @Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = MENSAGEM_ERRO_VALIDACAO_CEP) @PathParam("cep") String cep) {
		Endereco endereco = cepBean.buscarEnderecoPorCep(cep.replace("-", ""));
		Response response = null;

		if (endereco == null) {
			response = Response.status(Status.NOT_FOUND)
					.entity(MENSAGEM_ERRO_VALIDACAO_CEP).build();
		} else {
			response = Response.ok(endereco).build();
		}
		return response;
	}
}