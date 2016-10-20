/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import br.com.req.bean.Funcionario;
import br.com.req.dao.FuncionarioDAO;
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
@WebServlet(name = "ServletFuncionario", urlPatterns = {"/ServletFuncionario"})
public class ServletFuncionario extends HttpServlet {

    private int cod1=0;
	private static Connection connection;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletFuncionario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFuncionario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

             PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String var=request.getParameter("var");
         //verificando se a requisição é para tabela clientes
           if(var.equals("funcionarios")){
		 // buscando os par�metros no request
		 String salve=request.getParameter("salve");
		 String nome_funcionario = request.getParameter("nome_funcionario");
                 FuncionarioDAO dao=new FuncionarioDAO();
                 String cpf_cnpj_funcionario=request.getParameter("cpf_cnpj_funcionario");
		 String fone_funcionario=request.getParameter("fone_funcionario");
		 String sexo_funcionario = request.getParameter("sexo_funcionario");
	         String logradouro_funcionario =request.getParameter("logradouro_funcionario");
		 String cidade_funcionario = request.getParameter("cidade_funcionario");
		 String estado_funcionario = request.getParameter("estado_funcionario");
		 String compl_funcionario =request.getParameter("compl_funcionario");
		 String  dta_cad_funcionario = request.getParameter("dta_cad_funcionario");		
		 String email_funcionario = request.getParameter("email_funcionario");
		 String cargo_funcionario =request.getParameter("cargo_funcionario");
	
	        if(salve.equals("enviar") ){         
      
		 // monta um objeto contato
		Funcionario funcionario=new Funcionario();
		funcionario.setNome_funcionario(nome_funcionario);
		funcionario.setCpf_cnpj_funcionario(cpf_cnpj_funcionario);
		funcionario.setFone_funcionario(fone_funcionario);
		funcionario.setSexo_funcionario(sexo_funcionario);
		funcionario.setLogradouro_funcionario(logradouro_funcionario);
		funcionario.setCidade_funcionario(cidade_funcionario);
		funcionario.setEstado_funcionario(estado_funcionario);
		funcionario.setCompl_funcionario(compl_funcionario);
		 // fazendo a convers�o da data
		 Calendar cadastro = null;
		 try {
			
		 java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_funcionario);
		 cadastro = Calendar.getInstance();
		 cadastro.setTime(date);
                 
		 } catch (ParseException e) {
		 out.println("Erro de convers�o da data");
		 return; //para a execu��o do m�todo
		 }
                funcionario.setDta_cad_funcionario(cadastro);
		funcionario.setEmail_funcionario(email_funcionario);
		funcionario.setCargo_funcionario(cargo_funcionario);
		 PreparedStatement stmt = null;
                String sql2="SELECT funcionario.cod_funcionario FROM funcionario WHERE funcionario.nome_funcionario =  '"+nome_funcionario+"' and funcionario.cpf_cnpj_funcionario= '"+cpf_cnpj_funcionario+"'";

			
                     try {
                         cod1=dao.verifica(sql2);
                         if(cod1==0)
            		    dao.adiciona(funcionario);
                     } catch (SQLException ex) {
                         Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("Funcionario.jsp");
					rd.forward(request, response);
                         
				
				}
                    if(salve.equals("excluir")){
                        dao.remove(nome_funcionario); 
                         out.println("<html>");
			 out.println("<body>");
			 out.println("Contato excluido com sucesso" + salve+ " novamente");
			 out.println("</body>");
			 out.println("</html>");
                                        RequestDispatcher rd;
					rd = request.getRequestDispatcher("BuscaFuncionario.jsp");
					rd.forward(request, response);
                          }else{
                                                            // monta um objeto contato
                                        Funcionario funcionario=new Funcionario();
                                        funcionario.setNome_funcionario(nome_funcionario);
                                        funcionario.setCpf_cnpj_funcionario(cpf_cnpj_funcionario);
                                        funcionario.setFone_funcionario(fone_funcionario);
                                        funcionario.setSexo_funcionario(sexo_funcionario);
                                        funcionario.setLogradouro_funcionario(logradouro_funcionario);
                                        funcionario.setCidade_funcionario(cidade_funcionario);
                                        funcionario.setEstado_funcionario(estado_funcionario);
                                        funcionario.setCompl_funcionario(compl_funcionario);
                                         // fazendo a convers�o da data
                                         Calendar cadastro = null;
                                         try {

                                         java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_funcionario);
                                         cadastro = Calendar.getInstance();
                                         cadastro.setTime(date);
                                         } catch (ParseException e) {
                                         out.println("Erro de conversao da data");
                                         return; //para a execu��o do m�todo
                                         }
                                        funcionario.setDta_cad_funcionario(cadastro);
                                        funcionario.setEmail_funcionario(email_funcionario);
                                        funcionario.setCargo_funcionario(cargo_funcionario);
                                        PreparedStatement stmt = null;
                                        dao.Alterar(funcionario);
			

                                        RequestDispatcher rd;
					rd = request.getRequestDispatcher("Funcionario.jsp");
					rd.forward(request, response);
                                          
            }
           }
    }
   
    }


