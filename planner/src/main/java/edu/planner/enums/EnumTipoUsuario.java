package edu.planner.enums;

public enum EnumTipoUsuario {

	ADMIN(1, "Admin"),
	COORDENADOR(2, "Coordenador"),
	PROFESSOR(3,"Professor");
	
	private int id;
	private String descricao;

	private EnumTipoUsuario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoUsuario toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		
		for (EnumTipoUsuario x : EnumTipoUsuario.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}