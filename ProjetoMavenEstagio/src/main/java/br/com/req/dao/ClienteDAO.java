package br.com.req.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import br.com.req.bean.Cliente;

import br.com.req.conexao.ConnectionFactory;

public class ClienteDAO {
	private Connection connection;
	private int cod1=0,cod=0;
	public ClienteDAO(){
		this.connection=new ConnectionFactory().getConnection();
	}
	public void adiciona(Cliente cliente) {
		String sql=" insert into cliente(nome_cliente,cpf_cnpj_cliente,fone_cliente,sexo_cliente,logradouro_cliente,cidade_cliente"
				+ ",estado_cliente,compl_cliente,dta_cad_cliente,email_cliente,rg_cliente) values(?,?,?,?,?,?,?,?,?,?,?)";
	
		try{
			  
			   PreparedStatement stmt = connection.prepareStatement(sql);

			  // PreparedStatement stmt2 = connection.prepareStatement(sql2);
			   
			   stmt.setString(1, cliente.getNome_cliente());
			   stmt.setString(2, cliente.getCpf_cnpj_cliente());
			   stmt.setString(3, cliente.getFone_cliente());
			   stmt.setString(4, cliente.getSexo_cliente());
			   stmt.setString(5, cliente.getLogradouro_cliente());
			   stmt.setString(6, cliente.getCidade_cliente());
			   stmt.setString(7, cliente.getEstado_cliente());
			   stmt.setString(8,cliente.getCompl_cliente());
			   stmt.setDate(9, new Date(cliente.getDta_cad_cliente().getTimeInMillis()));
	           
			   stmt.setString(10, cliente.getEmail_cliente());
			   stmt.setString(11, cliente.getRg_cliente());
			   
			   stmt.execute();
		       stmt.close();
		}catch(SQLException e){
			 throw new RuntimeException(e);
		}
	}
        
            
        public void Alterar(Cliente cliente){
            String cli="SELECT cliente.cod_cliente FROM cliente WHERE cliente.nome_cliente=  '"+cliente.getNome_cliente()+"'";
		     PreparedStatement stmt ,stmt2;
                     stmt = null;
                     stmt2=null;
            try{
                        stmt = connection.prepareStatement(cli);
			ResultSet rs = stmt.executeQuery();
				             
	      		rs.next();
                        
	      		int cod1=rs.getInt(1);
                
		           String sql="UPDATE `cliente` SET `nome_cliente`=?,`cpf_cnpj_cliente`=?,`fone_cliente`=?,`sexo_cliente`=?,`logradouro_cliente`=?,`cidade_cliente`=?,`estado_cliente`=?,`compl_cliente`=?,`dta_cad_cliente`=?,`email_cliente`=?,`rg_cliente`=? WHERE `cod_cliente`='"+cod1+"' ";
			    stmt2 = connection.prepareStatement(sql);

			 
			   
			   stmt2.setString(1, cliente.getNome_cliente());
			   stmt2.setString(2, cliente.getCpf_cnpj_cliente());
			   stmt2.setString(3, cliente.getFone_cliente());
			   stmt2.setString(4, cliente.getSexo_cliente());
			   stmt2.setString(5, cliente.getLogradouro_cliente());
			   stmt2.setString(6, cliente.getCidade_cliente());
			   stmt2.setString(7, cliente.getEstado_cliente());
			   stmt2.setString(8,cliente.getCompl_cliente());
			   stmt2.setDate(9, new Date(cliente.getDta_cad_cliente().getTimeInMillis()));
	           
			   stmt2.setString(10, cliente.getEmail_cliente());
			   stmt2.setString(11, cliente.getRg_cliente());
			   
			   stmt2.execute();
		       stmt2.close();
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
      		System.out.println("codigo cliente--->" + cod2);
		//return cod;
		}
		catch(SQLException e){
			e.getMessage();
		}
		return cod;
		
	}
	public void remove(String name){
		 String cli="SELECT cliente.cod_cliente FROM cliente WHERE cliente.nome_cliente =  '"+name+"'";
		     PreparedStatement stmt ,stmt2;
			
		try{
			stmt = connection.prepareStatement(cli);
			  ResultSet rs = stmt.executeQuery();
				 
	      		rs.next();
	      		int cod1=rs.getInt(1);
	      		System.out.println("codigo cliente--->" + cod1);
			 stmt2 = connection.prepareStatement ("DELETE FROM cliente WHERE cliente.cod_cliente ='"+cod1+"'");
			// DELETE FROM `cliente` WHERE (`cod_cliente`='5')
			 stmt2.executeUpdate();
			 stmt.close();
			 stmt2.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	   public List<Cliente> getLista() {
           try {
           List<Cliente> clientes= new ArrayList<>();
               try (PreparedStatement stmt = this.connection.prepareStatement("select * from  cliente"); ResultSet rs = stmt.executeQuery()) {
                   
                   while (rs.next()) {
                       // criando o objeto funcionario
                       Cliente cliente=new Cliente();
                       cliente.setCod_cliente(rs.getInt("cod_cliente"));
                       cliente.setNome_cliente(rs.getString("nome_cliente"));
                       cliente.setCpf_cnpj_cliente(rs.getString("cpf_cnpj_cliente"));
                       cliente.setFone_cliente(rs.getString("fone_cliente"));
                       cliente.setSexo_cliente(rs.getString("sexo_cliente"));
                       cliente.setLogradouro_cliente(rs.getString("logradouro_cliente"));
                       cliente.setCidade_cliente(rs.getString("cidade_cliente"));
                       cliente.setEstado_cliente(rs.getString("estado_cliente"));
                       cliente.setCompl_cliente(rs.getString("compl_cliente"));
                       Calendar data = Calendar.getInstance();
                       data.setTime(rs.getDate("dta_cad_cliente"));
                       cliente.setDta_cad_cliente(data);
                       cliente.setEmail_cliente(rs.getString("email_cliente"));
                       cliente.setRg_cliente(rs.getString("rg_cliente"));
                       
                       
                       // adicionando o objeto à lista
                       clientes.add(cliente);
                   }
               }
           return clientes;
           } catch (SQLException e) {
           throw new RuntimeException(e);
           }
    }
	   public Vector<Cliente> consulta(){
			//System.out.println(codigo);// imprime o valor do codigo
			Vector<Cliente> lista = new Vector<Cliente>();
			 connection=new ConnectionFactory().getConnection();
			
		
			String sql2 = " select * from  cliente";
			//Conexao t = new Conexao();
				
			
			try{
				  PreparedStatement stmt = connection.prepareStatement(sql2);	
				  ResultSet rs = stmt.executeQuery();
				if(rs.next()){		
			
					
					do{
						 Cliente cliente=new Cliente();
				           cliente.setCod_cliente(rs.getInt("cod_cliente"));
				           cliente.setNome_cliente(rs.getString("nome_cliente"));
				           cliente.setCpf_cnpj_cliente(rs.getString("cpf_cnpj_cliente"));
				           cliente.setFone_cliente(rs.getString("fone_cliente"));
				           cliente.setSexo_cliente(rs.getString("sexo_cliente"));
				           cliente.setLogradouro_cliente(rs.getString("logradouro_cliente"));
				           cliente.setCidade_cliente(rs.getString("cidade_cliente"));
				           cliente.setEstado_cliente(rs.getString("estado_cliente"));
				           cliente.setCompl_cliente(rs.getString("compl_cliente"));
					       Calendar data = Calendar.getInstance();
					       data.setTime(rs.getDate("dta_cad_cliente"));
					       cliente.setDta_cad_cliente(data);
				           cliente.setEmail_cliente(rs.getString("email_cliente"));
				           cliente.setRg_cliente(rs.getString("rg_cliente"));
				         
				         // adicionando o objeto à lista
				         lista.add(cliente);
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
