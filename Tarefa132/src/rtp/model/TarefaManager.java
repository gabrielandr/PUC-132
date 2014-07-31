package rtp.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TarefaManager {
    private static List<Tarefa> listaTarefas = new ArrayList<Tarefa>();

    public static final String STATUS_TAREFA_ABERTA = "Aberta";
    public static final String STATUS_TAREFA_CONCLUIDA = "Concluida";

    private static List<Tarefa> tarefasPorStatus = new ArrayList<Tarefa>();

    public static String criarTarefa(String id, String titulo, String prazo,
	    String detalhes, String responsavel, String urgente, String status,
	    String dtConclusao, String descSolucao) {

	if (titulo.isEmpty() || prazo.isEmpty() || responsavel.isEmpty()) {
	    return "Erro na criação da tarefa: Preencher todos os 	campos!";
	}
	Tarefa t = new Tarefa(id, titulo, prazo, detalhes, responsavel,
		urgente, STATUS_TAREFA_ABERTA, dtConclusao, descSolucao);

	listaTarefas.add(t);

	return "Tarefa criada com sucesso";
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException,
	    SQLException, ClassNotFoundException {

	String s = request.getParameter("status");

	// List<Tarefa> result = TarefaManager.recuperarTarefaPorStatus(s);

	// request.setAttribute("tarefas", result);

	RequestDispatcher view = request.getRequestDispatcher("result.jsp");

	view.forward(request, response);
    }

}
