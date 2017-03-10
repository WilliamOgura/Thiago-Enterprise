package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroAlunoGrupoTeste {

	public static void main(String[] args) {
		//Cadastrar alunos e grupo
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		GrupoAmDAO grupoDao = new GrupoDAOImpl(em);
		//AlunoDAO alunoDao = new AlunoDAOImpl(em);
		
		GrupoAm grupo = new GrupoAm(0, "Estagiários");
		grupo.addIntegrantes(new Aluno(0, "Gargana", grupo));
		grupo.addIntegrantes(new Aluno(0, "Edu", grupo));
		grupo.addIntegrantes(new Aluno(0, "Juliao", grupo));
		
		try {
			grupoDao.cadastrar(grupo);
			grupoDao.commit();
			//alunoDao.cadastrar(aluno1);
			//alunoDao.cadastrar(aluno2);
			//alunoDao.cadastrar(aluno3);
			//alunoDao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
