package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Anotação estará presente até a execução
@Target({ElementType.TYPE,ElementType.METHOD}) //Anotação para classe
public @interface Banco {

	String usuario() default "Thiago";
	String senha();
	
}