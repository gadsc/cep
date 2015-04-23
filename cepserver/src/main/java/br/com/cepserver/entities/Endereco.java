package br.com.cepserver.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco implements Serializable {
	private static final long serialVersionUID = 8505383885163674679L;
	private String rua;
	private int numero;
	private String cep;
	private Cidade cidade;

	private String bairro;
	private String complemento;

	public Endereco() {
	}

	public Endereco(String rua, int numero, String cep, Cidade cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
	}

	public Endereco(String rua, int numero, String cep, Cidade cidade,
			String bairro, String complemento) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.complemento = complemento;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}