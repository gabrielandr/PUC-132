package rtp.db;

import java.util.Iterator;

import rtp.model.Tarefa;

public class UtilsDB {

    public static void inicializaBD() {
	try {
	    DBConnection dbCon = DBConnection.getInstance();
	    // dbCon.initDB();
	    UtilsDB.imprimeLista(dbCon);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void imprimeLista(DBConnection dbCon) {
	Iterator<Tarefa> it = dbCon.selectAll().iterator();
	Tarefa tarefa;
	System.out.println("---------------------");
	System.out.println("Dados da Tabela Tarefas");
	while (it.hasNext()) {
	    tarefa = (Tarefa) it.next();
	    System.out.println("Id:" + String.valueOf(tarefa.getId()));
	    System.out.println("titulo:" + tarefa.getTitulo());
	    System.out.println("Prazo:" + tarefa.getPrazo());
	    System.out.println("responsavel:"
		    + String.valueOf(tarefa.getResponsavel()));
	    System.out.println();
	}
    }
}