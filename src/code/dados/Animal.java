package code.dados;

public class Animal {
	
	private String identificador;
	private double imc;
	private double peso;
	private String dataNascimento;
	private String sexo;
	private int raca;
	private int categoria;
	private String status;
	private String observacao;


	public Animal(String identificador, double imc, double peso,
			String dataNascimento, String sexo, int raca,
			int categoria, String status, String observacao) {
		
		this.identificador = identificador;
		this.imc = imc;
		this.peso = peso;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.raca = raca;
		this.categoria = categoria;
		this.status = status;
		this.observacao = observacao;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public int getRaca() {
		return raca;
	}


	public void setRaca(int raca) {
		this.raca = raca;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public double getImc() {
		return imc;
	}


	public void setImc(double imc) {
		this.imc = imc;
	}
	
	
	
	
	

}
