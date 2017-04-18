package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listar() {
		//Nome da classe (Primeira letra maiuscula)
		TypedQuery<Pacote> query =
				em.createQuery("from Pacote",Pacote.class);
		//Executar a query e retornar o resultado
		return query.getResultList();
	}

	/***
	 * Busca pacotes que possuem o preço menor 
	 * ou igual ao valor do parâmetro
	 */
	@Override
	public List<Pacote> buscarPorPrecoMaximo(float preco) {
		//Criar a query
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.preco <= :pre",Pacote.class);
		//Setar o parametro
		query.setParameter("pre", preco);
		//Executar e retornar
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.transporte = :t",Pacote.class);
		query.setParameter("t", transporte);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorData(Calendar dataInicio, Calendar dataFim) {
		return em.createQuery("from Pacote p where p.dataSaida "
			+ "between :inicio and :fim",Pacote.class)
			.setParameter("inicio", dataInicio)
			.setParameter("fim", dataFim).getResultList();
	}

	@Override
	public double precoMedio() {
	return em.createQuery("select avg(p.preco) from Pacote p " ,Double.class).getSingleResult();
	}

	@Override
	public long qtdPacotesDataSaida(Calendar dataInicio, 
			Calendar dataFim) {
		return em.createQuery("select count(p) p.pacote where p.dataSaida between :i and :f ",Long.class)
				.setParameter("i", dataInicio)
				.setParameter("f", dataFim)
				.getSingleResult();
	}

	@Override
	public List<Pacote> buscarPrecoMaximo() {
		return em.createQuery("from Pacote p where p.preco =(select max(p2.preco) from Pacote p2)",Pacote.class).getResultList();
		
	}

}







