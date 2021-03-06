package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import dao.ClienteDao;
import entidade.Cliente;
import util.JpaUtil;

public class ClienteDaoImpl implements ClienteDao {

	private EntityManager em;
	private EntityTransaction et;

	public void salvar(Cliente cliente) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(cliente);
			et.commit();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Cadastro n?o realizado! Favor verificar informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public void alterar(Cliente cliente) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(cliente);
			et.commit();
			System.out.println("Altera??o realizada com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Altera??o n?o realizada! Favor verificar informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public void remover(Cliente cliente) {
		int idCliente = 0;
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			if (cliente.getRg() != null) {
				StoredProcedureQuery query = em.createStoredProcedureQuery("BUSCA_CLIENTE_CPF")
						.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT)
						.setParameter(1, cliente.getCpfCnpj()).setParameter(2, cliente.getRg());

				query.execute();

				idCliente = (int) query.getOutputParameterValue(3);
			} else {
				StoredProcedureQuery query = em.createStoredProcedureQuery("BUSCA_CLIENTE_CNPJ")
						.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT)
						.setParameter(1, cliente.getCpfCnpj()).setParameter(2, cliente.getIe());

				query.execute();

				idCliente = (int) query.getOutputParameterValue(3);
			}

			em.remove(em.find(Cliente.class, idCliente));
			et.commit();
			System.out.println("Exclus?o realizada com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Exclus?o n?o realizada! Favor verificar informa??es!");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public Cliente pesquisar(Cliente cliente) {

		int idCliente = 0;

		try {
			this.em = JpaUtil.getEntityManager();
			if (cliente.getRg() != null) {
				StoredProcedureQuery query = em.createStoredProcedureQuery("BUSCA_CLIENTE_CPF")
						.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT)
						.setParameter(1, cliente.getCpfCnpj()).setParameter(2, cliente.getRg());

				query.execute();

				idCliente = (int) query.getOutputParameterValue(3);
			} else {
				StoredProcedureQuery query = em.createStoredProcedureQuery("BUSCA_CLIENTE_CNPJ")
						.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
						.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT)
						.setParameter(1, cliente.getCpfCnpj()).setParameter(2, cliente.getIe());

				query.execute();

				idCliente = (int) query.getOutputParameterValue(3);
			}
			cliente = em.find(Cliente.class, idCliente);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Cliente n?o localizado! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return cliente;
	}

	public List<Cliente> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Cliente e");
		List<Cliente> listaCliente = query.getResultList();
		em.close();
		return listaCliente;
	}

}
