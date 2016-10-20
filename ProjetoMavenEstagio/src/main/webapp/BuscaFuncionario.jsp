<%-- 
    Document   : BuscaFuncionario
    Created on : 19/10/2016, 23:38:17
    Author     : joao vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    </head>
     <body>
<header>
     <jsp:include page="cabecalho.jsp" />
	</header>
      <jsp:useBean id="dao" class="br.com.req.dao.FuncionarioDAO"></jsp:useBean>
         
            <table class="table  table-bordered">
                <tr>
	   <th>Nome</th>
	   <th>Cpf</th>
           <th>Cargo</th>
	   <th>Telefone</th>
           <th>Sexo</th>
	   <th>Email</th>
	   <th>Endereco</th>
           <th>Cidade</th>
           <th>UF</th>
           <th>Complemento</th>
	   <th>Cadastrado</th>
	   <th></th>
	   <th></th>
	   
	   
	 </tr>
                
                    <c:forEach var="func"   items="${dao.consulta()}">  
         <tr id="${func.cod_funcionario}">
     
   
	     <td id="nome_funcionario" >${func.nome_funcionario}</td>
	     <td id="cpf_cnpj_funcionario" >${func.cpf_cnpj_funcionario}</td>
             <td id="cargo_funcionario">${func.cargo_funcionario}</td>
	     <td id="fone_funcionario" >${func.fone_funcionario}</td>
             <td id="sexo_funcionario">${func.sexo_funcionario} </td>
	     <td id="email_funcionario">${func.email_funcionario}</td>
	     <td id="logradouro_funcionario">${func.logradouro_funcionario}</td>
             <td id="cidade_funcionario">${func.cidade_funcionario}</td>
             <td id="estado_funcionario">${func.estado_funcionario}</td>
             <td id="compl_funcionario">${func.compl_funcionario}</td>
             <td id="dta_cad_funcionario"><fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${func.dta_cad_funcionario.time}" /></td>
         
	     <td><a href="ServletFuncionario?salve=excluir&nome_funcionario=${func.nome_funcionario}&var=funcionarios"><i class="icon-trash"></i></a></td>

             <td><a href="EditarFuncionario.jsp?nome=${func.nome_funcionario}&dta&cpf=${func.cpf_cnpj_funcionario}&cargo=${func.cargo_funcionario}&fone=${func.fone_funcionario}&sexo=${func.sexo_funcionario}&end=${func.logradouro_funcionario}&email=${func.email_funcionario}&cidade=${func.cidade_funcionario}&uf=${func.estado_funcionario}&compl=${func.compl_funcionario}"><i class="icon-pencil"></i></a></td>
              
	     </tr>
	
      
        </c:forEach>     
                
                
               
            </table>
          
        </div>
             <footer>
				
		     <jsp:include page="footer.jsp" />
	</footer>
    </body>
</html>

