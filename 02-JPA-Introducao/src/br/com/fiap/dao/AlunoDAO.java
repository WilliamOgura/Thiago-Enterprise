package br.com.fiap.dao;

import br.com.fiap.entity.Aluno;

public interface AlunoDAO {

	void cadastrar(Aluno aluno);
	void remover(int rm);
	void atualizar(Aluno aluno);
	Aluno buscar(int rm);
	
}
