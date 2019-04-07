package edu.planner.exception;

public enum ErrorCode {
	
	CURSO_SAVE(1000, "Erro ao salvar curso"),
	CURSO_UPDATE(1001, "Erro ao alterar curso"),
	CURSO_DELETE(1002, "Erro ao remover curso"),
	CURSO_DELETE_VIOLATION(1003, "Não é possível remover um curso em uso"),
	CURSO_SEARCH(1004, "Erro ao consultar curso"),
	
	DISCIPLINA_SAVE(1020, "Erro ao salvar disciplina"),
	DISCIPLINA_UPDATE(1020, "Erro ao alterar disciplina"),
	DISCIPLINA_DELETE(1020, "Erro ao remover disciplina"),
	
	ULTIMO_ERRO(9999, "");
	
	private final int code;
	private final String message;
    
    ErrorCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

    @Override
    public String toString() {
    	String message = "";
    	if(this.message != null && this.message.trim().length() > 0) {
    		message = " - " + this.message;
    	}
        return String.valueOf(this.code) + message;
    }
}