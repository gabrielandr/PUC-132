package rtp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import rtp.model.Tarefa;

/**
 * Esta classe abstrai o acesso ao BD para qualquer entidade que a utilizar. Se
 * quisermos trocar o banco de dados utilizado, fica facil a alteracao.
 * 
 */
public class DBConnection {
    private Connection conn;
    private Statement stm;

    private static DBConnection dbConnSingleton = null;

    /**
     * O construtor cria uma nova conexao com o banco de dados sqlite contido no
     * arquivo passado como parametro. A conexao eh possibilitada pelo driver
     * JDBC, fornecido por SQLiteJDBC.
     */
    public DBConnection(String file) throws SQLException,
	    ClassNotFoundException {
	// tenta inicializar a classe org.sqlite.JDBC, que possui um bloco
	// inicializador
	// estático que irá registrar essa classe como um driver JDBC
	Class.forName("org.sqlite.JDBC");
	// abre uma conexão com o banco de dados, passando uma String de conexão
	this.conn = DriverManager.getConnection("jdbc:sqlite:" + file);
	// O método createStatement() devolve um objeto java.sql.Statement, que
	// representa
	// uma simples Query ou comando
	this.stm = this.conn.createStatement();
    }

    /**
     * Classe Singleton que retorna a instancia do dbConnection. Cria uma nova
     * se nao existir, ou retorna a mesma se já existir
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static synchronized DBConnection getInstance()
	    throws ClassNotFoundException, SQLException {
	if (dbConnSingleton == null) {
	    dbConnSingleton = new DBConnection("Tarefas");
	    dbConnSingleton.initDB();
	    return dbConnSingleton;
	} else
	    return dbConnSingleton;
    }

    /**
     * 
     * @param file
     * @return
     */
    public static Connection retornaConexaoBD(String file) {
	Connection dbConnection = null;
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    System.out.println(e.getMessage());
	}
	try {
	    dbConnection = DriverManager.getConnection("jdbc:sqlite:" + file);
	    return dbConnection;
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
	return dbConnection;
    }

    /**
     * Cria uma nova tabela de tarefas, apagando tudo que houvesse na base
     * anteriormente.
     */
    public void initDB() {
	try {
	    this.stm.executeUpdate("DROP TABLE IF EXISTS Tarefas");
	    this.stm.executeUpdate("CREATE TABLE Tarefas ("
		    + "id INTEGER PRIMARY KEY UNIQUE," + "titulo varchar(50),"
		    + "prazo varchar," + "detalhes varchar(50),"
		    + "responsavel varchar(50)," + "urgente varchar(1),"
		    + "status varchar(50),"
		    + "data_conclusao varchar(50) default NULL,"
		    + "desc_solucao varchar(50) default NULL);,");
	    criarCargaTarefas();
	    // this.selectAll();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @throws SQLException
     */
    public void criarCargaTarefas() throws SQLException {
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Tarefa 1 criando a base de dados','01/01/2012','Detalhes da tarefa 1','Chaves',0,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Criar todas as classes','18/08/2014','Detalhes da tarefa 2','Chaves',0,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Iniciar o bando de dados no index.jsp','24/08/2014','Detalhes da tarefa 3','Chaves',0,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Criar a lógica Singleton no DBConnection','23/08/2014','Detalhes da tarefa 4','Quico',1,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Colocar Jquery DataTables na aplicação','22/08/2014','Com esse plugin jquery é possivel filtrar por qualquer campo','Quico',1,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Criar a tela de edição da tarefa','21/08/2014','Detalhes da tarefa 6','Quico',0,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Tela de criaçao','27/08/2014','Detalhes da tarefa 7','Chiquinha',0,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'colocar a listagem sempre no index','28/08/2014','Detalhes da tarefa 8','Chiquinha',1,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Mudar logica de listagem','29/08/2014','Ao criar tarefa ou editar, sempre ir para o index ja com a nova listagem','Chiquinha',0,'Aberta',null,null);");
	this.stm.executeUpdate("INSERT INTO Tarefas (id,titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
		+ "VALUES (null, 'Criar outra funcionalidade','24/10/2014','Pense em outra funcionalidade legal....','Chaves',1,'Concluída',null,null);");
    }

    /**
     * Remove a linha da tabela cuja coluna "id" seja igual ao int passado como
     * parametro.
     * 
     * @param nome
     */
    public void deleteTarefa(int id) {
	try {
	    StringBuffer sql = new StringBuffer();
	    PreparedStatement ps = null;

	    sql.append("DELETE FROM Tarefas WHERE id = ?");
	    ps = this.conn.prepareStatement(sql.toString());
	    ps.setInt(1, id); // Parâmetro para o primeiro ? do

	    ps.executeUpdate(); // executa a query
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param request
     * @throws ClassNotFoundException
     */
    public void updateTarefa(HttpServletRequest request)
	    throws ClassNotFoundException {
	try {

	    PreparedStatement ps = null;

	    String dataConclusao = request.getParameter("dtConclusao");
	    String descSolucao = request.getParameter("descSolucao");
	    String id = request.getParameter("id");

	    ps = this.conn
		    .prepareStatement("UPDATE Tarefas set status = 'Concluída',data_conclusao = ?,desc_solucao = ?"
			    + "WHERE id = ?");
	    ps.setString(1, dataConclusao);
	    ps.setString(2, descSolucao);
	    ps.setString(3, id);

	    ps.executeUpdate(); // executa a query

	    Tarefa tarefa = dbConnSingleton.retornaTarefaPorId(id);
	    dbConnSingleton.atualizarSession(request, id, "Atualização",
		    tarefa.getTitulo(), tarefa.getPrazo(),
		    tarefa.getDetalhes(), tarefa.getResponsavel(),
		    tarefa.getUrgente(), "Concluída", dataConclusao,
		    descSolucao);

	    System.out.println("Registro atualizado na tabela Tarefas!");

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @return
     */
    public List<Tarefa> selectAll() {
	List<Tarefa> tarefas = new ArrayList<Tarefa>();
	ResultSet rs;
	try {
	    rs = this.stm.executeQuery("SELECT * FROM Tarefas "
		    + "ORDER BY titulo");
	    while (rs.next()) {
		tarefas.add(new Tarefa(rs.getString("id"), rs
			.getString("titulo"), rs.getString("prazo"), rs
			.getString("detalhes"), rs.getString("responsavel"), rs
			.getString("urgente"), rs.getString("status"), rs
			.getString("data_conclusao"), rs
			.getString("desc_solucao")));
	    }
	    rs.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return tarefas;
    }

    /**
     * Retorna um objeto List com todos as tarefas do banco de dados pelo status
     * 
     * @param status
     * @return
     */
    public List<Tarefa> retornaTarefasPorStatus(String status) {
	ResultSet rs;
	List<Tarefa> tarefas = new ArrayList<Tarefa>();
	try {
	    rs = this.stm.executeQuery("SELECT * FROM Tarefas WHERE status = '"
		    + status + "'" + " ORDER BY titulo asc;");
	    while (rs.next()) {
		tarefas.add(new Tarefa(rs.getString("id"), rs
			.getString("titulo"), rs.getString("prazo"), rs
			.getString("detalhes"), rs.getString("responsavel"), rs
			.getString("urgente"), rs.getString("Status"), rs
			.getString("data_conclusao"), rs
			.getString("desc_solucao")));
	    }
	    rs.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return tarefas;
    }

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    public Tarefa retornaTarefaPorId(String id) throws SQLException {
	ResultSet rs;
	Tarefa tarefa = null;
	try {
	    rs = this.stm.executeQuery("SELECT * FROM Tarefas "
		    + "WHERE id = '" + id + "'");
	    while (rs.next()) {
		tarefa = new Tarefa(rs.getString("id"), rs.getString("titulo"),
			rs.getString("prazo"), rs.getString("detalhes"),
			rs.getString("responsavel"), rs.getString("urgente"),
			rs.getString("Status"), rs.getString("data_conclusao"),
			rs.getString("desc_solucao"));
	    }
	    rs.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return tarefa;
    }

    /**
     * 
     * @param request
     * @throws ClassNotFoundException
     */
    public void criarTarefa(HttpServletRequest request)
	    throws ClassNotFoundException {

	try {
	    PreparedStatement ps = null;

	    String titulo = request.getParameter("titulo");
	    String prazo = request.getParameter("dtPrazo");
	    String detalhes = request.getParameter("detalhes");
	    String responsavel = request.getParameter("responsavel");
	    String urgente = request.getParameter("urgente") == null ? "0"
		    : "1";

	    ps = this.conn
		    .prepareStatement("INSERT INTO Tarefas (titulo,prazo,detalhes,responsavel,urgente,status,data_conclusao,desc_solucao)"
			    + "VALUES (?,?,?,?,?,?,?,?);");
	    // ps.setString(1, null);
	    ps.setString(1, titulo);
	    ps.setString(2, prazo);
	    ps.setString(3, detalhes);
	    ps.setString(4, responsavel);
	    ps.setString(5, urgente);
	    ps.setString(6, "Aberta");
	    ps.setString(7, null);
	    ps.setString(8, null);

	    ps.executeUpdate(); // executa a query
	    ps.close();

	    dbConnSingleton
		    .atualizarSession(request, null, "Criação", titulo, prazo,
			    detalhes, responsavel, urgente, "Aberta", null,
			    null);

	    System.out.println("Registro inserido na tabela Tarefas!");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param session
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<Map<Integer, String>, Tarefa> retornaMapTarefasSession(
	    HttpSession session) {
	// se não existir o atributo na session, cria um atributo novo
	if (session.getAttribute("tarefasMap") == null) {
	    session.setAttribute("tarefasMap",
		    new HashMap<String, List<Tarefa>>());
	}
	// retorna o map de tarefas da session
	return (Map<Map<Integer, String>, Tarefa>) session
		.getAttribute("tarefasMap");
    }

    /**
     * Método que atualiza a sessao com a tarefa criada/atualizada
     * 
     * @param request
     * @param id
     * @param tipoAcao
     * @param titulo
     * @param prazo
     * @param detalhes
     * @param responsavel
     * @param urgente
     * @param status
     * @param dataConclusao
     * @param descSolucao
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void atualizarSession(HttpServletRequest request, String id,
	    String tipoAcao, String titulo, String prazo, String detalhes,
	    String responsavel, String urgente, String status,
	    String dataConclusao, String descSolucao)
	    throws ClassNotFoundException, SQLException {

	DBConnection dbConn = DBConnection.getInstance();
	Integer valorId;
	if ("".equalsIgnoreCase(id) || id == null) {
	    // se for criação de tarefa, o id é o ultimo inserido na tabela
	    valorId = dbConn.selectAll().size();
	} else {
	    // se não, pega o id passado no parâmetro, id da tarefa atualizada
	    valorId = Integer.parseInt(id);
	}
	// cria a tarefa para ser inserida na session
	Tarefa tarefa = new Tarefa(String.valueOf(valorId), titulo, prazo,
		detalhes, responsavel, urgente, status, dataConclusao,
		descSolucao);

	HttpSession session = request.getSession();
	// mapKey servirá como key do map principal, neste map será inserido
	// "id, 'tipoAcao'" , eg: 12,'Criação'
	Map<Integer, String> mapKey = new HashMap<Integer, String>();
	mapKey.put(valorId, tipoAcao);
	// Recupero o map principal de tarefas da session
	Map<Map<Integer, String>, Tarefa> mapTarefasSession = retornaMapTarefasSession(session);

	// com o mapKey, eu garanto que o put sempre irá inserir objetos
	// diferentes no map, o mapkey nunca irá ser igual
	mapTarefasSession.put(mapKey, tarefa);
    }
}