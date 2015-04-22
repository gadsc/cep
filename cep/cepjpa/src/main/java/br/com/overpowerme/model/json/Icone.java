package br.com.overpowerme.model.json;

import java.io.Serializable;

public class Icone implements Serializable {
	private static final long serialVersionUID = -6662327504193371940L;
	private String url;
	private String posicao;

	public Icone() {
	}

	public Icone(String url, String posicao) {
		super();
		this.url = url;
		this.posicao = posicao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
}