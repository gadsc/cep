package br.com.cepconsumer.dao.producer;


/**
 * Producer para gerar os DAO's
 * 
 * @author Gabz
 *
 * @param <T>
 */
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