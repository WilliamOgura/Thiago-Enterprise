package br.com.fiap.connection;

import br.com.fiap.annotation.Banco;


@Banco(usuario="Thiago", senha="123456")
public class ConnectionFactory {
	
	@Banco(usuario="Fiap",senha="654321")
	public void conectarOracle(){
		
	}
	
	@Banco(usuario="admin", senha="admin")
	public void conectarMySql(){
		
	}
	
}