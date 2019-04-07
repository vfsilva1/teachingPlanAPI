package edu.planner.enums;

public enum Titulacao {

	NENHUM(1, "Nenhum"),
	ESPECIALISTA(2, "Especialista"),
	MESTRE(3, "Mestre"),
	DOUTOR(4, "Doutor");

	private Integer id;
	private String descricao;

	private Titulacao(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Titulacao toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (Titulacao x : Titulacao.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}