package br.com.dentrio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable {

	private static final long serialVersionUID = -5988625296699742692L;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	private String profissao;
	private String bairro;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_orcamento")
	private Date dataOrcamento;
	private Boolean hemorragia;
	private Boolean pressao;
	private Boolean cardiaco;
	private Boolean alergia;
	private Boolean diabete;
	private Boolean gestante;
	private Boolean medico;

	@Column(name = "obs_anamnese")
	private String obsAnamnese;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Boolean getHemorragia() {
		return hemorragia;
	}

	public void setHemorragia(Boolean hemorragia) {
		this.hemorragia = hemorragia;
	}

	public Boolean getPressao() {
		return pressao;
	}

	public void setPressao(Boolean pressao) {
		this.pressao = pressao;
	}

	public Boolean getCardiaco() {
		return cardiaco;
	}

	public void setCardiaco(Boolean cardiaco) {
		this.cardiaco = cardiaco;
	}

	public Boolean getAlergia() {
		return alergia;
	}

	public void setAlergia(Boolean alergia) {
		this.alergia = alergia;
	}

	public Boolean getDiabete() {
		return diabete;
	}

	public void setDiabete(Boolean diabete) {
		this.diabete = diabete;
	}

	public Boolean getGestante() {
		return gestante;
	}

	public void setGestante(Boolean gestante) {
		this.gestante = gestante;
	}

	public Boolean getMedico() {
		return medico;
	}

	public void setMedico(Boolean medico) {
		this.medico = medico;
	}

	public String getObsAnamnese() {
		return obsAnamnese;
	}

	public void setObsAnamnese(String obsAnamnese) {
		this.obsAnamnese = obsAnamnese;
	}

	public Date getDataOrcamento() {
		return dataOrcamento;
	}

	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

}
