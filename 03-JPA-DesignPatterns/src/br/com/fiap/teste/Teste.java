package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.JogoDAO;
import br.com.fiap.dao.impl.JogoDAOImpl;
import br.com.fiap.entity.Jogo;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		//Cadastrar um Jogo
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();

		//Utiliza o EntityManager para instanciar o dao
		JogoDAO dao = new JogoDAOImpl(em);
		
		//Instancia o Jogo
		Jogo jogo = new Jogo(0,"Fifa 17", 150, "Esporte");
		
		try {
			dao.cadastrar(jogo);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
}
