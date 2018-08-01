package code.sql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;




import code.dados.Animal;

public class Sqlfunc {

	private ConexaoBanco conexao = new ConexaoBanco();
	
	public boolean cadastrarAnimal(Animal animal) {

		boolean resultado = false;
		
		if(!verificarIdentificadorExiste(animal.getIdentificador())){
		
		String sql = "insert into Animal(Identificacao,IMC,Peso,Data_Nascimento,Sexo,Raca,Categoria,Status,Data_Cio,Prenha,Observacao) Values('"+animal.getIdentificador()+"','"+animal.getImc()+"','"+animal.getPeso()+"','"+animal.getDataNascimento()+"','"+animal.getSexo()+"','"+animal.getRaca()+"','"+animal.getCategoria()+"','"+animal.getStatus()+"',NULL,NULL,'"+animal.getObservacao()+"')";
		
		resultado = conexao.executarSQL(sql);
		}
		
		return resultado;

	}
	
	public Vector<String> retornaRaca(String animal){
		Vector<String> racas = new Vector<String>();
		
		racas.add("");
		String sql = "SELECT Descricao FROM Raca WHERE Animal='"+animal+"'";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
		try {
			while (Dadosusuarios.next()) {
				racas.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return racas;
	}
	
	public int retornaIndiceRaca(String nome, String animal){
		int resultado = 1000000;
		
		String sql = "SELECT idRaca,Descricao FROM Raca WHERE Animal='"+animal+"'";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				if(Dadosusuarios.getString(2).equalsIgnoreCase(nome)){
					resultado = Dadosusuarios.getInt(1);
				}
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public Vector<String> retornaVacinas(String animal){
		
		Vector<String> vacinas = new Vector<String>();
		String sql = "SELECT Descricao FROM Vacina WHERE Animal='"+animal+"'";
		vacinas.add("");
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				vacinas.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vacinas;
		
	}
	
	public int retornaIndiceVacinas(String nome, String animal){
		int resultado = 1000000;
		
		String sql = "SELECT idVacina,Descricao FROM Vacina WHERE Animal='"+animal+"'";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				if(Dadosusuarios.getString(2).equalsIgnoreCase(nome)){
					resultado = Dadosusuarios.getInt(1);
				}
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
public Vector<String> retornaCategoria(String animal){
		
		Vector<String> categoria = new Vector<String>();
		categoria.add("");
		String sql = "SELECT Descricao FROM Categoria WHERE Animal='"+animal+"'";
		
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				categoria.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return categoria;
		
	}

public int retornaIndiceCategoria(String nome, String animal){
	int resultado = 1000000;
	
	String sql = "SELECT idCategoria,Descricao FROM Categoria WHERE Animal='"+animal+"'";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
			if(Dadosusuarios.getString(2).equalsIgnoreCase(nome)){
				resultado = Dadosusuarios.getInt(1);
			}
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	return resultado;
}

public boolean AlterarAnimal(Animal animal){
	boolean resultado = false;
	                         
	int indice = retornaIdAnimal(animal.getIdentificador());
	
	String sql = "UPDATE Animal SET IMC ='"+animal.getImc()+"', Peso = '"+animal.getPeso()+"', Data_Nascimento = '"+animal.getDataNascimento()+"', Sexo = '"+animal.getSexo()+"', Raca = '"+animal.getRaca()+"', Categoria = '"+animal.getCategoria()+"', Status = '"+animal.getStatus()+"', Observacao = '"+animal.getObservacao()+"' WHERE idAnimal = '"+indice+"'";
	resultado = conexao.executarSQL(sql);
	
	return resultado;

}

public Animal buscaAnimal(String indentificado,String ani){
	Animal animal =null;
	
	
	String sql = "SELECT Identificacao,IMC,Peso,Data_Nascimento,Sexo,Raca,Categoria,Status,Observacao FROM Animal a, Raca r WHERE r.Animal ='"+ani+"' AND a.Raca = r.idRaca";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
			if(Dadosusuarios.getString(1).equalsIgnoreCase(indentificado)){
				
				animal = new Animal(Dadosusuarios.getString(1),Dadosusuarios.getDouble(2),Dadosusuarios.getDouble(3), Dadosusuarios.getString(4), Dadosusuarios.getString(5), Dadosusuarios.getInt(6), Dadosusuarios.getInt(7),Dadosusuarios.getString(8), Dadosusuarios.getString(9));
				
			}
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	return animal;
}

public String retornaNomeRaca(int indice, String animal){
	 String resultado = "";
	
	String sql = "SELECT idRaca,Descricao FROM Raca WHERE Animal='"+animal+"'";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
			if(Dadosusuarios.getInt(1)==indice){
				resultado = Dadosusuarios.getString(2);
			}
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	return resultado;
}


public String retornaNomeCategoria(int indice, String animal){
	String resultado = "";
	
	String sql = "SELECT idCategoria,Descricao FROM Categoria WHERE Animal='"+animal+"'";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
			if(Dadosusuarios.getInt(1)==indice){
				resultado = Dadosusuarios.getString(2);
			}
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	return resultado;
}

public boolean excluirAnimal(String identificador){
	boolean resultado = false;
	
	String sql = "DELETE FROM Animal WHERE Identificacao='"+identificador+"'";
	
	resultado = conexao.executarSQL(sql);
	
	
	return resultado;
}

public int retornaIdAnimal(String identificador){
	int indice=0;
	
	
	String sql = "SELECT idAnimal  FROM Animal WHERE Identificacao='"+identificador+"'";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
				indice = Dadosusuarios.getInt(1);
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return indice;
}

public boolean verificarIdentificadorExiste(String identificador){
	boolean resultado = false;
	
	String sql = "SELECT Identificacao  FROM Animal";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
			if(Dadosusuarios.getString(1).equalsIgnoreCase(identificador)){
				resultado = true;
			}
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	return resultado;
}

public int QuantAnimal(String ani){
	int cont = 0;
	
	
	String sql = "SELECT * FROM Animal a, Raca r WHERE r.Animal ='"+ani+"' AND r.IdRaca =Raca  AND Status ='V'";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {
			cont++;	
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	

	return cont;
}

public int QuantAnimalMacho(String ani){
	int cont = 0;
	
	
	String sql = "SELECT * FROM Animal a, Raca r WHERE r.Animal ='"+ani+"' AND r.IdRaca = a.Raca AND a.Sexo='M' AND Status ='V' ";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {	
			cont++;	
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return cont;
}

public int QuantAnimalFemias(String ani){
	int cont = 0;
	
	
	String sql = "SELECT * FROM Animal a, Raca r WHERE r.Animal ='"+ani+"'  AND r.IdRaca = a.Raca AND a.Sexo='F' AND Status ='V'";
	ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
	
	try {
		while (Dadosusuarios.next()) {	
			cont++;	
		}
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	

	return cont;
}



}
