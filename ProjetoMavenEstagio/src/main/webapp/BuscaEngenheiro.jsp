<%-- 
    Document   : BuscaEngenheiro
    Created on : 16/10/2016, 23:46:55
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
      <jsp:useBean id="dao" class="br.com.req.dao.EngenheiroDAO"></jsp:useBean>
         
            <table class="table  table-bordered">
                <tr>
	   <th>Nome</th>
	   <th>Cpf</th>
           <th>RG</th>
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
                
                    <c:forEach var="eng"   items="${dao.consulta()}">  
         <tr id="${eng.cod_engenheiro}">
     
   
	     <td id="nome_engenheiro" >${eng.nome_engenheiro}</td>
	     <td id="cpf_cnpj_engenheiro" >${eng.cpf_cnpj_engenheiro}</td>
             <td id="rg_engenheiro">${eng.rg_engenheiro}</td>
	     <td id="fone_engenheiro" >${eng.fone_engenheiro}</td>
             <td id="sexo_engenheiro">${eng.sexo_engenheiro} </td>
	     <td id="email_engenheiro">${eng.email_engenheiro}</td>
	     <td id="logradouro_engenheiro">${eng.logradouro_engenheiro}</td>
             <td id="cidade_engenheiro">${eng.cidade_engenheiro}</td>
             <td id="estado_engenheiro">${eng.estado_engenheiro}</td>
             <td id="compl_engenheiro">${eng.compl_engenheiro}</td>
             <td id="dta_cad_engenheiro"><fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${eng.dta_cad_engenheiro.time}" /></td>
         
	     <td><a href="ServletEngenheiro?salve=excluir&nome_engenheiro=${eng.nome_engenheiro}&var=engenheiros"><i class="icon-trash"></i></a></td>

             <td><a href="EditarEngenheiro.jsp?nome=${eng.nome_engenheiro}&dta&cpf=${eng.cpf_cnpj_engenheiro}&rg=${eng.rg_engenheiro}&fone=${eng.fone_engenheiro}&sexo=${eng.sexo_engenheiro}&end=${engenheiro.logradouro_engenheiro}&email=${eng.email_engenheiro}&cidade=${eng.cidade_engenheiro}&uf=${eng.estado_engenheiro}&compl=${eng.compl_engenheiro}"><i class="icon-pencil"></i></a></td>
              
	     </tr>
	
      
        </c:forEach>     
                
                
               
            </table>
          
        </div>
             <footer>
				
		     <jsp:include page="footer.jsp" />
	</footer>
    </body>
</html>
