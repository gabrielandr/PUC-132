package rtp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rtp.db.DBConnection;
import rtp.model.Tarefa;

/**
 * Servlet implementation class SessionInfoServlet
 */
@WebServlet("/SessionInfoServlet")
public class SessionInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionInfoServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	DBConnection dbCon = null;
	try {
	    dbCon = DBConnection.getInstance();
	} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	}
	Map<Map<Integer, String>, Tarefa> tarefasMap;
	HttpSession session = request.getSession();
	tarefasMap = dbCon.retornaMapTarefasSession(session);
	request.setAttribute("mapTarefasSession", tarefasMap);

	RequestDispatcher view = request.getRequestDispatcher("session.jsp");

	view.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession(true);
	request.setAttribute("menuSelecionado", "session");
	RequestDispatcher view = request.getRequestDispatcher("/");
	view.forward(request, response);
    }
}
