package br.com.dentrio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.dentrio.comum.TipoFuncionarioEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = -5988625296699742692L;

	@Enumerated(EnumType.STRING)
	private TipoFuncionarioEnum tipoFuncionario;

	private String login;
	private String senha;
	private String cro;

	@Column(columnDefinition = "boolean default false")
	private Boolean socio;

	@Column(name = "hora_entrada")
	private Date horaEntrada;

	@Column(name = "hora_saida")
	private Date horaSaida;

	// public Funcionario() {
	//
	// }
	//
	// public Funcionario(String nomeFuncionario, Long cpf, Long rg, Date
	// dataNascimento, String endereco,
	// String telefone, String celular, TipoFuncionarioEnum tipoFuncionario,
	// String login, String senha,
	// String cro, Boolean socio, Date horaEntrada, Date horaSaida) {
	//
	// super(nomeFuncionario, cpf, rg, dataNascimento, endereco, telefone,
	// celular);
	// this.tipoFuncionario = tipoFuncionario;
	// this.login = login;
	// this.senha = senha;
	// this.cro = cro;
	// this.socio = socio;
	// this.horaEntrada = horaEntrada;
	// this.horaSaida = horaSaida;
	// }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + ((cro == null) ? 0 : cro.hashCode());
		result = (prime * result) + ((horaEntrada == null) ? 0 : horaEntrada.hashCode());
		result = (prime * result) + ((horaSaida == null) ? 0 : horaSaida.hashCode());
		result = (prime * result) + ((login == null) ? 0 : login.hashCode());
		result = (prime * result) + ((senha == null) ? 0 : senha.hashCode());
		result = (prime * result) + ((socio == null) ? 0 : socio.hashCode());
		result = (prime * result) + ((tipoFuncionario == null) ? 0 : tipoFuncionario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Funcionario other = (Funcionario) obj;
		if (cro == null) {
			if (other.cro != null) {
				return false;
			}
		} else if (!cro.equals(other.cro)) {
			return false;
		}
		if (horaEntrada == null) {
			if (other.horaEntrada != null) {
				return false;
			}
		} else if (!horaEntrada.equals(other.horaEntrada)) {
			return false;
		}
		if (horaSaida == null) {
			if (other.horaSaida != null) {
				return false;
			}
		} else if (!horaSaida.equals(other.horaSaida)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (senha == null) {
			if (other.senha != null) {
				return false;
			}
		} else if (!senha.equals(other.senha)) {
			return false;
		}
		if (socio == null) {
			if (other.socio != null) {
				return false;
			}
		} else if (!socio.equals(other.socio)) {
			return false;
		}
		if (tipoFuncionario != other.tipoFuncionario) {
			return false;
		}
		return true;
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public Boolean getSocio() {
		return socio;
	}

	public void setSocio(Boolean socio) {
		this.socio = socio;
	}

	public TipoFuncionarioEnum getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionarioEnum tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

}
