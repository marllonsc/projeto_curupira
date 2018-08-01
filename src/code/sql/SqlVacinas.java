package code.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import code.dados.HistoricoVacina;
import code.dados.Vacina;
import code.dados.VacinaTabela;


public class SqlVacinas {
	
	private ConexaoBanco conexao = new ConexaoBanco();
	
	public boolean cadastrarVacinaAnimal(HistoricoVacina historicoVacina){
		Boolean resultado = false;
		String sql = "insert into Historico_Vacina(Vacina_idVacina,Animal_idAnimal,Data,Observacao) Values("+historicoVacina.getIdVacina()+","+historicoVacina.getIdAnimal()+",'"+historicoVacina.getData()+"','"+historicoVacina.getObs()+"')";
		resultado = conexao.executarSQL(sql);
		return resultado;
	}
	
	public boolean excluirVacinaAnimal(int idAnimal,String obs, String data){
		Boolean resultado = false;
		String sql = "DELETE FROM Historico_Vacina WHERE Animal_idAnimal="+idAnimal+" AND Data ='"+data+"' AND Observacao = '"+obs+"'";
		resultado = conexao.executarSQL(sql);
		return resultado;
	}
	
	public Vector<VacinaTabela> retornaVacinasAnimal(int idAnimal){
		String sql = "SELECT hv.Data,hv.Observacao,v.Descricao,v.Periodo FROM Historico_Vacina hv , Vacina v WHERE hv.Animal_idAnimal ='"+idAnimal+"' AND hv.Vacina_idVacina=v.idVacina";
		Vector<VacinaTabela> vacinaTabelas = new Vector<VacinaTabela>();
		
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				VacinaTabela vacinaTabela = new VacinaTabela(Dadosusuarios.getString(1), Dadosusuarios.getString(2), Dadosusuarios.getString(3), Dadosusuarios.getString(4));
				vacinaTabelas.add(vacinaTabela);
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return vacinaTabelas;
	}
	
	
	public Vector<Vacina> retornaVacinas(){
		String sql = "SELECT * FROM Vacina";
		Vector<Vacina> vacinas = new Vector<Vacina>();
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				Vacina vacina = new Vacina(Dadosusuarios.getInt(1), Dadosusuarios.getString(2), Dadosusuarios.getString(3));
				vacinas.add(vacina);
			}
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return vacinas;
	}
	
	public Vector<String> retornaVacinasPeriodo(){
		String sql = "SELECT Periodo FROM Vacina";
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
		String sql = "SELECT hv.Data FROM Historico_Vacina hv , Vacina v WHERE hv.Animal_idAnimal ='"+idAnimal+"' AND hv.Vacina_idVacina=v.idVacina";
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
