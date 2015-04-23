package br.com.cepconsumer.rest.enums;

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
