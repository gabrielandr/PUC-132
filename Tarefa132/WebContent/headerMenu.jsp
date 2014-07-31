<% String status = request.getParameter("status"); %>
<% String menuSelecionado = request.getParameter("menuSelecionado"); %>
<header>
		<div id="logo">
			<div id="logo_text">
				<!-- class="logo_colour", allows you to change the colour of the text -->
				<h1 style="margin-top: 20px;">
					<a href="index.jsp">Tarefas 
					<span class="logo_colour">132
					</span></a>
				</h1>
				</h1>
			</div>
		</div>
		<nav>
		<ul class="sf-menu" id="nav" style="display: -webkit-inline-box;">
			<li <%= "home".equalsIgnoreCase(menuSelecionado) ? "class='selected'" : ""%>><a href="./">Home</a></li>
			<li <%= "criar".equalsIgnoreCase(menuSelecionado) ? "class='selected'" : ""%>><a href="criarTarefa.jsp">Criar tarefa</a></li>
			<li>&nbsp;</li>
			<li <%= "aberta".equalsIgnoreCase(status) ? "class='selected'" : ""%>><a href="index.jsp?status=Aberta">Tarefas Abertas</a></li>
			<li <%= "concluída".equalsIgnoreCase(status) ? "class='selected'" : ""%>>
				<a href="index.jsp?status=Concluída">Tarefas Concluídas</a>
			</li>
			<li <%= "session".equalsIgnoreCase(menuSelecionado) ? "class='selected'" : ""%>>
				<a href='./sessionInfo'>Session</a>
			</li>

			<li <%= "info".equalsIgnoreCase(menuSelecionado) ? "class='selected'" : ""%>>
				<a href='info.jsp?menuSelecionado=info'>Info</a>
			</li>

		</ul>
		</nav> </header>