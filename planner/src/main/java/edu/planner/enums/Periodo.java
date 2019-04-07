package edu.planner.enums;

public enum Periodo {

	MATUTINO(1, "Matutino"),
	VERSPERTINO(2, "Vespertino"),
	NOTURNO(3,"Noturno");
	
	private int id;
	private String descricao;

	private Periodo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Periodo toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		
		for (Periodo x : Periodo.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}