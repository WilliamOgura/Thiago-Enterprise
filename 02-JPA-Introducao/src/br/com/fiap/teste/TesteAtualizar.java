package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteAtualizar {

	public static void main(String[] args) {
		//EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Busca um aluno
		Aluno aluno = em.find(Aluno.class, 1);
		
		//Muda algum atributo
		aluno.setNome("Kleber Bambam");
		aluno.setCpf("123456");
		
		//Atualiza no banco
		em.merge(aluno);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("Aluno atualizado!");
		
		//Close
		em.close();
		fabrica.close();
	}
	
}
