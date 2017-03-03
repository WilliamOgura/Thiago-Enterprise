package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroGrupoProjetoTeste {

	public static void main(String[] args) {
		//Cadastrar um grupo e um projeto
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		GrupoAmDAO grupoDao = new GrupoDAOImpl(em);
		ProjetoAmDAO projetoDao = new ProjetoAmDAOImpl(em);
		
		GrupoAm grupo = new GrupoAm(0, "GDC");
		ProjetoAm projeto = new ProjetoAm(0, "Advocacia",
			"Sistema para gerenciar advogados", 
			Calendar.getInstance(), 
			new GregorianCalendar(2017, Calendar.OCTOBER, 2), 
			grupo);
		
		try {
			//grupoDao.cadastrar(grupo);
			projetoDao.cadastrar(projeto);
			projetoDao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		} finally {
			em.close();
			fabrica.close();
		}
	}
}