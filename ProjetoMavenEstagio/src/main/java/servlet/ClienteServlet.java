
package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



import br.com.req.bean.Cliente;

import br.com.req.conexao.ConnectionFactory;
import br.com.req.dao.ClienteDAO;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int cod1=0;
	private static Connection connection;
       
    /**
     * @sprivateee HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
             */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 connection=(Connection) new ConnectionFactory().getConnection();
		 HttpSession session = request.getSession();
			//session.setAttribute(arg0, arg1);
         

		 // buscando os par�metros no request
		 String salve=request.getParameter("salve");
		
		 String nome_cliente = request.getParameter("nome_cliente");
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
		
         
      
		 // monta um objeto contato
		Cliente cliente=new Cliente();
	//	funcionario.setNome_func(nome_func);
		cliente.setNome_cliente(nome_cliente);
		cliente.setCpf_cnpj_cliente(cpf_cnpj_cliente);
		cliente.setFone_cliente(fone_cliente);
		cliente.setSexo_cliente(sexo_cliente);
		cliente.setLogradouro_cliente(logradouro_cliente);
		cliente.setCidade_cliente(cidade_cliente);
		cliente.setEstado_cliente(estado_cliente);
		cliente.setCompl_cliente(compl_cliente);
		 // fazendo a convers�o da data
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd ");
                // java.util.Date date = null;

		 Calendar cadastro = null;
		 try {
			   // date = sdf.parse("2000-11-04 ");

		 java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dta_cad_cliente);
		 cadastro = Calendar.getInstance();
		 cadastro.setTime(date);
		 }catch (ParseException e) {
		 out.println("Erro de convers�o da data");
		 return; //para a execu��o do m�todo
		}
                cliente.setDta_cad_cliente(cadastro);
		cliente.setEmail_cliente(email_cliente);
		cliente.setRg_cliente(rg_cliente);
		 PreparedStatement stmt = null;
		 ClienteDAO dao=new ClienteDAO();
			

			
			 String sql2="SELECT cliente.cod_cliente FROM cliente WHERE cliente.nome_cliente =  '"+nome_cliente+"' and cliente.cpf_cnpj_cliente= '"+cpf_cnpj_cliente+"'";

			
            try {
                cod1=dao.verifica(sql2);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
			  //out.println(cod1);
			  if(salve.equalsIgnoreCase("enviar") && cod1==0){
					dao.adiciona(cliente);
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("buscaCliente.jsp");
					rd.forward(request, response);

					 //response.setContentType("text/html");                           

					// response.sendRedirect("/ProjetoEdmar/Cliente.jsp");          
				
				}else{
					out.println("Já cadastrado");
				}
			 
		
		 
   
		//salva o contato
		
			if(salve.equals("excluir")){
			//dao.adiciona(cliente);
			dao.remove(nome_cliente); 

			 out.println("<html>");
			 out.println("<body>");
			 out.println("Contato " + cliente.getNome_cliente()+ " excluído com sucesso");
			 out.println("</body>");
			 out.println("</html>");
			}}
			
	protected void service(HttpServletRequest request, HttpServletResponse response)
			 throws IOException, ServletException {
			 // busca o writer

			

			 // imprime o nome do contato que foi adicionado

			 }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
