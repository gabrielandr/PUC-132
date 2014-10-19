package br.com.dentrio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import br.com.dentrio.comum.BaseBean;
import br.com.dentrio.comum.TipoFuncionarioEnum;
import br.com.dentrio.funcionario.service.FuncionarioService;
import br.com.dentrio.model.Funcionario;
import br.com.dentrio.model.Paciente;
import br.com.dentrio.paciente.service.PacienteService;

@Controller("funcionarioBean")
@Scope("request")
public class FuncionarioBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String ERROR = "error";

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	PacienteService pacienteService;

	private Funcionario funcionario;
	private Funcionario funcionarioSelecionado;
	private List<TipoFuncionarioEnum> listaTiposFuncionario;
	private List<Funcionario> funcionarios;

	@PostConstruct
	private void inicializar() {
		limpar();
		this.funcionarios = null;
		this.funcionarios = funcionarioService.listFuncionarios();
		this.listaTiposFuncionario = Arrays.asList(TipoFuncionarioEnum.values());
	}

	public void limpar() {
		this.funcionario = new Funcionario();
		getFuncionario().setTipoFuncionario(null);
	}

	public String novoFuncionario() {
		limpar();
		return "formFuncionario?faces-redirect=true";
	}

	public String salvarFuncionario() {
		try {
			funcionarioService.addFuncionario(funcionario);
			addMessage("Sucesso", "Funcionario adicionado com Sucesso!");
			inicializar();
			return "listarFuncionarios";

		} catch (DataAccessException e) {
			e.printStackTrace();
			addMessage("Erro!", "Ocorreu um problema ao acessar o banco de dados!");
		}
		return ERROR;
	}

	public String editarFuncionario(Integer funcionarioId) {
		try {
			funcionario = funcionarioService.getFuncionario(funcionarioId);
			return "formFuncionario?faces-redirect=true&funcionarioId=" + funcionarioId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String deletarFuncionario(Integer funcionarioId) {
		try {
			/**
			 * {@i}
			 */
			deletarDependenciasPaciente(funcionarioId);

			Funcionario funcionario = funcionarioService.getFuncionario(funcionarioId);
			funcionarioService.deletarFuncionario(funcionario);
			addMessage("Sucesso", "Funcionario deletado com Sucesso!");
			inicializar();
			return "listarFuncionarios?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * Seta o campo FK dos pacientes vinculados ao funcionario a ser deletado
	 * para null antes de deletar o funcionario para não dar erro de Foreign Key
	 * Constraint.
	 * 
	 * @param funcionarioId
	 */
	private void deletarDependenciasPaciente(Integer funcionarioId) {
		List<Paciente> pacientes = pacienteService.getPacientesVinculadosFuncionario(funcionarioId);

		if (!pacientes.isEmpty()) {
			for (Paciente paciente : pacientes) {
				paciente.setFuncionario(null);
				pacienteService.salvarPaciente(paciente);
			}
		}
	}

	public String retornaTipoFuncionario() {
		return funcionario.getSocio() == true ? "Sócio" : funcionario.getTipoFuncionario().getDescricao();
	}

	public void resetForm() {
		inicializar();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public List<TipoFuncionarioEnum> getListaTiposFuncionario() {
		return listaTiposFuncionario;
	}

	public void setListaTiposFuncionario(List<TipoFuncionarioEnum> listaTiposFuncionario) {
		this.listaTiposFuncionario = listaTiposFuncionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
