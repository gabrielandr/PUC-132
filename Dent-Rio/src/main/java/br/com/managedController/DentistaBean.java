package br.com.managedController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import org.springframework.dao.DataAccessException;

import br.com.dentrio.comum.BaseBean;
import br.com.dentrio.model.Dentista;
import br.com.dentrio.service.DentistaServiceImpl;

@ManagedBean(name = "dentistaBean")
@ViewScoped
public class DentistaBean extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    // private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    @ManagedProperty(value = "#{DentistaServiceImpl}")
    DentistaServiceImpl dentistaServiceImpl;

    private Date data;
    private Dentista dentista = new Dentista();
    private Dentista dentistaSelecionado;
    List<Dentista> listaDentistas = new ArrayList<Dentista>();

    public void prepararPedidos() {
	carregarListaDentistas();
    }

    @PostConstruct
    private void carregarListaDentistas() {
	listaDentistas = new ArrayList<Dentista>();
	listaDentistas.addAll(dentistaServiceImpl.listDentistas());
    }

    public String adicionarDentista() {
	try {
	    dentistaServiceImpl.addDentista(dentista);
	    carregarListaDentistas();
	    addMessage("Sucesso", "Dentista adicionado com Sucesso!");
	    return "listarDentistas?faces-redirect=true";

	} catch (DataAccessException e) {
	    e.printStackTrace();
	}
	return ERROR;
    }

    // public String editarDentista(Integer dentistaId) {
    // try {
    // Dentista dentista = dentistaServiceImpl.getDentista(dentistaId);
    // dentistaServiceImpl.editarDentista(dentista);
    // return "editarDentista?faces-redirect=true&dentistaId="
    // + dentistaId;
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    public void deletarDentista(Integer dentistaId) {
	try {
	    Dentista dentista = dentistaServiceImpl.getDentista(dentistaId);
	    dentistaServiceImpl.deletarDentista(dentista);
	    addMessage("Sucesso", "Dentista deletado com Sucesso!");
	    carregarListaDentistas();
	} catch (Exception e) {
	    e.printStackTrace();
	}
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

    public DentistaServiceImpl getDentistaServiceImpl() {
	return dentistaServiceImpl;
    }

    public void setDentistaServiceImpl(DentistaServiceImpl dentistaServiceImpl) {
	this.dentistaServiceImpl = dentistaServiceImpl;
    }
}
