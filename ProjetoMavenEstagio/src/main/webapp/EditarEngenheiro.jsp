<%-- 
    Document   : EditarEngenheiro
    Created on : 17/10/2016, 00:37:27
    Author     : joao vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import=" br.com.req.dao.EngenheiroDAO" %>
    

<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" >
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
    </head>
   <body>
    
    <header>
     <jsp:include page="cabecalho.jsp" />
	</header>	
		
	
<jsp:useBean id="dao" class="br.com.req.dao.EngenheiroDAO"></jsp:useBean>
<form action="ServletEngenheiro" class="form-horizontal" method="get">
<fieldset>
 <legend><p>Editar Engenheiro</p></legend>
<table class="table table-striped">
  <tr>
      <td>Nome: </td><td> <input type="text" name="nome_engenheiro"  value="${param.nome}"  /></td>
    <td>Sexo: </td>
    <td> <select name="sexo_engenheiro"  value="${param.sexo}">
            
             <option >M </option>
             <option >F </option>      
         </select> 
    </td>
  </tr>
  <tr>
      <td>CPF_CNPJ: </td><td><input type="text" name="cpf_cnpj_engenheiro"  value="${param.cpf}"     /></td>
    <td>Telefone: </td><td> <input type="text" name="fone_engenheiro"   value="${param.fone}" /></td>
  
  </tr>
 
        
        
  <tr>
  <td>Endereço:</td><td><input type="text" name="logradouro_engenheiro"  value="${param.end}"/></td>
  <td>Complemento:</td><td><input type="text" name="compl_engenheiro"  value="${param.compl}"/></td>
  
  </tr>
 
  <tr>
     <td>UF:</td>
     <td> <select name="estado_engenheiro"  value="${param.uf}" >
            <option >TO</option>
            <option >GO </option>
            <option >MG </option> 
           </select>
     </td>
       <td>Cidade:</td><td> <input type="text" name="cidade_engenheiro"  value="${param.cidade}" /></td>
  
  </tr>
   <tr>
       <td>Email:</td><td> <input type="email" name="email_engenheiro" placeholder="email@email.com"  value="${param.email}"/></td>
    <td>RG:</td><td> <input type="text" name="rg_engenheiro"  value="${param.rg}" /></td>
   
   </tr>
   <tr>
      <td>Cadastrado em:</td><td><tags:campoData id="dta_cad_engenheiro"   /></td>
   
   </tr>
   
   <tr>
            <td colspan="2"><input type="submit" value="editar" name="salve"  class="btn btn-primary"  class="alert alert-success"/></td>

      <input type="hidden" name="var" value="engenheiros"/> 
   </tr>
   
   
  
</table>
</fieldset>


</form>
    <footer>
				
		     <jsp:include page="footer.jsp" />
	</footer>
	 

    </body>
</html>

