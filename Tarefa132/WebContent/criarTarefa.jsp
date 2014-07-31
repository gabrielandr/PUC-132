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
<link rel="stylesheet" type="text/css" href="css/jquery.validity.css" />
<link href="./css/tarefa.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="js/jquery.validity.js"></script>
<script type="text/javascript">
	$(function() {

		$("#dtPrazo").mask("99/99/9999");
		$("form").validity(
				function() {
					$("#titulo").require(
							"O campo Título é obrigatório para criação");
					$("#dtPrazo").require(
							"O campo Prazo é obrigatório para criação");
					$("#responsavel").require(
							"O campo Responsável é obrigatório para criação");
					$("#urgente").checkboxChecked(
							"O campo Urgente é obrigatório para criação");
				});
	});
</script>
</head>

<body>
	<div id="main">
		<jsp:include page="headerMenu.jsp">
			<jsp:param name="menuSelecionado" value="criar" />
		</jsp:include>

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
				<form id="formTarefa" method="post" action="CriarTarefa.do">
					<table>
						<h2>Criar Tarefa:</h2>
						<tr style="">
							<td>Título:</td>
							<td><input type="text" id="titulo" name="titulo"
								class="error" maxlength="100" size="40" /></td>
						</tr>
						<tr>
							<td>Prazo:</td>
							<td><input type="text" id="dtPrazo" name="dtPrazo"
								class="error" maxlength="10" size="15" /></td>
						</tr>
						<tr>
							<td>Detalhes:</td>
							<td><textarea id="detalhes" name="detalhes" cols="85"
									rows="4"></textarea></td>
						</tr>
						<tr>
							<td>Urgente:</td>
							<td><input type="checkbox" id="urgente" name="urgente"
								maxlength="10" size="10" /></td>
						</tr>
						<tr>
							<td>Responsável:</td>
							<td><select id="responsavel" name="responsavel" size="1">
									<option value="">Selecione</option>
									<option value="Chaves">Chaves</option>
									<option value="Quico">Quico</option>
									<option value="Chiquinha">Chiquinha</option>
							</select></td>
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
