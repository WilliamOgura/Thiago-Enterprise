package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteBusca {

	public static void main(String[] args) {
		//EntityManager
		EntityManagerFactory fabrica = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
									
								//Código do aluno
		Aluno aluno = em.find(Aluno.class, 1);
		
		System.out.println(aluno.getNome());
		
		em.close();
		fabrica.close();
	}
	
}




