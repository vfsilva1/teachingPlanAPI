package edu.planner.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

import edu.planner.enums.Periodo;
import edu.planner.enums.Semestre;

@Entity
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer periodo;

	@ManyToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;

	private Integer semestre;

	@Digits(fraction=0, integer=4, message="Valor inválido")
	private Integer ano;

	@ManyToOne
	@JoinColumn(name = "professor")
	private Usuario professor;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Periodo getPeriodo() {
		return Periodo.toEnum(periodo);
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo.getId();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Semestre getSemestre() {
		return Semestre.toEnum(semestre);
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre.getId();
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		if (!professor.getIsProfessor()) {
			throw new IllegalArgumentException("O usuário " + professor.getNome() + " não é um Professor");
		}

		this.professor = professor;
	}
}