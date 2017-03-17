package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Campeonato;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastraTudoTeste {

	public static void main(String[] args) {
		//Cadastrar tudo
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TimeDAO dao = new TimeDAOImpl(em);
		
		Time time = new Time(0, "Timão",
			new GregorianCalendar(1910, Calendar.NOVEMBER, 10),
			10, null, null);
		
		Tecnico tecnico = new Tecnico(0,"Fabio",time);
		
		Jogador goleiro = new Jogador(0, "Cassio", time);
		Jogador lateral = new Jogador(0, "Fagner", time);
		Jogador zagueiro = new Jogador(0, "Pedro", time);
		Jogador atacante = new Jogador(0, "Romeiro", time);
		
		time.addJogador(goleiro);
		time.addJogador(atacante);
		time.addJogador(zagueiro);
		time.addJogador(lateral);
		
		time.setTecnico(tecnico);
		
		Campeonato libertadores = 
				new Campeonato(0, "Libertadores", null);
		Campeonato paulista = new Campeonato(0,"Paulista",null);
		
		List<Campeonato> lista = new ArrayList<Campeonato>();
		lista.add(paulista);
		lista.add(libertadores);
		
		time.setCampeonatos(lista);
		
		try {
			dao.cadastrar(time);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally {
			em.close();
			System.exit(0);
		}
		
		
	}
	
}
