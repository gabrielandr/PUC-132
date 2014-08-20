package br.com.dentrio.dentista.dao;

import br.com.dentrio.dentista.model.Dentista;

public interface DentistaDao {

    /**
     * M�todo para incluir um dentista
     * 
     * @param Dentista
     */
    public void addDentista(Dentista dentista);

    /**
     * M�todo para editar um dentista
     * 
     * @param dentista
     */
    // public void editDentista(Dentista dentista);

    /**
     * M�todo para listar os dentistas
     * 
     * @return
     */
    // public List<Dentista> listDentistass();

    /**
     * M�todo que recupera e retorna um dentista com o id passado no parametro
     * 
     * @param empid
     * @return
     */
    public Dentista getDentista(Integer dentistaId);

    /**
     * M�todo para Deletar um dentista
     * 
     * @param Dentista
     */
    public void deletarDentista(Dentista dentista);

}
