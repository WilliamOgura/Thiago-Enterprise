package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_JOGO")
@SequenceGenerator(name="seqJogo",sequenceName="SEQ_TB_JOGO",allocationSize=1)
public class Jogo {

	@Id
	@Column(name="CD_JOGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqJogo")
	private int codigo;
	
	@Column(name="DS_TITULO",nullable=false,length=100)
	private String titulo;
	
	@Column(name="VL_JOGO")
	private double preco;
	
	@Column(name="DS_GENERO")
	private String genero;

	public Jogo() {
		super();
	}

	public Jogo(int codigo, String titulo, double preco, String genero) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
