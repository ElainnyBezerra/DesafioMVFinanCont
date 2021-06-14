package dao;

import java.util.List;

import entidade.Cliente;

public interface ClienteDao {

	public void salvar(Cliente cliente);

	public void alterar(Cliente cliente);

	public void remover(Cliente cliente);

	public Cliente pesquisar(Cliente cliente);

	public List<Cliente> listarTodos();

}
