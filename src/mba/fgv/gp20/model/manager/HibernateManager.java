package mba.fgv.gp20.model.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateManager {

	private static EntityManagerFactory factory;
	
	private static void init() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("hibernatedb");
	}

	private static EntityManagerFactory getEntityManagerFactory() {
		init();
		return factory;
	}
	
	public static EntityManager getEntityManager(){
		return HibernateManager.getEntityManagerFactory().createEntityManager();
	}  
}
