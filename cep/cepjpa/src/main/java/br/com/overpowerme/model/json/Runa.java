package br.com.overpowerme.model.json;

import java.io.Serializable;

public class Runa implements Serializable {
	private static final long serialVersionUID = 5268646982198732480L;
	private int id;
	private Tipo tipo;
	private Icone icone;
	private Double valor;

	public Runa() {
	}

	public Runa(int id, Tipo tipo, Icone icone, Double valor) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.icone = icone;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Icone getIcone() {
		return icone;
	}

	public void setIcone(Icone icone) {
		this.icone = icone;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
