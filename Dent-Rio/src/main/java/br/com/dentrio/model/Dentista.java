package br.com.dentrio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dentista")
public class Dentista implements Serializable {

    private static final long serialVersionUID = -5988625296699742692L;

    private Integer id;
    private String nomeDentista;
    private Date data;
    private Integer rg;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(name = "nome_dentista")
    public String getNomeDentista() {
	return nomeDentista;
    }

    public void setNomeDentista(String nomeDentista) {
	this.nomeDentista = nomeDentista;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    public Integer getRg() {
	return rg;
    }

    public void setRg(Integer rg) {
	this.rg = rg;
    }

}
