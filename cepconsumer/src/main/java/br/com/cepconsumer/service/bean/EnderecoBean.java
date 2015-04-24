package br.com.cepconsumer.service.bean;

import javax.inject.Inject;

import br.com.cepconsumer.dao.DAO;
import br.com.cepconsumer.entities.Endereco;
import br.com.cepconsumer.rest.client.CepClient;
import br.com.cepserver.rest.exception.CepServiceException;

public class EnderecoBean {
	@Inject
	private CepClient cepClient;

	@Inject
	private DAO<Endereco> enderecoDAO;

	public Endereco cadastrarEndereco(String cep) throws CepServiceException {
		Endereco endereco = this.cepClient.buscarEnderecoPorCep(cep);
		return this.enderecoDAO.adicionar(endereco);
	}
	
	public Endereco buscarEndereco(String cep) throws CepServiceException {
		Endereco endereco = this.cepClient.buscarEnderecoPorCep(cep);
		return this.enderecoDAO.adicionar(endereco);
	}
	
	public Endereco atualizarEndereco(String cep) throws CepServiceException {
		Endereco endereco = this.cepClient.buscarEnderecoPorCep(cep);
		return this.enderecoDAO.adicionar(endereco);
	}
	
	public Endereco deletarEndereco(String cep) throws CepServiceException {
		Endereco endereco = this.cepClient.buscarEnderecoPorCep(cep);
		return this.enderecoDAO.adicionar(endereco);
	}
}