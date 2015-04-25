package br.com.cepconsumer.dao.producer;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.cepconsumer.dao.DAO;
import br.com.cepconsumer.dao.impl.DAOImpl;

public class DAOProducer<T> {
//	@PersistenceContext(unitName = "cepconsumerPU", type = PersistenceContextType.TRANSACTION)
//	private transient EntityManager em;
//
//	@Produces
//	public DAO<T> injectDAO(final InjectionPoint injectionPoint) {
//		final ParameterizedType type = (ParameterizedType) injectionPoint
//				.getType();
//		@SuppressWarnings("unchecked")
//		final Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
//
//		return new DAOImpl<T>(clazz, em);
//	}
}