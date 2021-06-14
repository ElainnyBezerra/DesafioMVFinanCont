package dao;

import java.util.List;

import entidade.Conta;

public interface ContaDao {

	public void salvar(Conta conta);

	public void alterar(Conta conta);

	public void remover(int numero);

	public Conta pesquisar(Conta conta);

	public List<Conta> listarTodos();

}
