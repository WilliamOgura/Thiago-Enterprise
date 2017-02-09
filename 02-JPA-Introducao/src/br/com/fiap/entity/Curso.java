package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CURSO")
@SequenceGenerator(name="seqCurso",sequenceName="SQ_CURSO",allocationSize=1)
public class Curso {

	@Id
	@Column(name="CD_CURSO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCurso")
	private int codigo;
	
	@Column(name="NM_CURSO", nullable=false)
	private String nome;
	
	@Column(name="NR_HORA")
	private int numeroHoras;
	
	@Column(name="VL_PRECO",nullable=false)
	private double preco;
	
	@Column(name="DS_CURSO")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_INICIO")
	private Calendar dataInicio;
	
	@Column(name="DS_TIPO")
	private TipoCurso tipo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}
	
}
