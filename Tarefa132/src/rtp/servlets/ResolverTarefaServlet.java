package rtp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rtp.db.DBConnection;
import rtp.model.Tarefa;

@WebServlet("/ResolverTarefaServlets")
public class ResolverTarefaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResolverTarefaServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	Tarefa tarefa = new Tarefa();
	String id = request.getParameter("id");
	String urgenteChecked = "";
	try {
	    DBConnection dbCon = DBConnection.getInstance();
	    tarefa = dbCon.retornaTarefaPorId(id);
	    urgenteChecked = retornaUrgenteChecked(tarefa);
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	request.setAttribute("tarefa", tarefa);
	request.setAttribute("urgente", urgenteChecked);

	RequestDispatcher view = request
		.getRequestDispatcher("resolverTarefa.jsp");

	view.forward(request, response);

    }

    public String retornaUrgenteChecked(Tarefa tarefa) {
	return "1".equalsIgnoreCase(tarefa.getUrgente()) ? "checked='checked'"
		: "";
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	List<Tarefa> tarefas = new ArrayList<Tarefa>();
	DBConnection dbCon = null;
	try {
	    dbCon = DBConnection.getInstance();
	} catch (ClassNotFoundException | SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	try {
	    dbCon.updateTarefa(request);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	// dbCon.updateSession(request);
	tarefas.addAll(dbCon.retornaTarefasPorStatus("Aberta"));
	request.setAttribute("tarefas", tarefas);

	RequestDispatcher view = request.getRequestDispatcher("index.jsp");

	view.forward(request, response);
    }

    public void resolverTarefa(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("idTarefa");
	System.out.println(id);
    }

}
