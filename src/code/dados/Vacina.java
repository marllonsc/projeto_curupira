package code.dados;

public class Vacina {
	
	private int id;
	private String descricao;
	private String periodo;
	
	public Vacina(int id, String descricao, String periodo) {
		this.id = id;
		this.descricao = descricao;
		this.periodo = periodo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	

}
