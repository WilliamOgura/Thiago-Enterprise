package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		//Executar a busca de todos os pacotes
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		List<Pacote> pacotes = dao.listar();
		System.out.println("BUSCAR TUDO:");
		imprimirPacotes(pacotes);
		
		pacotes = dao.buscarPorPrecoMaximo(1000);
		System.out.println("BUSCA POR PREÇO:");
		imprimirPacotes(pacotes);
		
		em.close();		
		System.exit(0);//fechar o programa
	}

	private static void imprimirPacotes(List<Pacote> pacotes) {
		for (Pacote pacote : pacotes) {
			System.out.println("Pacote: " + pacote.getDescricao()
					+ " - R$" + pacote.getPreco());
		}
	}

}
