package dao;

import java.util.List;

import entidade.Endereco;

public interface EnderecoDao {

	public void salvar(Endereco endereco);

	public void alterar(Endereco endereco);

	public void remover(int id);

	public Endereco pesquisar(Endereco endereco);

	public List<Endereco> listarTodos();

}
