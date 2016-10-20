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
      <jsp:useBean id="dao" class="br.com.req.dao.ClienteDAO"></jsp:useBean>
         
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
                
                    <c:forEach var="cli"   items="${dao.consulta()}">  
         <tr id="${cli.cod_cliente}">
     
   
	     <td id="nome_cliente" >${cli.nome_cliente}</td>
	     <td id="cpf_cnpj_cliente" >${cli.cpf_cnpj_cliente}</td>
             <td id="rg_cliente">${cli.rg_cliente}</td>
	     <td id="fone_cliente" >${cli.fone_cliente}</td>
             <td id="sexo_cliente">${cli.sexo_cliente} </td>
	     <td id="email_cliente">${cli.email_cliente}</td>
	     <td id="logradouro_cliente">${cli.logradouro_cliente}</td>
             <td id="cidade_cliente">${cli.cidade_cliente}</td>
             <td id="estado_cliente">${cli.estado_cliente}</td>
             <td id="compl_cliente">${cli.compl_cliente}</td>
             <td id="dta_cad_cliente"><fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${cli.dta_cad_cliente.time}" /></td>
         
	     <td><a href="Servlet?salve=excluir&nome_cliente=${cli.nome_cliente}&var=clientes"><i class="icon-trash"></i></a></td>

             <td><a href="EditarCliente.jsp?nome=${cli.nome_cliente}&dta&cpf=${cli.cpf_cnpj_cliente}&rg=${cli.rg_cliente}&fone=${cli.fone_cliente}&sexo=${cli.sexo_cliente}&end=${cli.logradouro_cliente}&email=${cli.email_cliente}&cidade=${cli.cidade_cliente}&uf=${cli.estado_cliente}&compl=${cli.compl_cliente}"><i class="icon-pencil"></i></a></td>
              
	     </tr>
	
      
        </c:forEach>     
                
                
               
            </table>
          
        </div>
             <footer>
				
		     <jsp:include page="footer.jsp" />
	</footer>
    </body>
</html>
