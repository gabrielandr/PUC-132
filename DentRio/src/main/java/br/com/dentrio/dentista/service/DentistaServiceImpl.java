package br.com.dentrio.dentista.service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import br.com.dentrio.dentista.dao.DentistaDao;
import br.com.dentrio.dentista.model.Dentista;

@Service
@Transactional(value = TxType.REQUIRED)
public class DentistaServiceImpl implements DentistaService {

    @Inject
    public DentistaDao dentistaDao;

    /**
     * {@inheritDoc}
     */
    public void addDentista(Dentista dentista) {
	dentistaDao.addDentista(dentista);
    }

    /**
     * {@inheritDoc}
     */
    // public void editDentista(Dentista dentista) {
    // dentistaDao.editDentista(dentista);
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // public List<Dentista> listDentistas() {
    // return dentistaDao.listDentistass();
    // }
    //
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
    public void deletarDentista(Dentista dentista) {
	dentistaDao.deletarDentista(dentista);

    }
    //
    // public DentistaDao getDentistaDao() {
    // return dentistaDao;
    // }
    //
    // public void setDentistaDao(DentistaDao dentistaDao) {
    // this.dentistaDao = dentistaDao;
    // }

}
