package br.com.dentrio.service;

import java.util.List;

import br.com.dentrio.model.Dentista;

public interface DentistaService {

    /**
     * Mï¿½todo para incluir um dentista
     * 
     * @param Dentista
     */
    public void addDentista(Dentista dentista);

    /**
     * Mï¿½todo para editar um dentista
     * 
     * @param dentista
     */
    // public void editDentista(Dentista dentista);

    /**
     * Método para listar os dentistas
     *
     * @return
     */
    public List<Dentista> listDentistas();

    /**
     * Mï¿½todo que recupera e retorna um dentista com o id passado no parametro
     *
     * @param empid
     * @return
     */
    public Dentista getDentista(Integer dentistaId);

    /**
     * Mï¿½todo para Deletar um dentista
     *
     * @param Dentista
     */
    public void deletarDentista(Dentista dentista);

}
