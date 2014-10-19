package br.com.dentrio.paciente.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentrio.model.Paciente;

@Repository
@Transactional
public class PacienteDaoImpl implements PacienteDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvarPaciente(Paciente paciente) {
		getSessionFactory().getCurrentSession().merge(paciente);
		getSessionFactory().getCurrentSession().flush();
	}

	@Override
	public void editarPaciente(Paciente paciente) {
		// Paciente pacienteToUpdate = getPaciente(paciente.getId());
		// pacienteToUpdate.setFirstName(paciente.getFirstName());
		// pacienteToUpdate.setLastName(paciente.getLastName());
		// pacienteToUpdate.setTelefone(paciente.getTelefone());
		// pacienteToUpdate.setEmail(paciente.getEmail());
		// sessionFactory.getCurrentSession().update(pacienteToUpdate);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Paciente> listPacientes() {
		return getSessionFactory().getCurrentSession().createCriteria(Paciente.class).list();
	}

	@Override
	public Paciente getPaciente(Integer pacienteId) {
		return (Paciente) getSessionFactory().getCurrentSession().get(Paciente.class, pacienteId);
		// return entityManager.find(Paciente.class, pacienteId);
		// return null;
	}

	@Override
	public void deletarPaciente(Paciente paciente) {
		getSessionFactory().getCurrentSession().delete(paciente);
		getSessionFactory().getCurrentSession().flush();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Paciente> getPacientesVinculadosDentista(Integer funcionarioId) {
		return getSessionFactory().getCurrentSession()
				.createQuery("SELECT p FROM Paciente p WHERE p.funcionario.id = " + funcionarioId).list();
	}

}
