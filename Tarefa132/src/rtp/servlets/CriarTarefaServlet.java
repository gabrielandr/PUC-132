package rtp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rtp.db.DBConnection;

/**
 * Servlet implementation class CriarTarefaServlet
 */
@WebServlet("/CriarTarefaServlet")
public class CriarTarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn;
    private Statement stm;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarTarefaServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	try {
	    DBConnection db = DBConnection.getInstance();
	    System.out.println(db.selectAll());
	} catch (ClassNotFoundException | SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	DBConnection dbCon = null;

	try {
	    dbCon = DBConnection.getInstance();
	    dbCon.criarTarefa(request);

	} catch (SQLException e) {

	    System.out.println(e.getMessage());

	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	RequestDispatcher view = request.getRequestDispatcher("/");
	view.forward(request, response);
    }
}
