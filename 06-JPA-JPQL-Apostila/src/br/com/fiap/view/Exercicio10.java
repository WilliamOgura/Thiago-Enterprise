package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class Exercicio10 {

 public static void main(String[] args) {
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	PacoteDAO pacoteDao = new PacoteDAOImpl(em);
	
	List<Pacote> lista = pacoteDao.buscarPrecoMaximo();
	
	for (Pacote pacote : lista) {
		System.out.println(pacote.getDescricao() +" "+ pacote.getPreco());
		
	}
	em.close();
	System.exit(0);
 }
}
