<%-- 
    Document   : Funcionario
    Created on : 19/10/2016, 23:28:11
    Author     : joao vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import=" br.com.req.dao.FuncionarioDAO" %>
    

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
		
	
<jsp:useBean id="dao" class="br.com.req.dao.FuncionarioDAO"></jsp:useBean>
<form action="ServletFuncionario" class="form-horizontal" method="Get">
<fieldset>
 <legend><p>Cadastro de Funcionario</p></legend>
<table class="table table-striped">
  <tr>
    <td>Nome: </td><td> <input type="text" name="nome_funcionario" id="cadfunc"  /></td>
    <td>Sexo: </td>
    <td> <select name="sexo_funcionario" id="sexofunc"  >
            
             <option class="comb">M </option>
             <option class="comb">F </option>      
         </select> 
    </td>
  </tr>
  <tr>
    <td>CPF_CNPJ: </td><td><input type="text" name="cpf_cnpj_funcionario" id="cpffunc"     /></td>
    <td>Telefone: </td><td> <input type="text" name="fone_funcionario"  id="fonefunc" /></td>
  
  </tr>
 
        
        
  <tr>
  <td>Endereço:</td><td><input type="text" name="logradouro_funcionario" id="endfunc"/></td>
  <td>Complemento:</td><td><input type="text" name="compl_funcionario" id="compfunc"/></td>
  
  </tr>
 
  <tr>
     <td>UF:</td>
     <td> <select name="estado_funcionario" id="estadofunc" >
            <option class="comb">TO</option>
            <option class="comb">GO </option>
            <option class="comb">MG </option> 
           </select>
     </td>
       <td>Cidade:</td><td> <input type="text" name="cidade_funcionario" id="cidfunc" /></td>
  
  </tr>
   <tr>
    <td>Email:</td><td> <input type="email" name="email_funcionario" placeholder="email@email.com" id="emailfunc"/></td>
    <td>Cargo:</td><td> <input type="text" name="cargo_funcionario" id="cargofunc" /></td>
   
   </tr>
   <tr>
      <td>Cadastrado em:</td><td><tags:campoData id="dta_cad_funcionario" /></td>
     
   </tr>
   
   <tr>
      <td colspan="2"><input type="submit" value="enviar" name="salve"  class="btn btn-success"  class="alert alert-success"/></td>
      <td ><a href="BuscaFuncionario.jsp" class="btn"><i class="icon-search"></i>Buscar</a> <hr/></td>
       <td ><input type="submit" value="Excluir" name="salve" class="btn btn-danger" /></td>
      <input type="hidden" name="var" value="funcionarios"/> 
   </tr>
   
   
  
</table>
</fieldset>


</form>
    <footer>
				
		     <jsp:include page="footer.jsp" />
	</footer>
	 

    </body>
</html>
