package br.com.dentrio.dto;

public class DentistaDTO {

    private Integer id;
    private String nomeDentista;
    private String firstName;
    private String lastName;
    private String telefone;
    private String email;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getNomeDentista() {
	return nomeDentista;
    }

    public void setNomeDentista(String nomeDentista) {
	this.nomeDentista = nomeDentista;
    }

}
