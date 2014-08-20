package br.com.dentrio.dentista.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.dentrio.dentista.comum.BaseBean;
import br.com.dentrio.dentista.model.Dentista;
import br.com.dentrio.dentista.service.DentistaService;

import com.sun.faces.context.flash.ELFlash;

@Named
@ViewScoped
@ManagedBean
public class DentistaBean extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1806438848328391872L;

    @Inject
    private EntityManager entityManager;
    @Inject
    transient private DentistaService dentistaService;

    private Date data;
    private Dentista dentista = new Dentista();
    private Dentista dentistaSelecionado;
    private List<Dentista> listaDentistas = new ArrayList<Dentista>();

    public void prepararPedidos() {
	carregarListaDentistas();
    }

    private void carregarListaDentistas() {
	listaDentistas = entityManager.createQuery("from Dentista",
		Dentista.class).getResultList();
    }

    public String adicionarDentista() {
	entityManager.getTransaction().begin();
	dentistaService.addDentista(dentista);
	entityManager.getTransaction().commit();
	carregarListaDentistas();
	addMessage("Sucesso", "Dentista adicionado com Sucesso!");
	resetForm();
	ELFlash.getFlash().put("teste", "Testando mensagem");
	return "listarDentistas?faces-redirect=true";
	// return "home";
    }

    public void deletarDentista(Integer dentistaId) {
	entityManager.getTransaction().begin();
	Dentista dentista = dentistaService.getDentista(dentistaId);
	dentistaService.deletarDentista(dentista);
	entityManager.getTransaction().commit();
	carregarListaDentistas();
	resetForm();
    }

    public void resetForm() {
	dentista = new Dentista();
    }

    // public DentistaService getDentistaService() {
    // return dentistaService;
    // }
    //
    // public void setDentistaService(DentistaService dentistaService) {
    // this.dentistaService = dentistaService;
    // }
    //
    // public EntityManager getManager() {
    // return entityManager;
    // }
    //
    // public void setManager(EntityManager manager) {
    // this.entityManager = manager;
    // }
    //
    // public EntityManager getEntityManager() {
    // return entityManager;
    // }
    //
    // public void setEntityManager(EntityManager entityManager) {
    // this.entityManager = entityManager;
    // }

    public Dentista getDentista() {
	return dentista;
    }

    public void setDentista(Dentista dentista) {
	this.dentista = dentista;
    }

    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    public EntityManager getEntityManager() {
	return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    public DentistaService getDentistaService() {
	return dentistaService;
    }

    public void setDentistaService(DentistaService dentistaService) {
	this.dentistaService = dentistaService;
    }

    public List<Dentista> getListaDentistas() {
	return listaDentistas;
    }

    public void setListaDentistas(List<Dentista> listaDentistas) {
	this.listaDentistas = listaDentistas;
    }

    public Dentista getDentistaSelecionado() {
	return dentistaSelecionado;
    }

    public void setDentistaSelecionado(Dentista dentistaSelecionado) {
	this.dentistaSelecionado = dentistaSelecionado;
    }

}
