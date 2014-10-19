package br.com.dentrio.despesa.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentrio.model.Despesa;

@Repository
@Transactional
public class DespesaDaoImpl implements DespesaDao, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDespesa(Despesa despesa) {
	getSessionFactory().getCurrentSession().persist(despesa);
	getSessionFactory().getCurrentSession().flush();
    }

    @Override
    public void editarDespesa(Despesa despesa) {
	// Despesa despesaToUpdate = getDespesa(despesa.getId());
	// despesaToUpdate.setFirstName(despesa.getFirstName());
	// despesaToUpdate.setLastName(despesa.getLastName());
	// despesaToUpdate.setTelefone(despesa.getTelefone());
	// despesaToUpdate.setEmail(despesa.getEmail());
	// sessionFactory.getCurrentSession().update(despesaToUpdate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Despesa> listDespesas() {
	return getSessionFactory().getCurrentSession()
		.createCriteria(Despesa.class).list();
    }

    @Override
    public Despesa getDespesa(Integer despesaId) {
	return (Despesa) getSessionFactory().getCurrentSession().get(
		Despesa.class, despesaId);
	// return entityManager.find(Despesa.class, despesaId);
	// return null;
    }

    @Override
    public void deletarDespesa(Despesa despesa) {
	getSessionFactory().getCurrentSession().delete(despesa);
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

}
