package code.dados;

public class HistoricoVacina {
	
	private int idVacina;
	private int idAnimal;
	private String data;
	private String obs;
	
	public HistoricoVacina(int idVacina, int idAnimal, String data, String obs) {
		this.idVacina = idVacina;
		this.idAnimal = idAnimal;
		this.data = data;
		this.obs = obs;
	}

	public int getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
