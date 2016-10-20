/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import br.com.req.bean.Engenheiro;
import br.com.req.dao.EngenheiroDAO;
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
 * @author joao vitor
 */
@WebServlet(name = "ServletEngenheiro", urlPatterns = {"/ServletEngenheiro"})
public class ServletEngenheiro extends HttpServlet {

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
       

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    

            {
        	 PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String var=request.getParameter("var");
         //verificando se a requisição é para tabela clientes
           if(var.equals("engenheiros")){
		 // buscando os par�metros no request
		 String salve=request.getParameter("salve");
		 String nome_engenheiro = request.getParameter("nome_engenheiro");
                 EngenheiroDAO dao=new EngenheiroDAO();
                 String cpf_cnpj_engenheiro=request.getParameter("cpf_cnpj_engenheiro");
		 String fone_engenheiro=request.getParameter("fone_engenheiro");
		 String sexo_engenheiro = request.getParameter("sexo_engenheiro");
	         String logradouro_engenheiro =request.getParameter("logradouro_engenheiro");
		 String cidade_engenheiro = request.getParameter("cidade_engenheiro");
		 String estado_engenheiro = request.getParameter("estado_engenheiro");
		 String compl_engenheiro =request.getParameter("compl_engenheiro");
		 String  dta_cad_engenheiro = request.getParameter("dta_cad_engenheiro");		
		 String email_engenheiro = request.getParameter("email_engenheiro");
		 String rg_engenheiro =request.getParameter("rg_engenheiro");
	
	        if(salve.equals("enviar") ){         
      
		 // monta um objeto contato
		Engenheiro engenheiro=new Engenheiro();
		engenheiro.setNome_engenheiro(nome_engenheiro);
		engenheiro.setCpf_cnpj_engenheiro(cpf_cnpj_engenheiro);
		engenheiro.setFone_engenheiro(fone_engenheiro);
		engenheiro.setSexo_engenheiro(sexo_engenheiro);
		engenheiro.setLogradouro_engenheiro(logradouro_engenheiro);
		engenheiro.setCidade_engenheiro(cidade_engenheiro);
		engenheiro.setEstado_engenheiro(estado_engenheiro);
		engenheiro.setCompl_engenheiro(compl_engenheiro);
		 // fazendo a convers�o da data
		 Calendar cadastro = null;
		 try {
			
		 java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_engenheiro);
		 cadastro = Calendar.getInstance();
		 cadastro.setTime(date);
                 
		 } catch (ParseException e) {
		 out.println("Erro de convers�o da data");
		 return; //para a execu��o do m�todo
		 }
                engenheiro.setDta_cad_engenheiro(cadastro);
		engenheiro.setEmail_engenheiro(email_engenheiro);
		engenheiro.setRg_engenheiro(rg_engenheiro);
		 PreparedStatement stmt = null;
                String sql2="SELECT engenheiro.cod_engenheiro FROM engenheiro WHERE engenheiro.nome_engenheiro =  '"+nome_engenheiro+"' and engenheiro.cpf_cnpj_engenheiro= '"+cpf_cnpj_engenheiro+"'";

			
                     try {
                         cod1=dao.verifica(sql2);
                         if(cod1==0)
            		    dao.adiciona(engenheiro);
                     } catch (SQLException ex) {
                         Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("Engenheiro.jsp");
					rd.forward(request, response);
                         
				
				}
                    if(salve.equals("excluir")){
                        dao.remove(nome_engenheiro); 
                         out.println("<html>");
			 out.println("<body>");
			 out.println("Contato excluido com sucesso" + salve+ " novamente");
			 out.println("</body>");
			 out.println("</html>");
                                        RequestDispatcher rd;
					rd = request.getRequestDispatcher("BuscaEngenheiro.jsp");
					rd.forward(request, response);
                          }else{
                                                            // monta um objeto contato
                                        Engenheiro engenheiro=new Engenheiro();
                                        engenheiro.setNome_engenheiro(nome_engenheiro);
                                        engenheiro.setCpf_cnpj_engenheiro(cpf_cnpj_engenheiro);
                                        engenheiro.setFone_engenheiro(fone_engenheiro);
                                        engenheiro.setSexo_engenheiro(sexo_engenheiro);
                                        engenheiro.setLogradouro_engenheiro(logradouro_engenheiro);
                                        engenheiro.setCidade_engenheiro(cidade_engenheiro);
                                        engenheiro.setEstado_engenheiro(estado_engenheiro);
                                        engenheiro.setCompl_engenheiro(compl_engenheiro);
                                         // fazendo a convers�o da data
                                         Calendar cadastro = null;
                                         try {

                                         java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_engenheiro);
                                         cadastro = Calendar.getInstance();
                                         cadastro.setTime(date);
                                         } catch (ParseException e) {
                                         out.println("Erro de conversao da data");
                                         return; //para a execu��o do m�todo
                                         }
                                        engenheiro.setDta_cad_engenheiro(cadastro);
                                        engenheiro.setEmail_engenheiro(email_engenheiro);
                                        engenheiro.setRg_engenheiro(rg_engenheiro);
                                         PreparedStatement stmt = null;
                                         dao.Alterar(engenheiro);
			

                                        RequestDispatcher rd;
					rd = request.getRequestDispatcher("Engenheiro.jsp");
					rd.forward(request, response);
                                          
            }
           }
    }
   
}
