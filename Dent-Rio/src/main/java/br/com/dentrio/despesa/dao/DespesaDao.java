package br.com.dentrio.despesa.dao;

import java.util.List;

import br.com.dentrio.model.Despesa;

public interface DespesaDao {

	public void addDespesa(Despesa despesa);

	public void editarDespesa(Despesa despesa);

	public List<Despesa> listDespesas();

	public Despesa getDespesa(Integer despesaId);

	public void deletarDespesa(Despesa despesa);

}
