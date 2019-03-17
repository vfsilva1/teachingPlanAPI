package edu.planner.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import edu.planner.enums.EnumTipoUsuario;
import edu.planner.enums.Titulacao;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private Integer titulacao;

	private String email;

	private String hashKey;

	// TODO Mapear item que não possue referencia dos dois lados
	@ManyToMany
	@JoinTable(name = "USUARIO_TIPO_USUARIO",
		joinColumns = @JoinColumn(name = "id"),
		inverseJoinColumns = @JoinColumn(name = "id")
	)
	private List<TipoUsuario> tiposUsuarios = new ArrayList<TipoUsuario>();

	@Transient
	private Boolean isAdmin;

	@Transient
	private Boolean isCoordenador;

	@Transient
	private Boolean isProfessor;

	@Transient
	private Map<String, Integer> privilegios = new HashMap<String, Integer>();

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

	public Titulacao getTitulacao() {
		return Titulacao.toEnum(titulacao);
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao.getId();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public List<TipoUsuario> getTiposUsuarios() {
		return tiposUsuarios;
	}

	public void setTiposUsuarios(List<TipoUsuario> tiposUsuarios) {
		this.tiposUsuarios = tiposUsuarios;
	}

	public Boolean getIsAdmin() {
		if (isAdmin == null) {
			isAdmin = tiposUsuarios.stream().anyMatch(tipo -> tipo.getId() == EnumTipoUsuario.ADMIN.getId());
		}

		return isAdmin;
	}

	public Boolean getIsCoordenador() {
		if (isCoordenador == null) {
			isCoordenador = tiposUsuarios.stream()
					.anyMatch(tipo -> tipo.getId() == EnumTipoUsuario.COORDENADOR.getId());
		}

		return isCoordenador;
	}

	public Boolean getIsProfessor() {
		if (isProfessor == null) {
			isProfessor = tiposUsuarios.stream().anyMatch(tipo -> tipo.getId() == EnumTipoUsuario.PROFESSOR.getId());
		}

		return isProfessor;
	}

	public Map<String, Integer> getPrivilegios() {
		for (TipoUsuario tipo : this.tiposUsuarios) {

			tipo.getPrivilegios().stream().forEach(priv -> this.privilegios.put(priv.getNome(), priv.getId()));
		}

		return this.privilegios;
	}
}