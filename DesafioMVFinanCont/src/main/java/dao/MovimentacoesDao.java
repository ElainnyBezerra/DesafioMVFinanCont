package dao;

import java.util.List;

import entidade.Movimentacoes;

public interface MovimentacoesDao {

	public void salvar(Movimentacoes movimentacoes);

	public Movimentacoes pesquisar(Movimentacoes movimentacoes);

	public int idMov(Movimentacoes movimentacoes, int qtMov);

	public List<Movimentacoes> listarTodos();

}
