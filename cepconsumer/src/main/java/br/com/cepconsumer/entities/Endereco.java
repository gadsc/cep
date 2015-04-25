package br.com.cepconsumer.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "endereco")
@XmlRootElement
public class Endereco implements Serializable {
	private static final long serialVersionUID = 4782264278328343377L;
	@Id
	@GeneratedValue
	@NotNull
	private int id;

	@Column(nullable = false, length = 100)
	@NotNull
	private String rua;

	@Column(nullable = false)
	@NotNull
	private int numero;

	@Column(nullable = false, length = 9)
	@NotNull
	private String cep;

	@Column(nullable = false, length = 100)
	@NotNull
	private String cidade;

	@Column(nullable = false, length = 100)
	@NotNull
	private String estado;

	@Column(length = 100)
	private String bairro;

	@Column(length = 150)
	private String complemento;
	
	public Endereco() {
		
	}

	public Endereco(int id, String rua, int numero, String cep, String cidade,
			String estado, String bairro, String complemento) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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