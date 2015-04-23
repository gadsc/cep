package br.com.cepconsumer.dao;

public interface DAO<T> {
	T adicionar(T entidade);
	
	<ID> T pesquisarPorId(ID id);
	
	T atualizar(T entidade);
	
	<ID> void apagarPorId(ID entidade);
}