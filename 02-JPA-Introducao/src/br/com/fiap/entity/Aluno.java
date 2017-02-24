package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="seqAluno",sequenceName="SQ_ALUNO",allocationSize=1)
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAluno")
	private int rm;
	
	@Column(name="NM_ALUNO", nullable=false, length=200)
	private String nome;
	
	private String cpf;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE) //Persiste somente a data
	private Calendar dataNascimento;
	
	private Sexo sexo;
	
	@Lob
	private byte[] foto;
	
	private boolean bolsista;
	
	@Transient //Não sera uma coluna no banco de dados	
	private int senhaAtendimento;
	
	@PostPersist //Executa antes da operação de cadastro	
	public void log(){
		System.out.println("Cadastrando um aluno");
	}

	public Aluno(int rm, String nome, String cpf, Calendar dataNascimento, Sexo sexo, byte[] foto, boolean bolsista,
			int senhaAtendimento) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.foto = foto;
		this.bolsista = bolsista;
		this.senhaAtendimento = senhaAtendimento;
	}

	public Aluno() {
		super();
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public boolean isBolsista() {
		return bolsista;
	}

	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}

	public int getSenhaAtendimento() {
		return senhaAtendimento;
	}

	public void setSenhaAtendimento(int senhaAtendimento) {
		this.senhaAtendimento = senhaAtendimento;
	}
	
}





