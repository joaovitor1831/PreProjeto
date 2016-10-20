package br.com.req.conexao;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;




public class ConnectionFactory {
	private final String USER="root";
	private final String URL="jdbc:mysql://localhost/novoreq";
	private final String PASSWORD="";
	private Connection con=null;
	private Statement sta=null;
public Connection getConnection()  {
    System.out.println("Conectando ao banco");  
   // Class.forName("com.mysql.jdbc.Driver");
     try {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	catch(ClassNotFoundException e){
		throw new RuntimeException(e);
	}

}
public void dml(String query){
	try{
		sta.executeUpdate(query);
	}catch(Exception ex){
		JOptionPane.showMessageDialog(null, "ERRO: " + ex);
	}
}

public ResultSet consultar(String query){
	try{
		System.out.println(query);
		return sta.executeQuery(query);
	
	}catch(Exception ex){
		JOptionPane.showMessageDialog(null, "ERRO: " + ex);
		return null;
	}
}
}
