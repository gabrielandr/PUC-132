package br.com.dentrio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedimento")
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "codigo_procedimento")
	private Integer codigoProcedimento;
	@Column(name = "nome_procedimento")
	private String nomeProcedimento;
	@Column(name = "valor_procedimento")
	private BigDecimal valorProcedimento;

	public Integer getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(Integer codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	public BigDecimal getValorProcedimento() {
		return valorProcedimento;
	}

	public void setValorProcedimento(BigDecimal valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

}
