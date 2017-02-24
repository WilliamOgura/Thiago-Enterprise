package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Sexo;

public class TesteCadastro {

	public static void main(String[] args) {
		//Obter a Factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Obter o EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o aluno
		Aluno aluno = new Aluno(0,"Edu Juliao", "3215456464",
				new GregorianCalendar(1999, Calendar.JANUARY, 2),
				Sexo.MASCULINO, null, true, 123);
		
		//Persistir o aluno
		em.persist(aluno);
		
		//Commit (Transações)
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("Aluno cadastrado!");
		
		//Close
		em.close();
		fabrica.close();
	}
	
}
