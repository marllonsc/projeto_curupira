package code.dados;

public class TabelaZootecnica {
	
	private String data;
	private String obs;
	private String pratica;
	
	public TabelaZootecnica(String data, String obs, String pratica) {
		this.data = data;
		this.obs = obs;
		this.pratica = pratica;
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

	public String getPratica() {
		return pratica;
	}

	public void setPratica(String pratica) {
		this.pratica = pratica;
	}
	

}
