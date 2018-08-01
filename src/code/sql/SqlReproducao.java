package code.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import code.dados.Filhote;


public class SqlReproducao {
	
	private ConexaoBanco conexao = new ConexaoBanco();
	
	
	//RETORNA QUANTIDADE DE ANIMAIS NO CIO
	
	public int retornaVacasCio(String data, String animal){
		int resultado = 0;
	
		String sql = "SELECT a.Data_Cio FROM  Categoria c, Animal a WHERE c.idCategoria = a.Categoria AND c.Animal='"+animal+"' AND a.Data_Cio IS NOT NULL AND a.Data_Cio!=''";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
				String dataCio[] = Dadosusuarios.getString(1).split("/");
				String dataSistema[] = data.split("/");
				
					if(Integer.parseInt(dataCio[2])>Integer.parseInt(dataSistema[2])){
						resultado++;
					}else if(Integer.parseInt(dataCio[2])==Integer.parseInt(dataSistema[2])){
						if(Integer.parseInt(dataCio[1])>Integer.parseInt(dataSistema[1])){
							resultado++;
						}else if(Integer.parseInt(dataCio[1])==Integer.parseInt(dataSistema[1])){
							if(Integer.parseInt(dataCio[0])>Integer.parseInt(dataSistema[0]) || Integer.parseInt(dataCio[0])==Integer.parseInt(dataSistema[0])){
								resultado++;
							}
						}
					}
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//RETORNA QUANTIDADE DE ANIMAIS PRENHAS
	
	public int retornaVacasPrenhas(String animal){
		int resultado = 0;
	
		String sql = "SELECT a.Prenha FROM Categoria c, Animal a WHERE c.idCategoria = a.Categoria AND c.Animal='"+animal+"' AND a.Prenha IS NOT NULL";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
		
				if(Dadosusuarios.getString(1).equalsIgnoreCase("S")){
					
					resultado++;
					
				}
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//RETORNA QUANTIDADE DE CRIAS
	
	public int retornaQtCrias(String animal){
		int resultado = 0;
	
		String sql = "SELECT hc.idCria FROM Historico_Cria hc, Categoria c, Animal a WHERE c.idCategoria = a.Categoria AND a.idAnimal = hc.Animal_idAnimal AND c.Animal='"+animal+"'";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					resultado++;
					
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//RETORNA A QUANTIDADE DE ABORTOS
	
	public int retornaQtAbortos(String animal){
		int resultado = 0;
	
		String sql = "SELECT hc.Data_Aborto FROM Historico_Cria hc, Categoria c, Animal a WHERE c.idCategoria = a.Categoria AND a.idAnimal = hc.Animal_idAnimal AND c.Animal='"+animal+"' AND hc.Data_Aborto IS NOT NULL";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					resultado++;
					
				
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	
	//RETORNAR A MORTES DOS ANIMAIS
	
	public int retornaQtMortes(String animal){
		int resultado = 0;
	
		String sql = "SELECT a.Status FROM Animal a, Categoria c WHERE c.idCategoria = a.Categoria AND c.Animal='"+animal+"' AND a.Status = 'M'";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					resultado++;
					
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//SELECIONA QUANTIDADE DE CRIAS DE UM ANIMAL ESPECIFICO
	
	public int retornaQtCriaAnimal(String animal, String idAnimal){
		int resultado = 0;
	
		String sql = "SELECT hc.idCria FROM  Historico_Cria hc, Categoria c, Animal a WHERE  a.idAnimal = hc.Animal_idAnimal AND c.Animal='"+animal+"' AND a.Identificacao='"+idAnimal+"'AND a.Categoria=c.idCategoria";

		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					resultado++;
					
				
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//SELECIONA A QUANTIDADE DE ABORTOS DE UM ANIMAL ESPECIFICO
	
	public int retornaQtAbortoAnimal(String animal, String idAnimal){
		int resultado = 0;
	
		String sql = "SELECT hc.Data_Aborto FROM  Historico_Cria hc, Categoria c, Animal a WHERE  a.idAnimal = hc.Animal_idAnimal AND c.Animal='"+animal+"' AND a.Identificacao='"+idAnimal+"' AND a.Categoria=c.idCategoria AND hc.Data_Aborto IS NOT NULL";

		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					resultado++;
					
				
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	// SELECT a2.Status FROM Animal a, Animal a2, Historico_Reproducao hr, Categoria c WHERE a2.Status='M' AND a.idAnimal = hr.Animal_idAnimal AND a2.idAnimal = hr.Animal_idAnimal AND hr.Cria = a2.Identificacao
	
	
	private int retornaQtMortalidade(String animal, String indice){
		int resultado = 0;
		
		String sql = "SELECT a.Status FROM Animal a, Categoria c Where a.Status='M' AND c.idCategoria = a.categoria AND c.Animal='"+animal+"' AND a.Identificacao='"+indice+"' AND a.Categoria=c.idCategoria";

		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					resultado++;
					
				
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//Retorna o vector do  indeces das crias 
	
	private Vector<String> retornaVectorIndeceCrias(String animal, String indice){
		
		Vector<String> resultado = new Vector<String>();
		
		String sql = "SELECT hc.idCria FROM  Historico_Cria hc, Categoria c, Animal a WHERE  a.idAnimal = hc.Animal_idAnimal AND c.Animal='"+animal+"' AND a.Identificacao="+indice+" AND a.Categoria=c.idCategoria";
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
	
	//RETORNA A MORTALIDADE DO ANIMAL
	
	public int  retornaMortalidadeAnimal(String animal, String indece){
		int resultado = 0;
		
		Vector<String> crias = retornaVectorIndeceCrias(animal, indece);
		int quantidadeCrias = retornaQtCriaAnimal(animal, indece);
	
		for (int i = 0; i < quantidadeCrias; i++) {
			
			resultado = resultado + retornaQtMortalidade(crias.elementAt(i),indece);
			
		}
		
		return resultado;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------
	//FUNÇÃO DE UPDATE DE CIO E PRENHA 
	
	public boolean cadastrarReprodutora(String cio,String prenha,String idAnimal){
		boolean resultado = false;
		String sql;
		String vazia="";
		if(!cio.equalsIgnoreCase("")){
			sql = "UPDATE Animal SET Data_Cio ='"+cio+"', Prenha = '"+prenha+"' WHERE Identificacao = '"+idAnimal+"'";
		}else{
			sql = "UPDATE Animal SET Data_Cio ='"+vazia+"', Prenha = '"+prenha+"' WHERE Identificacao = '"+idAnimal+"'";
		}
		
		resultado = conexao.executarSQL(sql);
		
		return resultado;
	}
	
	public boolean cadastrarDadosFilhote(Filhote filhote){
		boolean resultado = false;
		int idMae = 0;
		int idCria = 0;
		
		String sql = "SELECT a.idAnimal FROM  Animal a WHERE  a.Identificacao = '"+filhote.getIdMae()+"'";
		ResultSet Dadosusuarios = conexao.executarBuscaSQL(sql);
		
		try {
			while (Dadosusuarios.next()) {
					
					idMae = Dadosusuarios.getInt(1);
					
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "SELECT a.idAnimal FROM  Animal a WHERE  a.Identificacao = '"+filhote.getIdCria()+"'";
		ResultSet Dadosusuarios2 = conexao.executarBuscaSQL(sql2);
		
		try {
			while (Dadosusuarios2.next()) {
					
					idCria = Dadosusuarios2.getInt(1);
	
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String sql3 = "insert into Historico_Cria(idCria,Data_Desmame,Data_Aborto,Cura_Umbigo,Colastro,Marcacao,Animal_idAnimal) Values("+idCria+",'"+filhote.getDataDesmame()+"','"+filhote.getDataAborto()+"','"+filhote.getCuraUmbigo()+"','"+filhote.getColastro()+"','"+filhote.getMarcacao()+"',"+idMae+")";
		
		resultado = conexao.executarSQL(sql3);
		
		
		return resultado;
	}
}
