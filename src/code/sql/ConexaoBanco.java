package code.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ConexaoBanco {
	
	private Connection con;

	public ConexaoBanco(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/curupira", "root", "werewolf");
		}catch(Exception e){
			//System.out.println("Nao foi possivel conectar");
			//JOptionPane.showMessageDialog(null, "Nao foi possivel conectar");
		}
	}
	
	
	public boolean executarSQL(String sql){
		boolean result = true;
		 try{
	
			Statement st = con.createStatement();
			st.execute(sql);
			st.close();
		 }
		 catch(Exception e) {
			 System.out.println("Nao foi possivel executar SQL.");
			 //JOptionPane.showMessageDialog(null, "Nao foi possivel executar SQL.");
			 result = false;
		 }
		 return result;
	}

	
	public ResultSet executarBuscaSQL(String sql){
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		 }
		 catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar dados.");
			//System.out.println("Nao foi possivel recuperar dados.");
			return null;
		 }
		
	}
	

	/* private int getRowCount(ResultSet rs){
		int rows = 0;
		try{
			rs.last();              //leva para a ultima linha
			rows = rs.getRow();     //retorna a linha atual
			rs.beforeFirst();		//retorna para antes da primeira linha	
		}catch(Exception e){
			System.out.println("Erro ao capturar a quantidade de linhas do resultset");
		}	
		return rows;
	} */
	
	public void setComitTrue() {
		
		
		try {
			//con.setAutoCommit(true);
			con.commit();
		} catch (SQLException e) {
			System.out.println("Erro ao setar verdadeiro no commit");
		}
	
	}
	
	public void setComitFalse() {
		
		
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Erro ao setar verdadeiro no commit");
		}
	
	} 

}
