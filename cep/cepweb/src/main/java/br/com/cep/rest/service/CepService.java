package br.com.cep.rest.service;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/buscarcep")
public class CepService implements Serializable {
	private static final long serialVersionUID = -2434608870284261408L;

	@Path("{cep}")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String buscarEnderecoPorCep(
			@Size(min = 9, max=9, message = "CEP inválido!")
			@NotNull(message = "CEP inválido!")
			@Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "CEP inválido!")
			@PathParam("cep") String cep) {
		return "";
	}
}