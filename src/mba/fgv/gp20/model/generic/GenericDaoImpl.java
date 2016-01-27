package mba.fgv.gp20.model.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mba.fgv.gp20.model.manager.HibernateManager;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	private EntityManager em;
	private Class<T> clazz;

	public GenericDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public void beginTx() throws Exception{
		em = HibernateManager.getEntityManager();
		em.getTransaction().begin();
	}
	
	@Override
	public void commitTx() throws Exception{
		em.getTransaction().commit();
	}
	
	@Override
	public void closeTx() {
		if(em != null) {
			if(em.getTransaction() != null && em.getTransaction().isActive()) {
				try { em.getTransaction().rollback(); } catch(Exception e) {}
			}
			
			try { em.close(); } catch(Exception e) {}
		}
	}

	@Override
	public boolean add(T entidade){
		em.persist(entidade);
		return true;
	}

	@Override
	public T findById(long entidadeId) {
		T entidade = null;
		entidade = em.find(clazz, entidadeId);

		return entidade;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws Exception{

		List<T> entidades;
		Query buscaTodos = null;
		String sql = "from "+ clazz.getName() + " order by id";

		buscaTodos = em.createQuery(sql, clazz);
		entidades = buscaTodos.getResultList();
		
		return entidades;
	}

	@Override
	public boolean update(T entidade) {
		em.merge(entidade);
		return true;
	}

	@Override
	public boolean remove(long entidadeId) {
		T entidade;
		entidade = em.find(clazz, entidadeId);
		em.remove(entidade);
		return true;
	}

	@Override
	public int count(String table) throws Exception{
		int count = 0;
		Query query = null;
		String sql = "select count(*) from "+ table;
		query = em.createQuery(sql);
		count = ((Long)query.getSingleResult()).intValue();
		
		return count;
	}
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
