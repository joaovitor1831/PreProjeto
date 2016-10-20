<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import=" br.com.req.dao.ClienteDAO" %>
    

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
		
	
<jsp:useBean id="dao" class="br.com.req.dao.ClienteDAO"></jsp:useBean>
<form action="Servlet" class="form-horizontal" method="get">
<fieldset>
 <legend><p>Cadastro de Clientes</p></legend>
<table class="table table-striped">
  <tr>
    <td>Nome: </td><td> <input type="text" name="nome_cliente" id="cadcli"  /></td>
    <td>Sexo: </td>
    <td> <select name="sexo_cliente" id="sexocli"  >
            
             <option class="comb">M </option>
             <option class="comb">F </option>      
         </select> 
    </td>
  </tr>
  <tr>
    <td>CPF_CNPJ: </td><td><input type="text" name="cpf_cnpj_cliente" id="cpfcli"     /></td>
    <td>Telefone: </td><td> <input type="text" name="fone_cliente"  id="fonecli" /></td>
  
  </tr>
 
        
        
  <tr>
  <td>Endereço:</td><td><input type="text" name="logradouro_cliente" id="endcli"/></td>
  <td>Complemento:</td><td><input type="text" name="compl_cliente" i="compcli"/></td>
  
  </tr>
 
  <tr>
     <td>UF:</td>
     <td> <select name="estado_cliente" id="estadocli" >
            <option class="comb">TO</option>
            <option class="comb">GO </option>
            <option class="comb">MG </option> 
           </select>
     </td>
       <td>Cidade:</td><td> <input type="text" name="cidade_cliente" id="cidcli" /></td>
  
  </tr>
   <tr>
    <td>Email:</td><td> <input type="email" name="email_cliente" placeholder="email@email.com" id="emailcli"/></td>
    <td>RG:</td><td> <input type="text" name="rg_cliente" id="rgcli" /></td>
   
   </tr>
   <tr>
      <td>Cadastrado em:</td><td><tags:campoData id="dta_cad_cliente" /></td>
   
   </tr>
   
   <tr>
      <td colspan="2"><input type="submit" value="enviar" name="salve"  class="btn btn-success"  class="alert alert-success"/></td>
      <td ><a href="buscaCliente.jsp" class="btn"><i class="icon-search"></i>Buscar</a> <hr/></td>
      <td ><input type="submit" value="Excluir" name="salve" class="btn btn-danger" /></td>
      <input type="hidden" name="var" value="clientes"/> 
   </tr>
   
   
  
</table>
</fieldset>


</form>
    <footer>
				
		     <jsp:include page="footer.jsp" />
	</footer>
	 

    </body>
</html>
