package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio11 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		Cliente cliente = clienteDao.buscarPorCpf("99828771111");
		
		System.out.println(cliente.getNome()+" "+ cliente.getCpf());
		
		em.close();
		System.exit(0);;
	}
}
