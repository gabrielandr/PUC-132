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

/**
 * Servlet implementation class ListarTarefasServlets
 */
@WebServlet("/ListarTarefasServlets")
public class ListarTarefasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTarefasServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	String s = request.getParameter("status");

	List<Tarefa> tarefas = new ArrayList<Tarefa>();
	try {

	    // Conecta-se com o banco de dados de vinhos
	    DBConnection dbCon = DBConnection.getInstance();
	    // Seleciona todos os vinhos que se enquadrem na cor passada como
	    // parametro
	    tarefas.addAll(dbCon.retornaTarefasPorStatus(s));

	    // tarefas = DBConnection.retornaTarefasPorStatus(s);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	request.setAttribute("tarefas", tarefas);

	RequestDispatcher view = request.getRequestDispatcher("result.jsp");

	view.forward(request, response);
    }

}
