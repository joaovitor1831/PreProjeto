/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import br.com.req.bean.Cliente;
import br.com.req.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Israel_Analista
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int cod1=0;
	private static Connection connection;
       
   
		 
   
		
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	 PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String var=request.getParameter("var");
         //verificando se a requisição é para tabela clientes
           if(var.equals("clientes")){
		 // buscando os par�metros no request
		 String salve=request.getParameter("salve");
		 String nome_cliente = request.getParameter("nome_cliente");
                 ClienteDAO dao=new ClienteDAO();
                 String cpf_cnpj_cliente=request.getParameter("cpf_cnpj_cliente");
		 String fone_cliente=request.getParameter("fone_cliente");
		 String sexo_cliente= request.getParameter("sexo_cliente");
	         String logradouro_cliente=request.getParameter("logradouro_cliente");
		 String cidade_cliente = request.getParameter("cidade_cliente");
		 String estado_cliente = request.getParameter("estado_cliente");
		 String compl_cliente=request.getParameter("compl_cliente");
		 String  dta_cad_cliente = request.getParameter("dta_cad_cliente");		
		 String email_cliente= request.getParameter("email_cliente");
		 String rg_cliente=request.getParameter("rg_cliente");
	
	        if(salve.equals("enviar") ){         
      
		 // monta um objeto contato
		Cliente cliente=new Cliente();
		cliente.setNome_cliente(nome_cliente);
		cliente.setCpf_cnpj_cliente(cpf_cnpj_cliente);
		cliente.setFone_cliente(fone_cliente);
		cliente.setSexo_cliente(sexo_cliente);
		cliente.setLogradouro_cliente(logradouro_cliente);
		cliente.setCidade_cliente(cidade_cliente);
		cliente.setEstado_cliente(estado_cliente);
		cliente.setCompl_cliente(compl_cliente);
		 // fazendo a convers�o da data
		 Calendar cadastro = null;
		 try {
			
		 java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_cliente);
		 cadastro = Calendar.getInstance();
		 cadastro.setTime(date);
                 
		 } catch (ParseException e) {
		 out.println("Erro de convers�o da data");
		 return; //para a execu��o do m�todo
		 }
                cliente.setDta_cad_cliente(cadastro);
		cliente.setEmail_cliente(email_cliente);
		cliente.setRg_cliente(rg_cliente);
		 PreparedStatement stmt = null;
                String sql2="SELECT cliente.cod_cliente FROM cliente WHERE cliente.nome_cliente =  '"+nome_cliente+"' and cliente.cpf_cnpj_cliente= '"+cpf_cnpj_cliente+"'";

			
                     try {
                         cod1=dao.verifica(sql2);
                         if(cod1==0)
            		    dao.adiciona(cliente);
                     } catch (SQLException ex) {
                         Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("Cliente.jsp");
					rd.forward(request, response);
                         
				
				}
                    if(salve.equals("excluir")){
                        dao.remove(nome_cliente); 
                        out.println("<html>");
			 out.println("<body>");
			 out.println("Contato excluido com sucesso" + salve+ " novamente");
			 out.println("</body>");
			 out.println("</html>");
                                        RequestDispatcher rd;
					rd = request.getRequestDispatcher("buscaCliente.jsp");
					rd.forward(request, response);
                          }else{
                                                            // monta um objeto contato
                                        Cliente cliente=new Cliente();
                                        cliente.setNome_cliente(nome_cliente);
                                        cliente.setCpf_cnpj_cliente(cpf_cnpj_cliente);
                                        cliente.setFone_cliente(fone_cliente);
                                        cliente.setSexo_cliente(sexo_cliente);
                                        cliente.setLogradouro_cliente(logradouro_cliente);
                                        cliente.setCidade_cliente(cidade_cliente);
                                        cliente.setEstado_cliente(estado_cliente);
                                        cliente.setCompl_cliente(compl_cliente);
                                         // fazendo a convers�o da data
                                         Calendar cadastro = null;
                                         try {

                                         java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_cliente);
                                         cadastro = Calendar.getInstance();
                                         cadastro.setTime(date);
                                         } catch (ParseException e) {
                                         out.println("Erro de conversao da data");
                                         return; //para a execu��o do m�todo
                                         }
                                        cliente.setDta_cad_cliente(cadastro);
                                        cliente.setEmail_cliente(email_cliente);
                                        cliente.setRg_cliente(rg_cliente);
                                         //PreparedStatement stmt = ;
                                         dao.Alterar(cliente);
			

                                        RequestDispatcher rd;
					rd = request.getRequestDispatcher("Cliente.jsp");
					rd.forward(request, response);
                                          
            }
           }
    }
 }

  


