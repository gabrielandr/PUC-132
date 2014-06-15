package rtp.model;

public class Tarefa {

    private String id;
    private String titulo;
    private String prazo;
    private String detalhes;
    private String responsavel;
    private String urgente;
    private String status;
    private String dtConclusao;
    private String descSolucao;

    public Tarefa(String id, String titulo, String prazo, String detalhes,
	    String responsavel, String urgente, String status,
	    String dtConclusao, String descSolucao) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.prazo = prazo;
	this.detalhes = detalhes;
	this.responsavel = responsavel;
	this.urgente = urgente;
	this.status = status;
	this.dtConclusao = dtConclusao;
	this.descSolucao = descSolucao;
    }

    public Tarefa() {

    }

    public String getDetalhes() {
	return detalhes;
    }

    public void setDetalhes(String detalhes) {
	this.detalhes = detalhes;
    }

    public String getDtConclusao() {
	return dtConclusao;
    }

    public void setDtConclusao(String dtConclusao) {
	this.dtConclusao = dtConclusao;
    }

    public String getDescSolucao() {
	return descSolucao;
    }

    public void setDescSolucao(String descSolucao) {
	this.descSolucao = descSolucao;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public String getPrazo() {
	return prazo;
    }

    public void setPrazo(String prazo) {
	this.prazo = prazo;
    }

    public String getResponsavel() {
	return responsavel;
    }

    public void setResponsavel(String responsavel) {
	this.responsavel = responsavel;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getUrgente() {
	return urgente;
    }

    public void setUrgente(String urgente) {
	this.urgente = urgente;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String retornaDataConclusao() {
	return this.dtConclusao == null ? "-" : this.dtConclusao;
    }

    public String retornaDescSolucao() {
	return this.descSolucao == null ? "-" : this.descSolucao;
    }

}
