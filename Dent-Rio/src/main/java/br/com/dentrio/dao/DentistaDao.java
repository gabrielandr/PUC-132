package br.com.dentrio.dao;

import java.util.List;

import br.com.dentrio.model.Dentista;

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
    public void editarDentista(Dentista dentista);

    /**
     * M�todo para listar os dentistas
     * 
     * @return
     */
    public List<Dentista> listDentistas();

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
