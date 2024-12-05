package service;

import java.util.List;
import model.Doador;

public interface DoadorDAO {

    public void inserir(Doador objeto) throws Exception;

	public void atualizar(Doador objeto) throws Exception;

	public void remover(Doador objeto) throws Exception;

	public List<Doador> pesquisar(String itemPesquisa) throws Exception;

	public List<Doador> pesquisarTodos() throws Exception;

}
