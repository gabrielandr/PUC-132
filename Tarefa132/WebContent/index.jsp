<%@page import="rtp.db.UtilsDB"%>
<%@page import="rtp.db.DBConnection"%>
<%@ page import="java.util.*,rtp.model.Tarefa"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Tarefas 132</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link href="./css/tarefa.css" rel="stylesheet" type="text/css">
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>

<!-- DataTables -->
<script type="text/javascript" src="js/jquery.dataTables.js"></script>

</head>

<body>
<%
	String status = request.getParameter("status"); 
%>
	<div id="main">
		<jsp:include page="headerMenu.jsp">
			<jsp:param name="status" value="<%=status%>" />
			<jsp:param name="menuSelecionado" value="home" />
		</jsp:include>
		<%-- 				<%@ include file="headerMenu.jsp"%> --%>
		
		<div id="site_content">
			<div>
				<table id="tabelaTarefas" class="display">
					<thead>
						<tr id="trLabels">
						
							<td id="tdLabedsals">ID</td>
							<td id="tdLabels">Titulo</td>
							<td id="tdLabels">Prazo de execução</td>
							<td id="tdLabels">Prazo de execução</td>
							
							<td id="tdLabels">Detalhes</td>
							<td id="tdLabels">Responsável</td>
							<td id="tdLabels">Urgente</td>
							<td id="tdLabels">Status</td>
							<td id="tdLabels">Data de conclusão</td>
							<td id="tdLabels">Descrição da Solução</td>
							<td id="tdLabels"></td>
						</tr>
					</thead>
					<tbody>
						<%
						    DBConnection dbConn = DBConnection.getInstance();
							List<Tarefa> tarefas;
							
							if(status != null){
								tarefas = dbConn.retornaTarefasPorStatus(status);
							} else {
								tarefas = dbConn.selectAll();
							}
							for(Tarefa tarefa : tarefas){
						%>
						<tr>
							<td>
								<%
								    out.print(tarefa.getId());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.getTitulo());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.getPrazo());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.getDetalhes());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.getResponsavel());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.getUrgente());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.getStatus());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.retornaDataConclusao());
								%>
							</td>
							<td>
								<%
								    out.print(tarefa.retornaDescSolucao());
								%>
							</td>
							<td>
								<%
								    if("Aberta".equalsIgnoreCase(tarefa.getStatus())) {
								%> <a
								href='./resolverTarefa?id=<%out.print(tarefa.getId());%>'>
									Resolver </a> 
							<%
								 }
							 %>
							</td>


							<%
							    out.print("</tr>");
																												    }
							%>
						
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
	<p>&nbsp;</p>
	<!-- javascript at the bottom for fast page loading -->
	<script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
	<script type="text/javascript" src="js/jquery.sooperfish.js"></script>
	<script type="text/javascript" src="js/jquery.kwicks-1.5.1.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#tabelaTarefas')
									.DataTable(
											{
												"oLanguage" : {
													"sEmptyTable" : "Nenhum registro encontrado na tabela",
													"sInfo" : "Mostrar _START_ até _END_ do _TOTAL_ registros",
													"sInfoEmpty" : "Mostrar 0 até 0 de 0 Registros",
													"sInfoFiltered" : "(Filtrar de _MAX_ total registros)",
													"sInfoPostFix" : "",
													"sInfoThousands" : ".",
													"sLengthMenu" : "Mostrar _MENU_ registros por pagina",
													"sLoadingRecords" : "Carregando...",
													"sProcessing" : "Processando...",
													"sZeroRecords" : "Nenhum registro encontrado",
													"sSearch" : "Pesquisar",
													"oPaginate" : {
														"sNext" : "Proximo",
														"sPrevious" : "Anterior",
														"sFirst" : "Primeiro",
														"sLast" : "Ultimo"
													},
													"oAria" : {
														"sSortAscending" : ": Ordenar colunas de forma ascendente",
														"sSortDescending" : ": Ordenar colunas de forma descendente"
													}
												}
											});
						});
	</script>
	<%
	    UtilsDB.inicializaBD();
	    // 	    UtilsDB.chamaServlet();
	%>

</body>
</html>
