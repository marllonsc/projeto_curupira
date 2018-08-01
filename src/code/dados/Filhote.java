package code.dados;

public class Filhote {
	
	String idCria;
	String dataDesmame;
	String dataAborto;
	String curaUmbigo;
	String colastro;
	String marcacao;
	String idMae;
	
	
	public Filhote(String idCria, String dataDesmame, String dataAborto,
			String curaUmbigo, String colastro, String marcacao, String idMae) {
		super();
		this.idCria = idCria;
		this.dataDesmame = dataDesmame;
		this.dataAborto = dataAborto;
		this.curaUmbigo = curaUmbigo;
		this.colastro = colastro;
		this.marcacao = marcacao;
		this.idMae = idMae;
		
	}
	
	public String getIdCria() {
		return idCria;
	}
	public void setIdCria(String idCria) {
		this.idCria = idCria;
	}
	public String getDataDesmame() {
		return dataDesmame;
	}
	public void setDataDesmame(String dataDesmame) {
		this.dataDesmame = dataDesmame;
	}
	public String getDataAborto() {
		return dataAborto;
	}
	public void setDataAborto(String dataAborto) {
		this.dataAborto = dataAborto;
	}
	public String getCuraUmbigo() {
		return curaUmbigo;
	}
	public void setCuraUmbigo(String curaUmbigo) {
		this.curaUmbigo = curaUmbigo;
	}
	public String getColastro() {
		return colastro;
	}
	public void setColastro(String colastro) {
		this.colastro = colastro;
	}
	public String getMarcacao() {
		return marcacao;
	}
	public void setMarcacao(String marcacao) {
		this.marcacao = marcacao;
	}
	public String getIdMae() {
		return idMae;
	}
	public void setIdMae(String idMae) {
		this.idMae = idMae;
	}
	

}
