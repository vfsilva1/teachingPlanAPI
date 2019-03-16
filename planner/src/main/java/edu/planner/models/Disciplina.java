package edu.planner.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.planner.enums.TipoDisciplina;

public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private String tipo;

	private Usuario responsavel;

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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}