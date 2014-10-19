package br.com.dentrio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import br.com.dentrio.comum.BaseBean;
import br.com.dentrio.funcionario.service.FuncionarioService;
import br.com.dentrio.model.Funcionario;
import br.com.dentrio.model.Paciente;
import br.com.dentrio.paciente.service.PacienteService;

@Controller("pacienteBean")
public class PacienteBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String ERROR = "error";

	@Autowired
	PacienteService pacienteService;

	@Autowired
	FuncionarioService funcionarioService;

	private Date data;
	private Paciente paciente = new Paciente();
	// private Funcionario funcionario = new Funcionario();
	private Paciente pacienteSelecionado;
	List<Paciente> listaPacientes = new ArrayList<Paciente>();
	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	public void prepararPacientes() {
		carregarListaPacientes();
	}

	@PostConstruct
	private void carregarListaPacientes() {
		listaPacientes = new ArrayList<Paciente>();
		listaPacientes.addAll(pacienteService.listPacientes());
	}

	public String salvarPaciente() {
		try {
			pacienteService.salvarPaciente(paciente);
			carregarListaPacientes();
			addMessage("Sucesso", "Paciente adicionado com Sucesso!");
			return "listarPacientes?faces-redirect=true";

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String editarPaciente(Integer pacienteId) {
		try {
			paciente = pacienteService.getPaciente(pacienteId);
			pacienteService.editarPaciente(paciente);
			return "formPaciente?faces-redirect=true&pacienteId=" + pacienteId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String deletarPaciente(Integer pacienteId) {
		try {
			Paciente paciente = pacienteService.getPaciente(pacienteId);
			pacienteService.deletarPaciente(paciente);
			addMessage("Sucesso", "Paciente deletado com Sucesso!");
			return "listarPacientes?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public void resetForm() {
		paciente = new Paciente();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Paciente> getListaPacientes() {
		return pacienteService.listPacientes();
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public List<Funcionario> getlistaFuncionarios() {
		return funcionarioService.listFuncionarios();
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public List<Funcionario> getListaFuncionarios() {
		return funcionarioService.listFuncionarios();
	}
}
