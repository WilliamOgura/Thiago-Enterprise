package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class BuscaGrupoTeste {

	public static void main(String[] args) {
		//Buscar um grupo e exibir o tema do projeto do grupo
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		GrupoAmDAO grupoDao = new GrupoDAOImpl(em);
		
		GrupoAm grupoAm = grupoDao.buscar(1);
		
		System.out.println(grupoAm.getNome());
		System.out.println(grupoAm.getProjeto().getTema());
		
		em.close();
		fabrica.close();
		
	}
	
}





