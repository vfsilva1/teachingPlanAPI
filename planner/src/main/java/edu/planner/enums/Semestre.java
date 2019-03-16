package edu.planner.enums;

public enum Semestre {

	SEMESTRE_1(1, "1º Semestre"),
	SEMESTRE_2(2, "2º Semestre");
	
	private int id;
	private String descricao;

	private Semestre(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Semestre toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		
		for (Semestre x : Semestre.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}