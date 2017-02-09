package br.com.fiap.main;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.bean.Aluno;

public class Exercicio {

	public static void main(String[] args) {
		//Recuperar o nome da tabela da classe Java
		Tabela anotacao = Aluno.class.getAnnotation(Tabela.class);		
		System.out.println("SELECT * FROM " + anotacao.nome());
	}
	
}
