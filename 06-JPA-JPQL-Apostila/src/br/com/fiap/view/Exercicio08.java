package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;

public class Exercicio08 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		
	double pacotes = pacoteDao.precoMedio();	
	System.out.println(pacotes);
	
	em.close();
	System.exit(0);
	}
}


