package edu.planner.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TipoUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// O id deve seguir os valores de EnumTipoUsuario
	@Id
	private Integer id;

	private String nome;

	// TODO Mapear item que não possue referencia dos dois lados
	@ManyToMany
	@JoinTable(name = "PRIVILEGIO_TIPO_USUARIO",
		joinColumns = @JoinColumn(name = "privilegio"),
		inverseJoinColumns = @JoinColumn(name = "id")
	)
	private List<Privilegio> privilegios = new ArrayList<Privilegio>();
	
	
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

	public List<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}
}