package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO_AM")
@SequenceGenerator(name="seqProjeto",sequenceName="SQ_TB_PROJETO",allocationSize=1)
public class ProjetoAm {

	@Id
	@Column(name="CD_PROJETO")
	@GeneratedValue(generator="seqProjeto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="DS_TEMA",nullable=false,length=100)
	private String tema;
	
	@Column(name="DS_OBJETIVO",length=200)
	private String objetivo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_INICIO",nullable=false)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataTermino;
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(nullable=false, name="FK_PROJETO_GRUPO")
	private GrupoAm grupo;
	
	public ProjetoAm() {
		super();
	}

	public ProjetoAm(int codigo, String tema, String objetivo, Calendar dataInicio, Calendar dataTermino,
			GrupoAm grupo) {
		super();
		this.codigo = codigo;
		this.tema = tema;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.grupo = grupo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public GrupoAm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAm grupo) {
		this.grupo = grupo;
	}
	
}
