package br.com.dentrio.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import br.com.dentrio.comum.BaseBean;
import br.com.dentrio.despesa.service.DespesaService;
import br.com.dentrio.model.Despesa;

@Component("despesaBean")
@Scope("request")
public class DespesaBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String ERROR = "error";

	@Autowired
	DespesaService despesaService;

	private Date data;
	private Despesa despesa;
	private Despesa despesaSelecionado;
	List<Despesa> listaDespesas;

	@PostConstruct
	private void inicializar() {
		limpar();
		this.listaDespesas = null;
		this.listaDespesas = despesaService.listDespesas();
	}

	public void limpar() {
		this.despesa = new Despesa();
	}

	public String novaDespesa() {
		limpar();
		return "formDespesa?faces-redirect=true";
	}

	public String salvarDespesa() {
		try {
			despesaService.addDespesa(despesa);
			addMessage("Sucesso", "Despesa adicionada com Sucesso!");
			inicializar();
			return "listarDespesas?faces-redirect=true";

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String deletarDespesa(Integer despesaId) {
		try {
			Despesa despesa = despesaService.getDespesa(despesaId);
			despesaService.deletarDespesa(despesa);
			addMessage("Sucesso", "Despesa deletada com Sucesso!");
			return "listarDespesas?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public void resetForm() {
		despesa = new Despesa();
	}

	// public DespesaService getDespesaService() {
	// return despesaService;
	// }
	//
	// public void setDespesaService(DespesaService despesaService) {
	// this.despesaService = despesaService;
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

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Despesa> getListaDespesas() {
		return listaDespesas;
	}

	public void setListaDespesas(List<Despesa> listaDespesas) {
		this.listaDespesas = listaDespesas;
	}

	public Despesa getDespesaSelecionado() {
		return despesaSelecionado;
	}

	public void setDespesaSelecionado(Despesa despesaSelecionado) {
		this.despesaSelecionado = despesaSelecionado;
	}

	public DespesaService getDespesaService() {
		return despesaService;
	}

	public void setDespesaService(DespesaService despesaService) {
		this.despesaService = despesaService;
	}
}
