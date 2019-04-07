package edu.planner.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import edu.planner.enums.TipoDisciplina;

@Entity
public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@Column
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "responsavel")
	private Usuario responsavel;

	@OneToMany(mappedBy = "disciplina")
	private List<Turma> turmas = new ArrayList<Turma>();

	@ManyToMany(mappedBy = "disciplinas")
	private List<Curso> cursos = new ArrayList<Curso>();

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDisciplina getTipo() {
		return TipoDisciplina.toEnum(tipo);
	}

	public void setTipo(TipoDisciplina tipo) {
		this.tipo = tipo.getId();
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		if (!responsavel.getIsProfessor()) {
			throw new IllegalArgumentException("O usuário " + responsavel.getNome() + " não é um Professor");
		}

		this.responsavel = responsavel;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}