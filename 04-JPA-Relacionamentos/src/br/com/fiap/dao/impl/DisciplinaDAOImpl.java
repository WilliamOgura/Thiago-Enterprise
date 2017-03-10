package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.entity.Disciplina;

public class DisciplinaDAOImpl 
					extends GenericDAOImpl<Disciplina, Integer>
										implements DisciplinaDAO{

	public DisciplinaDAOImpl(EntityManager em) {
		super(em);
	}

}
