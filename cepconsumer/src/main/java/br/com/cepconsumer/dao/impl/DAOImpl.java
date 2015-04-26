package br.com.cepconsumer.dao.impl;

import br.com.cepconsumer.dao.DAO;


/**
 * Implementação concreta da interface dao
 * @author Gabz
 *
 * @param <T>
 */
public class DAOImpl<T> implements DAO<T> {

//	@NotNull
//	private final Class<T> clazz;
//
//	@NotNull
//	private final EntityManager em;
//
//	public DAOImpl(final Class<T> clazz, final EntityManager em) {
//		this.clazz = clazz;
//		this.em = em;
//	}
//
//	@Override
//	public T adicionar(T entidade) {
//		try {
//			em.persist(entidade);
//
//		} catch (Exception err) {
//			err.printStackTrace();
//		}
//		return entidade;
//	}
//
//	@Override
//	public <ID> T pesquisarPorId(ID id) {
//		return em.find(clazz, id);
//	}
//
//	@Override
//	public T atualizar(T entidade) {
//		return em.merge(entidade);
//	}
//
//	@Override
//	public <ID> void apagarPorId(ID id) {
//		em.remove(this.pesquisarPorId(id));
//	}

}
