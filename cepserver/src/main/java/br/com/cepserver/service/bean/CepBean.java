package br.com.cepserver.service.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import br.com.cepserver.entities.Cidade;
import br.com.cepserver.entities.Endereco;
import br.com.cepserver.entities.Estado;

public class CepBean implements Serializable {
	private static final long serialVersionUID = -8484991442515876959L;
	private Map<String, Endereco> mapaEnderecos;
	private int contador;
	private final String DIGITO_SUBSTITUTO = "0";

	@PostConstruct
	public void initialize() {
		contador = 0;
		this.populaCepBean();
	}
	
	public void populaCepBean() {
		mapaEnderecos = new HashMap<>();
		mapaEnderecos.put("00000000", new Endereco("Araguaia", 105,
				"00000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP"))));
		mapaEnderecos.put("10000000", new Endereco("Ramskyramsky", 871,
				"10000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP"))));
		mapaEnderecos.put("20000000", new Endereco("Logo Ali", 521,
				"20000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP"))));
		mapaEnderecos.put("30000000", new Endereco("Volto Logo", 895,
				"30000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP"))));
		mapaEnderecos.put("40000000", new Endereco("Ausente", 367, "40000-000",
				new Cidade("São Paulo", new Estado("São Paulo", "SP"))));
		mapaEnderecos.put("50000000", new Endereco("Disponivel", 198,
				"50000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP")), "Messenger", "Descontinuado"));
		mapaEnderecos.put("60000000", new Endereco("Aurora", 486, "60000-000",
				new Cidade("São Paulo", new Estado("São Paulo", "SP")),
				"Alasca", "Segundo Iceberg à esquerda"));
		mapaEnderecos.put("70000000", new Endereco("Outrora", 645, "70000-000",
				new Cidade("São Paulo", new Estado("São Paulo", "SP")),
				"Lingua Portuguesa", null));
		mapaEnderecos.put("80000000", new Endereco("Depois de Logo Ali", 999,
				"80000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP")), "Proximidade", null));
		mapaEnderecos.put("90000000", new Endereco("Novo Tema", 17,
				"90000-000", new Cidade("São Paulo", new Estado("São Paulo",
						"SP")), "Redação", "Pra passar no enem"));
	}

	public Endereco buscarEnderecoPorCep(String cep) {
		Endereco endereco = this.mapaEnderecos.get(cep);

		if (endereco == null && contador < cep.length()) {
			endereco = this.buscarEnderecoPorCep(this.getCepAlterado(cep,
					contador++));
		}

		return endereco;
	}

	public String getCepAlterado(String cep, int contador) {
		return cep.replace(cep, cep.substring(0, cep.length() - contador)
				+ this.concatDigitoAlterado(contador));
	}

	public String concatDigitoAlterado(int contador) {
		StringBuilder sb = new StringBuilder(contador);

		for (int i = 0; i < contador; i++) {
			sb.append(DIGITO_SUBSTITUTO);
		}

		return sb.toString();
	}
}
