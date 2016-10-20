/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.dao;

import br.com.req.bean.Funcionario;
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

    public class FuncionarioDAO {
    private Connection connection;
	private int cod1=0,cod=0;
	public FuncionarioDAO(){
		this.connection=new ConnectionFactory().getConnection();
	}
        public void adiciona(Funcionario funcionario) {
		String sql=" insert into funcionario(nome_funcionario,cpf_cnpj_funcionario,fone_funcionario,sexo_funcionario,logradouro_funcionario,cidade_funcionario"
				+ ",estado_funcionario,compl_funcionario,dta_cad_funcionario,email_funcionario,cargo_funcionario) values(?,?,?,?,?,?,?,?,?,?,?)";
	
		try{
			  
			   PreparedStatement stmt = connection.prepareStatement(sql);

			 
			   
			   stmt.setString(1, funcionario.getNome_funcionario());
			   stmt.setString(2, funcionario.getCpf_cnpj_funcionario());
			   stmt.setString(3, funcionario.getFone_funcionario());
			   stmt.setString(4, funcionario.getSexo_funcionario());
			   stmt.setString(5, funcionario.getLogradouro_funcionario());
			   stmt.setString(6, funcionario.getCidade_funcionario());
			   stmt.setString(7, funcionario.getEstado_funcionario());
			   stmt.setString(8,funcionario.getCompl_funcionario());
			   stmt.setDate(9, new Date(funcionario.getDta_cad_funcionario().getTimeInMillis()));
			   stmt.setString(10, funcionario.getEmail_funcionario());
			   stmt.setString(11, funcionario.getCargo_funcionario());
                           
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
      		System.out.println("codigo funcionario--->" + cod2);
		//return cod;
		}
		catch(SQLException e){
			e.getMessage();
		}
		return cod;
		
	}
        public void remove(String name){
		 String eng="SELECT funcionario.cod_funcionario FROM funcionario WHERE funcionario.nome_funcionario =  '"+name+"'";
		     PreparedStatement stmt ,stmt2;
			
		try{
			stmt = connection.prepareStatement(eng);
			  ResultSet rs = stmt.executeQuery();
				 
	      		rs.next();
	      		int cod1=rs.getInt(1);
	      		System.out.println("codigo funcionario--->" + cod1);
			 stmt2 = connection.prepareStatement ("DELETE FROM funcionario WHERE funcionario.cod_funcionario ='"+cod1+"'");
			// DELETE FROM `cliente` WHERE (`cod_cliente`='5')
			 stmt2.executeUpdate();
			 stmt.close();
			 stmt2.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
        public List<Funcionario> getLista() {
           try {
           List<Funcionario> funcionarios= new ArrayList<Funcionario>();
           PreparedStatement stmt = this.connection.prepareStatement("select * from  funcionario");
          ResultSet rs = stmt.executeQuery();
          
           while (rs.next()) {
           // criando o objeto funcionario
           Funcionario funcionario=new Funcionario();
           funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
           funcionario.setNome_funcionario(rs.getString("nome_funcionario"));
           funcionario.setCpf_cnpj_funcionario(rs.getString("cpf_cnpj_funcionario"));
           funcionario.setFone_funcionario(rs.getString("fone_funcionario"));
           funcionario.setSexo_funcionario(rs.getString("sexo_funcionario"));
           funcionario.setLogradouro_funcionario(rs.getString("logradouro_funcionario"));
           funcionario.setCidade_funcionario(rs.getString("cidade_funcionario"));
           funcionario.setEstado_funcionario(rs.getString("estado_funcionario"));
           funcionario.setCompl_funcionario(rs.getString("compl_funcionario"));
	   Calendar data = Calendar.getInstance();
	   data.setTime(rs.getDate("dta_cad_funcionario"));
	   funcionario.setDta_cad_funcionario(data);
           funcionario.setEmail_funcionario(rs.getString("email_funcionario"));
           funcionario.setCargo_funcionario(rs.getString("cargo_funcionario"));
         
           // adicionando o objeto à lista
           funcionarios.add(funcionario);
           }
           rs.close();
           stmt.close();
           return funcionarios;
           } catch (SQLException e) {
           throw new RuntimeException(e);
           }
    }
        public void Alterar(Funcionario funcionario){
            String eng="SELECT funcionario.cod_funcionario FROM funcionario WHERE funcionario.nome_funcionario=  '"+funcionario.getNome_funcionario()+"'";
		     PreparedStatement stmt ,stmt2;
                     stmt = null;
                     stmt2=null;
            try{
                        stmt = connection.prepareStatement(eng);
			ResultSet rs = stmt.executeQuery();
				             
	      		rs.next();
                        
	      		int cod1=rs.getInt(1);
                
		           String sql="UPDATE `funcionario` SET `nome_funcionario`=?,`cpf_cnpj_funcionario`=?,`fone_funcionario`=?,`sexo_funcionario`=?,`logradouro_funcionario`=?,`cidade_funcionario`=?,`estado_funcionario`=?,`compl_funcionario`=?,`dta_cad_funcionario`=?,`email_funcionario`=?,`cargo_funcionario`=? WHERE `cod_funcionario`='"+cod1+"' ";
			    stmt2 = connection.prepareStatement(sql);

			  // PreparedStatement stmt2 = connection.prepareStatement(sql2);
			   
			   stmt2.setString(1, funcionario.getNome_funcionario());
			   stmt2.setString(2, funcionario.getCpf_cnpj_funcionario());
			   stmt2.setString(3, funcionario.getFone_funcionario());
			   stmt2.setString(4, funcionario.getSexo_funcionario());
			   stmt2.setString(5, funcionario.getLogradouro_funcionario());
			   stmt2.setString(6, funcionario.getCidade_funcionario());
			   stmt2.setString(7, funcionario.getEstado_funcionario());
			   stmt2.setString(8,funcionario.getCompl_funcionario());
			   stmt2.setDate(9, new Date(funcionario.getDta_cad_funcionario().getTimeInMillis()));
	           	   stmt2.setString(10, funcionario.getEmail_funcionario());
			   stmt2.setString(11, funcionario.getCargo_funcionario());
			   
			   stmt2.execute();
		       stmt2.close();
                       stmt.close();
		}catch(SQLException e){
                    
			 throw new RuntimeException(e);
		}
            
        }
        
        
        
        public Vector<Funcionario> consulta(){
			//System.out.println(codigo);// imprime o valor do codigo
			Vector<Funcionario> lista = new Vector<Funcionario>();
			 connection=new ConnectionFactory().getConnection();
			
		
			String sql2 = " select * from  funcionario";
			//Conexao t = new Conexao();
				
			
			try{
				  PreparedStatement stmt = connection.prepareStatement(sql2);	
				  ResultSet rs = stmt.executeQuery();
				if(rs.next()){		
			
					
					do{
                                           Funcionario funcionario=new Funcionario();
				           funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
				           funcionario.setNome_funcionario(rs.getString("nome_funcionario"));
				           funcionario.setCpf_cnpj_funcionario(rs.getString("cpf_cnpj_funcionario"));
				           funcionario.setFone_funcionario(rs.getString("fone_funcionario"));
				           funcionario.setSexo_funcionario(rs.getString("sexo_funcionario"));
				           funcionario.setLogradouro_funcionario(rs.getString("logradouro_funcionario"));
				           funcionario.setCidade_funcionario(rs.getString("cidade_funcionario"));
				           funcionario.setEstado_funcionario(rs.getString("estado_funcionario"));
				           funcionario.setCompl_funcionario(rs.getString("compl_funcionario"));
					   Calendar data = Calendar.getInstance();
					   data.setTime(rs.getDate("dta_cad_funcionario"));
					   funcionario.setDta_cad_funcionario(data);
				           funcionario.setEmail_funcionario(rs.getString("email_funcionario"));
				           funcionario.setCargo_funcionario(rs.getString("cargo_funcionario"));
                                           
				         // adicionando o objeto à lista
				         lista.add(funcionario);
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


