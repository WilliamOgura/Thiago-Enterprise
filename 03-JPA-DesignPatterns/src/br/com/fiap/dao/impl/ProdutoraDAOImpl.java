package br.com.fiap.dao.impl;

import br.com.fiap.entity.Produtora;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProdutoraDAO;

public class ProdutoraDAOImpl 
				extends GenericDAOImpl<Produtora, Integer>
										implements ProdutoraDAO{

	public ProdutoraDAOImpl(EntityManager em) {
		super(em);
	}

}
