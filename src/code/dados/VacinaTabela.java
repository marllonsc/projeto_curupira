package code.dados;

public class VacinaTabela {
	
	private String data;
	private String Observação;
	private String Descrição;
	private String perido;
	
	public VacinaTabela(String data, String observação, String descrição,
			String perido) {
		this.data = data;
		Observação = observação;
		Descrição = descrição;
		this.perido = perido;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getObservação() {
		return Observação;
	}
	public void setObservação(String observação) {
		Observação = observação;
	}
	public String getDescrição() {
		return Descrição;
	}
	public void setDescrição(String descrição) {
		Descrição = descrição;
	}
	public String getPerido() {
		return perido;
	}
	public void setPerido(String perido) {
		this.perido = perido;
	}
	
	
	

}
