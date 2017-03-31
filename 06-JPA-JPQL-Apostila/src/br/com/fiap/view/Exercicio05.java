package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class Exercicio05 {

	public static void main(String[] args) {
		//Buscar pacotes por data
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		Calendar dataInicio = 
			new GregorianCalendar(2010, Calendar.JANUARY, 2);
		Calendar dataFim =
			new GregorianCalendar(2017, Calendar.AUGUST,2);
		
		List<Pacote> pacotes = dao.buscarPorData(dataInicio, dataFim);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
			System.out.println(
				sdf.format(pacote.getDataSaida().getTime()));
		}
		
		em.close();
		System.exit(0);
	}
	
}
