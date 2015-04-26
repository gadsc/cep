package br.com.cepconsumer.rest.enums;

/**
 * Enum contendo as keys do Json de Endereço devolvido pelo serviço de busca de
 * cep
 * 
 * @author Gabz
 *
 */
public enum JsonEnderecoKeys {

	RUA("rua"), BAIRRO("bairro"), CEP("cep"), CIDADE("cidade"), NOME("nome"), COMPLEMENTO(
			"complemento"), ESTADO("estado"), NUMERO("numero");

	private String valor;

	private JsonEnderecoKeys(String valor) {
		this.valor = valor;
	}

	public String toString() {
		return valor;
	}
}
