package br.com.dentrio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dentrio.dao.DentistaDao;
import br.com.dentrio.model.Dentista;

@Service("DentistaServiceImpl")
@Transactional(readOnly = true)
public class DentistaServiceImpl {

    @Autowired
    public DentistaDao dentistaDao;

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false)
    public void addDentista(Dentista dentista) {
	dentistaDao.addDentista(dentista);
    }

    /**
     * {@inheritDoc}
     */
    public void editarDentista(Dentista dentista) {
	dentistaDao.editarDentista(dentista);
    }

    /**
     * {@inheritDoc}
     */
    public List<Dentista> listDentistas() {
	return dentistaDao.listDentistas();
    }

    /**
     * {@inheritDoc}
     */
    public Dentista getDentista(Integer dentistaId) {
	return dentistaDao.getDentista(dentistaId);
    }

    //
    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false)
    public void deletarDentista(Dentista dentista) {
	dentistaDao.deletarDentista(dentista);

    }

    public DentistaDao getDentistaDao() {
	return dentistaDao;
    }

    public void setDentistaDao(DentistaDao dentistaDao) {
	this.dentistaDao = dentistaDao;
    }

}
