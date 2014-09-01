package br.com.dentrio.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dentrio.model.Dentista;

@Repository
public class DentistaDaoImpl implements DentistaDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    public void addDentista(Dentista dentista) {
	getSessionFactory().getCurrentSession().persist(dentista);
    }

    /**
     * {@inheritDoc}
     */
    public void editarDentista(Dentista dentista) {
	// Dentista dentistaToUpdate = getDentista(dentista.getId());
	// dentistaToUpdate.setFirstName(dentista.getFirstName());
	// dentistaToUpdate.setLastName(dentista.getLastName());
	// dentistaToUpdate.setTelefone(dentista.getTelefone());
	// dentistaToUpdate.setEmail(dentista.getEmail());
	// sessionFactory.getCurrentSession().update(dentistaToUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Dentista> listDentistas() {
	return (List<Dentista>) getSessionFactory().getCurrentSession()
		.createCriteria(Dentista.class).list();
    }

    /**
     * {@inheritDoc}
     */
    public Dentista getDentista(Integer dentistaId) {
	return (Dentista) getSessionFactory().getCurrentSession().get(
		Dentista.class, dentistaId);
	// return entityManager.find(Dentista.class, dentistaId);
	// return null;
    }

    //
    /**
     * {@inheritDoc}
     */
    public void deletarDentista(Dentista dentista) {
	getSessionFactory().getCurrentSession().delete(dentista);
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

}
