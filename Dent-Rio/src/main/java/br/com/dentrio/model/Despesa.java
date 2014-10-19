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
@Table(name = "despesa")
public class Despesa implements Serializable {

    private static final long serialVersionUID = -5988625296699742692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_despesa")
    private String nomeDespesa;

    private BigDecimal valor;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNomeDespesa() {
	return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
	this.nomeDespesa = nomeDespesa;
    }

    public BigDecimal getValor() {
	return valor;
    }

    public void setValor(BigDecimal valor) {
	this.valor = valor;
    }

}
