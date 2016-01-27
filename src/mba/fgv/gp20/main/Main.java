package mba.fgv.gp20.main;

import mba.fgv.gp20.model.manager.HibernateManager;

public class Main {

	public static void main(String[] args) {
		HibernateManager.getEntityManager();
	}

}
