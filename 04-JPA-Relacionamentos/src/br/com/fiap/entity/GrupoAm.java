package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRUPO_AM")
@SequenceGenerator(name="seqGrupo",sequenceName="SQ_TB_GRUPO",allocationSize=1)
public class GrupoAm {

	@Id
	@Column(name="CD_GRUPO")
	@GeneratedValue(generator="seqGrupo",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_GRUPO",nullable=false,length=150)
	private String nome;
	
	@OneToOne(mappedBy="grupo",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private ProjetoAm projeto;
	
	@OneToMany(mappedBy="grupo",cascade=CascadeType.PERSIST)
	private List<Aluno> integrantes = new ArrayList<Aluno>();
	
	//Método para adicionar alunos
	public void addIntegrantes(Aluno aluno){
		//Adicionar o aluno da lista de integrantes
		integrantes.add(aluno);
		//Setar o grupo do aluno
		aluno.setGrupo(this);
	}

	public GrupoAm() {
		super();
	}

	public GrupoAm(int codigo, String nome) {
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

	public ProjetoAm getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAm projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Aluno> integrantes) {
		this.integrantes = integrantes;
	}
	
}
