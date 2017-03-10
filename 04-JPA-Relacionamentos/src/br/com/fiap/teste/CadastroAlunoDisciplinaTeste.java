package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.dao.impl.DisciplinaDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroAlunoDisciplinaTeste {

	public static void main(String[] args) {
		//Cadastrar alunos e disciplinas:
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar os alunos e disciplinas
		Aluno aluno1 = new Aluno(0, "Gargantinha", null);
		Aluno aluno2 = new Aluno(0, "Cris",null);
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(aluno1);
		alunos.add(aluno2);
		
		Disciplina disciplina1 = 
			new Disciplina(0,"Programaçã II",100, "Java", alunos);
		Disciplina disciplina2 =
			new Disciplina(0,"Banco",150,"Oracle",alunos);
		
		//Instanciar o DAO
		DisciplinaDAO dao = new DisciplinaDAOImpl(em);
		
		try{
			dao.cadastrar(disciplina1);
			dao.cadastrar(disciplina2);
			dao.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
			fabrica.close();
		}
	}
}
