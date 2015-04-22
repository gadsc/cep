package br.com.overpowerme.model.json;

import java.io.Serializable;

public class Tipo implements Serializable {
	private static final long serialVersionUID = 8634594588398500377L;
	private int idTipo;
	private String nome;
	private String descricao;

	public Tipo() {
	}

	public Tipo(int idTipo, String nome, String descricao) {
		super();
		this.idTipo = idTipo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
