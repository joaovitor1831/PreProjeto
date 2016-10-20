
<%@ attribute name="id" required="true" %>
<input type="text" id="${id}" name="${id}" />
<script type="text/javascript">



$("#${id}").datepicker({
	       

	dateFormat: 'dd/mm/yy',
	changeMonth: true,
    changeYear: true,
     buttonImage: "img/cal.png",
    buttonImageOnly: true,
	
	        dateFormat: 'dd/mm/yy',
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	});
</script>
