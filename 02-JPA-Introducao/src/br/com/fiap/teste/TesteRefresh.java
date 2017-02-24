package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;

public class TesteRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar um aluno no banco
		Aluno aluno = em.find(Aluno.class, 1);
		//Exibir o nome
		System.out.println(aluno.getNome());
		//Mudar o nome no objeto
		aluno.setNome("Leo");
		//Exibir o nome
		System.out.println(aluno.getNome());
		//Refresh
		em.refresh(aluno);
		//Exibir o nome
		System.out.println(aluno.getNome());
		
		em.close();
		fabrica.close();
	}
	
}
