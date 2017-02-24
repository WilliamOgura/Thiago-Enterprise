package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteDelete {

	public static void main(String[] args) {
		//EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar o aluno
		Aluno aluno = em.find(Aluno.class, 1);
		
		//Remover o aluno
		em.remove(aluno);
		
		//Transação (commit)
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Close
		em.close();
		fabrica.close();
		
	}
	
}
