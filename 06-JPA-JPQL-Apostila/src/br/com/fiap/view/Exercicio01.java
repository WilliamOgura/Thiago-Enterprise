package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio01 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		List<Cliente> clientes = clienteDao.listar();
		for (Cliente cliente : clientes) {
			System.out.println("Cliente: " + cliente.getNome());
			System.out.println("***********");
		}
		
		em.close();
		System.exit(0);
	}
	
}
