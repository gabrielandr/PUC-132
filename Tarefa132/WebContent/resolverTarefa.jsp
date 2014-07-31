<%@page import="rtp.db.UtilsDB"%>
<%@ page import="java.util.*,rtp.model.Tarefa"%>
<%@page import="rtp.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Tarefas 132</title>

<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!-- javascript at the bottom for fast page loading -->
<link rel="stylesheet" type="text/css" href="css/jquery.validity.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="js/jquery.validity.js"></script>
<script type="text/javascript">
	jQuery(function() {
		$("#dtPrazo").mask("99/99/9999");
		$("#dataConclusao").mask("99/99/9999");
		$("form").validity(
				function() {
					$("#dataConclusao").require(
							"O campo Título é obrigatório para criação");
					$("#descSolucao").require(
							"O campo Prazo é obrigatório para criação");
				});

	});
</script>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- <link rel="javascript" type="text/css" href="css/style.css" /> -->
<script src="<c:url value="/js/mascaras.js" />"></script>
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
	<div id="main">
		<jsp:include page="headerMenu.jsp" />

		<div id="site_content">
			<div id="sidebar_container">
				<div class="sidebar">
					<!--           <h3>Latest News</h3> -->
					<!--           <h4>New Website Launched</h4> -->
					<!--           <h5>January 1st, 2012</h5> -->
					<!--           <p>2012 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p> -->
					<!--           <h4>20% Discount</h4> -->
					<!--           <h5>March 1st, 2012</h5> -->
					<!--           <p>We are offering a 20% discount to all new customers.<br /><a href="#">Read more</a></p> -->
				</div>
			</div>
			<div class="content">
				<form name="formResolveTarefa" method="post"
					action="ResolverTarefa.do">
					<%
					    Tarefa tarefa = (Tarefa) request.getAttribute("tarefa");
					    String urgenteSelected = (String) request.getAttribute("urgente");
					%>

					<input type="hidden" name="id" value="<%=tarefa.getId()%>" />
					<table>
						<h2>Resolver tarefa:</h2>
						<tr>
							<td>Título:</td>
							<td><input type="text" id="titulo" name="titulo"
								value="<%out.print(tarefa.getTitulo());%>" maxlength="100"
								size="40" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>Prazo:</td>
							<td><input type="text" id="dtPrazo" name="dtPrazo"
								value="<%out.print(tarefa.getPrazo());%>" maxlength="10"
								size="15" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>Detalhes:</td>
							<td><textarea name="detalhes" cols="85" rows="4" disabled="disabled"><%=tarefa.getDetalhes()%></textarea>
							</td>
						</tr>
						<tr>
							<td>Responsável:</td>
							<td><select name="responsavel" size="1" disabled="disabled">
									<option value="">Selecione</option>
									<option value="Chaves"
										<%=tarefa.getResponsavel().equalsIgnoreCase("Chaves") ? "selected"
		    : ""%>>Chaves</option>
									<option value="Quico"
										<%=tarefa.getResponsavel().equalsIgnoreCase("Quico") ? "selected"
		    : ""%>>Quico</option>
									<option value="Chiquinha"
										<%=tarefa.getResponsavel().equalsIgnoreCase("Chiquinha") ? "selected"
		    : ""%>>Chiquinha</option>
							</select></td>
						</tr>
						<tr>
							<td>Urgente:</td>
							<td><input type="checkbox" name="urgente" <%=urgenteSelected%>
								maxlength="10" size="10" disabled="disabled"/></td>
						</tr>

						<tr>
							<td>Data Conclusão:</td>
							<td><input type="text" id="dataConclusao" name="dtConclusao"
								value="" maxlength="10" size="40" require /></td>
						</tr>
						<tr>
							<td>Descrição da Solução:</td>
							<td><textarea id="descSolucao" name="descSolucao" cols="85"
									rows="4" require><%=tarefa.getDescSolucao() == null ? "" : tarefa
		    .getDescSolucao()%></textarea></td>
						</tr>
					</table>
					<center>
						<input type="SUBMIT" value="OK">
					</center>
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
	<p>&nbsp;</p>

</body>
</html>
