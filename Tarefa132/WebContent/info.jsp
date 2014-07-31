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
	
</script>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- <link rel="javascript" type="text/css" href="css/style.css" /> -->
<script src="<c:url value="/js/mascaras.js" />"></script>
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
	<div id="main">
		<jsp:include page="headerMenu.jsp">
			<jsp:param name="menuSelecionado" value="info" />
		</jsp:include>
		<div id="site_content">
			<div id="sidebar_container">
				<div class="sidebar"></div>
			</div>
			<div class="content">
				<h3>Algumas informações sobre o trabalho.</h3>
				<p>Os menus Home, e Criar Tarefa,
					não tem muito oque falar, são auto-explicativos.</p>
				<p>Preferi fazer a listagem direto no Index, mais limpo e menos telas.
				</p>
				<p>É possível filtrar somente por tarefas Abertas ou somente por Concluídas através dos menus. Ou filtrar direto pela listagem no Home
				</p>
				<p>O menu Session, lista as tarefas que foram alteradas ou
					criadas na sessão(sem login, somente enquanto a aplicação está
					rodando), ou seja, toda vez que uma tarefa for criada ou
					editada(Concluida),a tarefa é salva em uma variável de sessão, e
					mostrada na tela através do menu Session.</p>
				<p>
					As validações foram feitas com um plugin Jquery chamado Validity
					que voce pode achar no link <a
						href="http://validity.thatscaptaintoyou.com">JQuery Validity</a>,
					com algumas modificações para se adaptar a aplicação e mudança de
					linguagem do plugin(Mensagems de validação por exemplo).
				</p>
				<p>
					Foi usado também outro plugin JQuery para fazer a tabela de
					listagem das tarefas chamado <a
						href="https://datatables.net/examples/index">JQuery DataTables</a>
					com mudanças de adaptação.
				</p>
				<p>CSS foi tirado do site <a href="http://www.css3templates.co.uk/templates/CSS3_seascape_two/index.html"> CSS3 Templates</a> que disponibiliza layouts
					prontos, é simples e tirei boa parte das tags Divs do origial, tinha
					muitas DIVs como barra lateral laterais, e um tipo de slide show no topo.</p>

				<h3>Integrantes do grupo:</h3>

				<div style="padding-left: 25px;">Gabriel Andrade</div>
				<div style="padding-left: 25px;">Lucas Marchon</div>
				<div style="padding-left: 25px;">Dellon Gaudino</div>
				<div style="padding-left: 25px;">Yuri Felix</div>
				<div style="padding-left: 25px;">Diego Gonçalves</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
	<p>&nbsp;</p>
</body>
</html>
