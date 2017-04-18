package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = 
				em.createQuery("from Cliente",Cliente.class);
		//Maximo de resultado 
		query.setMaxResults(2);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = :D"
				,Cliente.class);
		query.setParameter("D", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiaReserva(int dias) {
		TypedQuery<Cliente> query = em.createQuery(
			"select r.cliente from Reserva r where "
			+ "r.numeroDias = :n",Cliente.class);
		query.setParameter("n", dias);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {		
		return em.createQuery("from Cliente c where c.nome like :n"
				,Cliente.class).setParameter("n", "%"+nome+"%")
				.setMaxResults(10).getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) { 
		return em.createQuery("from Cliente c where c.nome like :n"
				+ " and c.endereco.cidade.nome like :c",Cliente.class)
				.setParameter("n", "%"+nome+"%")
				.setParameter("c", "%"+cidade+"%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(List<String> estados) {
		return em.createQuery("from Cliente c where "
			+ "c.endereco.cidade.uf in :e",Cliente.class)
			.setParameter("e", estados).getResultList();
	}

	@Override
	public long contar() {
		return em.createQuery("select count(c) from Cliente c",
				Long.class).getSingleResult();
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		return em.createNamedQuery("Cliente.porCpf",Cliente.class)
				.setParameter("cpf",cpf)
				.getSingleResult();
	}

}







