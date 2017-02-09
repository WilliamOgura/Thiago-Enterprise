package br.com.fiap.main;

import java.lang.reflect.Method;

import br.com.fiap.annotation.Banco;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		//Recuperar a anotação da classe de conexão
		
		//Reflection API
		//Recupera a estrutura da classe e tenta recuperar a anotação dela
		Banco anotacao = ConnectionFactory.class.getAnnotation(Banco.class);
		System.out.println("Usuário: " + anotacao.usuario());
		System.out.println("Senha: " + anotacao.senha());
		
		//Recuperar as anotações dos métodos
		//Recuperar os métodos da classe
		Method[] metodos = ConnectionFactory.class.getDeclaredMethods();
		for (Method method : metodos) {
			//Recuperar a anotação @Banco do método
			Banco anotacaoMetodo = method.getAnnotation(Banco.class);
			System.out.println(anotacaoMetodo.usuario() + " " + anotacaoMetodo.senha());
		}
		
	}
	
}



