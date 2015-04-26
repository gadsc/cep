package br.com.cepserver.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Modelo para retorno do Serviço
 * 
 * @author Gabz
 *
 */
@XmlRootElement
public class Cidade implements Serializable {
	private static final long serialVersionUID = 2044752645194672299L;
	private String nome;
	private Estado estado;

	public Cidade() {

	}

	public Cidade(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}