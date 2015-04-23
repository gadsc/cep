package br.com.cepserver.entities;

import java.io.Serializable;

public class Estado implements Serializable {
	private static final long serialVersionUID = 335998555484531593L;
	private String nome;
	private String sigla;

	public Estado() {

	}

	public Estado(String nome, String sigla) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}