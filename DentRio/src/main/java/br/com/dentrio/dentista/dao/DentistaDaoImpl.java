package br.com.dentrio.dentista.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.dentrio.dentista.model.Dentista;

@Repository
public class DentistaDaoImpl implements DentistaDao {

    // @Autowired
    // private SessionFactory sessionFactory;
    @Inject
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    public void addDentista(Dentista dentista) {
	entityManager.persist(dentista);
    }

    /**
     * {@inheritDoc}
     */
    public void editDentista(Dentista dentista) {
	// Dentista dentistaToUpdate = getDentista(dentista.getId());
	// dentistaToUpdate.setFirstName(dentista.getFirstName());
	// dentistaToUpdate.setLastName(dentista.getLastName());
	// dentistaToUpdate.setTelefone(dentista.getTelefone());
	// dentistaToUpdate.setEmail(dentista.getEmail());
	// sessionFactory.getCurrentSession().update(dentistaToUpdate);
    }

    // /**
    // * {@inheritDoc}
    // */
    // @SuppressWarnings("unchecked")
    // public List<Dentista> listDentistass() {
    // return (List<Dentista>) sessionFactory.getCurrentSession()
    // .createCriteria(Dentista.class).list();
    // }
    //
    /**
     * {@inheritDoc}
     */
    public Dentista getDentista(Integer dentistaId) {
	return entityManager.find(Dentista.class, dentistaId);
    }

    //
    /**
     * {@inheritDoc}
     */
    public void deletarDentista(Dentista dentista) {
	// Dentista dentista = (Dentista)
	// sessionFactory.getCurrentSession().load(
	// Dentista.class, dentistaId);
	if (dentista != null) {
	    entityManager.remove(dentista);
	}
    }
    //
    // public SessionFactory getSessionFactory() {
    // return sessionFactory;
    // }
    //
    // public void setSessionFactory(SessionFactory sessionFactory) {
    // this.sessionFactory = sessionFactory;
    // }
}
