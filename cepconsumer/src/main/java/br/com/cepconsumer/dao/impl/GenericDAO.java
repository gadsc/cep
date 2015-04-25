package br.com.cepconsumer.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.NotFoundException;

public abstract class GenericDAO<T> {

	static EntityManagerFactory factory = null;
	private Class<T> classe;

	static {
		factory = Persistence.createEntityManagerFactory("cepconsumerPU");
	}

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		Class<?> thisClass = getClass();
		ParameterizedType t = (ParameterizedType) thisClass
				.getGenericSuperclass();
		Type t2 = t.getActualTypeArguments()[0];
		this.classe = (Class<T>) t2;
	}

	public T localizar(int id) {
		EntityManager em = factory.createEntityManager();
		T obj = null;

		try {
			obj = em.find(classe, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return obj;
	}

	public T inserir(T obj) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(obj);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (t.isActive()) t.rollback();
		} finally {
			em.close();
		}

		return obj;
	}

	public T atualizar(T obj) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			obj = em.merge(obj);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (t.isActive()) t.rollback();
		} finally {
			em.close();
		}

		return obj;
	}

	public void excluir(int id) throws NotFoundException {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		T obj = null;

		try {
			t.begin();
			obj = em.find(classe, id);;

			if (obj == null) {
				throw new NotFoundException();
			} else {
				em.remove(obj);
			}
			t.commit();
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			
			if (t.isActive()) t.rollback();
		} finally {
			em.close();
		}
	}
}