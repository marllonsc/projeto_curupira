package code.dados;

public class HistoricoZootecnia {
	
	private int idAnimal;
	private int idZootecnia;
	private String data;
	private String Observacao;
	
	public HistoricoZootecnia(int idAnimal, int idZootecnia, String data,
			String observacao) {
		this.idAnimal = idAnimal;
		this.idZootecnia = idZootecnia;
		this.data = data;
		Observacao = observacao;
	}
	

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getIdZootecnia() {
		return idZootecnia;
	}

	public void setIdZootecnia(int idZootecnia) {
		this.idZootecnia = idZootecnia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	
	
}
