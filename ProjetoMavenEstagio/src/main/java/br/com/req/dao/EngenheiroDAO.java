/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.dao;

import br.com.req.bean.Cliente;
import br.com.req.bean.Engenheiro;
import br.com.req.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author joao vitor
 */
public class EngenheiroDAO {
    private Connection connection;
	private int cod1=0,cod=0;
	public EngenheiroDAO(){
		this.connection=new ConnectionFactory().getConnection();
	}
        public void adiciona(Engenheiro engenheiro) {
		String sql=" insert into engenheiro(nome_engenheiro,cpf_cnpj_engenheiro,fone_engenheiro,sexo_engenheiro,logradouro_engenheiro,cidade_engenheiro"
				+ ",estado_engenheiro,compl_engenheiro,dta_cad_engenheiro,email_engenheiro,rg_engenheiro) values(?,?,?,?,?,?,?,?,?,?,?)";
	
		try{
			  
			   PreparedStatement stmt = connection.prepareStatement(sql);

			 
			   
			   stmt.setString(1, engenheiro.getNome_engenheiro());
			   stmt.setString(2, engenheiro.getCpf_cnpj_engenheiro());
			   stmt.setString(3, engenheiro.getFone_engenheiro());
			   stmt.setString(4, engenheiro.getSexo_engenheiro());
			   stmt.setString(5, engenheiro.getLogradouro_engenheiro());
			   stmt.setString(6, engenheiro.getCidade_engenheiro());
			   stmt.setString(7, engenheiro.getEstado_engenheiro());
			   stmt.setString(8,engenheiro.getCompl_engenheiro());
			   stmt.setDate(9, new Date(engenheiro.getDta_cad_engenheiro().getTimeInMillis()));
			   stmt.setString(10, engenheiro.getEmail_engenheiro());
			   stmt.setString(11, engenheiro.getRg_engenheiro());
			   
			   stmt.execute();
		       stmt.close();
		}catch(SQLException e){
			 throw new RuntimeException(e);
		}
	}
        public int verifica(String sql) throws SQLException{
		 PreparedStatement stmt = null;

	
		try{ //connection=(Connection) new ConnectionFactory().getConnection();
		stmt = connection.prepareStatement(sql);
		  ResultSet rs = stmt.executeQuery();
		 
      		rs.next();
      		  int cod2=rs.getInt(1);
      		  if(cod2>0)
      			  cod=1;
      		System.out.println("codigo engenheiro--->" + cod2);
		//return cod;
		}
		catch(SQLException e){
			e.getMessage();
		}
		return cod;
		
	}
        public void remove(String name){
		 String eng="SELECT engenheiro.cod_engenheiro FROM engenheiro WHERE engenheiro.nome_engenheiro =  '"+name+"'";
		     PreparedStatement stmt ,stmt2;
			
		try{
			stmt = connection.prepareStatement(eng);
			  ResultSet rs = stmt.executeQuery();
				 
	      		rs.next();
	      		int cod1=rs.getInt(1);
	      		System.out.println("codigo engenheiro--->" + cod1);
			 stmt2 = connection.prepareStatement ("DELETE FROM engenheiro WHERE engenheiro.cod_engenheiro ='"+cod1+"'");
			// DELETE FROM `cliente` WHERE (`cod_cliente`='5')
			 stmt2.executeUpdate();
			 stmt.close();
			 stmt2.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
        public List<Engenheiro> getLista() {
           try {
           List<Engenheiro> engenheiros= new ArrayList<Engenheiro>();
           PreparedStatement stmt = this.connection.prepareStatement("select * from  engenheiro");
          ResultSet rs = stmt.executeQuery();
          
           while (rs.next()) {
           // criando o objeto funcionario
           Engenheiro engenheiro=new Engenheiro();
           engenheiro.setCod_engenheiro(rs.getInt("cod_Engenheiro"));
           engenheiro.setNome_engenheiro(rs.getString("nome_engenheiro"));
           engenheiro.setCpf_cnpj_engenheiro(rs.getString("cpf_cnpj_engenheiro"));
           engenheiro.setFone_engenheiro(rs.getString("fone_engenheiro"));
           engenheiro.setSexo_engenheiro(rs.getString("sexo_engenheiro"));
           engenheiro.setLogradouro_engenheiro(rs.getString("logradouro_engenheiro"));
           engenheiro.setCidade_engenheiro(rs.getString("cidade_engenheiro"));
           engenheiro.setEstado_engenheiro(rs.getString("estado_engenheiro"));
           engenheiro.setCompl_engenheiro(rs.getString("compl_engenheiro"));
	       Calendar data = Calendar.getInstance();
	       data.setTime(rs.getDate("dta_cad_engenheiro"));
	       engenheiro.setDta_cad_engenheiro(data);
           engenheiro.setEmail_engenheiro(rs.getString("email_engenheiro"));
           engenheiro.setRg_engenheiro(rs.getString("rg_engenheiro"));
         
         
           // adicionando o objeto à lista
           engenheiros.add(engenheiro);
           }
           rs.close();
           stmt.close();
           return engenheiros;
           } catch (SQLException e) {
           throw new RuntimeException(e);
           }
    }
        public void Alterar(Engenheiro engenheiro){
            String eng="SELECT engenheiro.cod_engenheiro FROM engenheiro WHERE engenheiro.nome_engenheiro=  '"+engenheiro.getNome_engenheiro()+"'";
		     PreparedStatement stmt ,stmt2;
                     stmt = null;
                     stmt2=null;
            try{
                        stmt = connection.prepareStatement(eng);
			ResultSet rs = stmt.executeQuery();
				             
	      		rs.next();
                        
	      		int cod1=rs.getInt(1);
                
		           String sql="UPDATE `engenheiro` SET `nome_engenheiro`=?,`cpf_cnpj_engenheiro`=?,`fone_engenheiro`=?,`sexo_engenheiro`=?,`logradouro_engenheiro`=?,`cidade_engenheiro`=?,`estado_engenheiro`=?,`compl_engenheiro`=?,`dta_cad_engenheiro`=?,`email_engenheiro`=?,`rg_engenheiro`=? WHERE `cod_engenheiro`='"+cod1+"' ";
			    stmt2 = connection.prepareStatement(sql);

			  // PreparedStatement stmt2 = connection.prepareStatement(sql2);
			   
			   stmt2.setString(1, engenheiro.getNome_engenheiro());
			   stmt2.setString(2, engenheiro.getCpf_cnpj_engenheiro());
			   stmt2.setString(3, engenheiro.getFone_engenheiro());
			   stmt2.setString(4, engenheiro.getSexo_engenheiro());
			   stmt2.setString(5, engenheiro.getLogradouro_engenheiro());
			   stmt2.setString(6, engenheiro.getCidade_engenheiro());
			   stmt2.setString(7, engenheiro.getEstado_engenheiro());
			   stmt2.setString(8,engenheiro.getCompl_engenheiro());
			   stmt2.setDate(9, new Date(engenheiro.getDta_cad_engenheiro().getTimeInMillis()));
	           
			   stmt2.setString(10, engenheiro.getEmail_engenheiro());
			   stmt2.setString(11, engenheiro.getRg_engenheiro());
			   
			   stmt2.execute();
		       stmt2.close();
                       stmt.close();
		}catch(SQLException e){
                    
			 throw new RuntimeException(e);
		}
            
        }
        
        
        
        public Vector<Engenheiro> consulta(){
			//System.out.println(codigo);// imprime o valor do codigo
			Vector<Engenheiro> lista = new Vector<Engenheiro>();
			 connection=new ConnectionFactory().getConnection();
			
		
			String sql2 = " select * from  engenheiro";
			//Conexao t = new Conexao();
				
			
			try{
				  PreparedStatement stmt = connection.prepareStatement(sql2);	
				  ResultSet rs = stmt.executeQuery();
				if(rs.next()){		
			
					
					do{
						 Engenheiro engenheiro=new Engenheiro();
				           engenheiro.setCod_engenheiro(rs.getInt("cod_engenheiro"));
				           engenheiro.setNome_engenheiro(rs.getString("nome_engenheiro"));
				           engenheiro.setCpf_cnpj_engenheiro(rs.getString("cpf_cnpj_engenheiro"));
				           engenheiro.setFone_engenheiro(rs.getString("fone_engenheiro"));
				           engenheiro.setSexo_engenheiro(rs.getString("sexo_engenheiro"));
				           engenheiro.setLogradouro_engenheiro(rs.getString("logradouro_engenheiro"));
				           engenheiro.setCidade_engenheiro(rs.getString("cidade_engenheiro"));
				           engenheiro.setEstado_engenheiro(rs.getString("estado_engenheiro"));
				           engenheiro.setCompl_engenheiro(rs.getString("compl_engenheiro"));
					       Calendar data = Calendar.getInstance();
					       data.setTime(rs.getDate("dta_cad_engenheiro"));
					       engenheiro.setDta_cad_engenheiro(data);
				           engenheiro.setEmail_engenheiro(rs.getString("email_engenheiro"));
				           engenheiro.setRg_engenheiro(rs.getString("rg_engenheiro"));
				         
				         // adicionando o objeto à lista
				         lista.add(engenheiro);
					}while(rs.next());
					   rs.close();
				        stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return lista;
		}
}
