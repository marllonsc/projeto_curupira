package code.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SqlConfiguracoes {
	
	private ConexaoBanco conexao = new ConexaoBanco();
	
	// FUNÇÕES DE CADASTRAR
	
	public boolean cadastraRaca(String nome, String animal) {

		boolean resultado = false;
		
		String sql = "insert into Raca(Descricao,Animal) Values('"+nome+"','"+animal+"')";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	
	public boolean cadastraCategoria(String nome, String animal) {

		boolean resultado = false;
		
		String sql = "insert into Categoria(Descricao,Animal) Values('"+nome+"','"+animal+"')";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	
	public boolean cadastraPraticaZoo(String pratica) {

		boolean resultado = false;
		
		String sql = "insert into Zootecnica(Pratica) Values('"+pratica+"')";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	
	public boolean cadastraVacina(String nome, String periodo) {

		boolean resultado = false;
		
		String sql = "insert into Vacina(Descricao,Periodo) Values('"+nome+"','"+periodo+"')";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	//FUNCÕES DE EXCLUIR
	
	public boolean excluirRaca(String nome){
		boolean resultado = false;
		
		String sql = "DELETE FROM Raca WHERE Descricao='"+nome+"'";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	
	public boolean excluirCategoria(String nome){
		boolean resultado = false;
		
		String sql = "DELETE FROM Categoria WHERE Descricao='"+nome+"'";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	public boolean excluirPraticaZoo(String pratica){
		boolean resultado = false;
		
		String sql = "DELETE FROM Zootecnica WHERE Pratica='"+pratica+"'";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	public boolean excluirVacina(String nome){
		boolean resultado = false;
		
		String sql = "DELETE FROM Vacina WHERE Descricao='"+nome+"'";
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	//FUNÇÕES DE RETORNO DE STRINGS
	
	public Vector<String> retornaNomeCategoria(){
		Vector<String> resultado = new Vector<String>();
		
		resultado.add("");
		String sql = "SELECT Descricao FROM Categoria";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					resultado.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	
	return resultado;
	}
	
	public Vector<String> retornaNomeRaca(){
		Vector<String> resultado = new Vector<String>();
		
		resultado.add("");
		String sql = "SELECT Descricao FROM Raca";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					resultado.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	
	return resultado;
	
	}
	
	
	public Vector<String> retornaPraticaZoo(){
		Vector<String> resultado = new Vector<String>();
		
		resultado.add("");
		String sql = "SELECT Pratica FROM Zootecnica";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					resultado.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	
	return resultado;
	
	}
	
	
	public Vector<String> retornaVacinas(){
		Vector<String> resultado = new Vector<String>();
		
		resultado.add("");
		String sql = "SELECT Descricao FROM Vacina";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					resultado.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	
	return resultado;
	
	}


}
