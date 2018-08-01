package code.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import code.dados.HistoricoZootecnia;
import code.dados.TabelaZootecnica;
import code.dados.Zootecnica;

public class SqlZootecnia {
	
	private ConexaoBanco conexao = new ConexaoBanco();
	
	public boolean cadastrarPratizaZootecnica(HistoricoZootecnia historicoZootecnia){
		boolean resultado = false;
		String sql = "insert into Historico_Zootecnica(Animal_idAnimal,Zootecnica_idZootecnica,Data,Observacao) Values("+historicoZootecnia.getIdAnimal()+","+historicoZootecnia.getIdZootecnia()+",'"+historicoZootecnia.getData()+"','"+historicoZootecnia.getObservacao()+"')";
		resultado = conexao.executarSQL(sql);
		return resultado;
	}
	
	public boolean deletarPraticaZootecnica(int idAnimal,String obs, String data){
		boolean resultado = false;
		String sql = "DELETE FROM Historico_Zootecnica WHERE Animal_idAnimal="+idAnimal+" AND Data ='"+data+"' AND Observacao = '"+obs+"'";
		resultado = conexao.executarSQL(sql);
		return resultado;
	}
	
	public Vector<TabelaZootecnica> retornaPZootecniaAnimal(int idAnimal){
		String sql = "SELECT hv.Data,hv.Observacao,v.Pratica FROM Historico_Zootecnica hv , Zootecnica v WHERE hv.Animal_idAnimal ='"+idAnimal+"' AND hv.Zootecnica_idZootecnica=v.idZootecnica";
		Vector<TabelaZootecnica> vacinaTabelas = new Vector<TabelaZootecnica>();
		
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				TabelaZootecnica tabelaZootecnica = new TabelaZootecnica(Dadosusuarios.getString(1), Dadosusuarios.getString(2), Dadosusuarios.getString(3));
				vacinaTabelas.add(tabelaZootecnica);
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return vacinaTabelas;
	}
	
	public Vector<Zootecnica> retornaPraticasZoo(){
		String sql = "SELECT * FROM Zootecnica";
		Vector<Zootecnica> vacinas = new Vector<Zootecnica>();
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				Zootecnica zootecnica  = new Zootecnica(Dadosusuarios.getInt(1), Dadosusuarios.getString(2));
				vacinas.add(zootecnica);
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return vacinas;
	}
	
	public Vector<String> retornaZooPratica(){
		String sql = "SELECT Pratica FROM Zootecnica";
		Vector<String> vacinas = new Vector<String>();
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
	
	public Vector<String> retornaVectorDatas(int idAnimal){
		String sql = "SELECT hv.Data FROM Historico_Zootecnica hv , Zootecnica v WHERE hv.Animal_idAnimal ='"+idAnimal+"' AND hv.Zootecnica_idZootecnica=v.idZootecnica";
		Vector<String> vacinaTabelas = new Vector<String>();
		
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				vacinaTabelas.add(Dadosusuarios.getString(1));
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return vacinaTabelas;
	}
	

}
