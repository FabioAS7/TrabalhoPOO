package service;

import java.util.List;

import model.Agendamento;

public interface AgendamentoDAO {

    public void inserir(Agendamento objeto) throws Exception;

	public void atualizar(Agendamento objeto) throws Exception;

	public void remover(Agendamento objeto) throws Exception;

	public List<Agendamento> pesquisar(String itemPesquisa) throws Exception;

	public List<Agendamento> pesquisarTodos() throws Exception;

}
