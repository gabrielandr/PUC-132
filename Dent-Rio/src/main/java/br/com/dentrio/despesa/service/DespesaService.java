package br.com.dentrio.despesa.service;

import java.util.List;

import br.com.dentrio.model.Despesa;

public interface DespesaService {

	public void addDespesa(Despesa despesa);

	public void editDespesa(Despesa despesa);

	public List<Despesa> listDespesas();

	public Despesa getDespesa(Integer despesaId);

	public void deletarDespesa(Despesa despesa);

}
