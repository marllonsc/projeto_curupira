package code.dados;

public class Zootecnica {
	
	private int id;
	private String pratica;
	
	
	public Zootecnica(int id, String pratica) {
		super();
		this.id = id;
		this.pratica = pratica;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPratica() {
		return pratica;
	}


	public void setPratica(String pratica) {
		this.pratica = pratica;
	}
	

}
