package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTORA")
@SequenceGenerator(name="seqProdutora",sequenceName="SEQ_TB_PRODUTORA",allocationSize=1)
public class Produtora {

	@Id
	@Column(name="CD_PRODUTORA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqProdutora")
	private int codigo;
	
	@Column(name="NM_PRODUTORA",nullable=false)
	private String nome;

	public Produtora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produtora(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

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

}
