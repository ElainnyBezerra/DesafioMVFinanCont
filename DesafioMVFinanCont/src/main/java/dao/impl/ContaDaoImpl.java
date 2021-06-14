package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import dao.ContaDao;
import entidade.Conta;
import util.JpaUtil;

public class ContaDaoImpl implements ContaDao {

	private EntityManager em;
	private EntityTransaction et;

	public void salvar(Conta conta) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(conta);
			et.commit();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Cadastro não realizado! Favor verificar as informações.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public void alterar(Conta conta) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(conta);
			et.commit();
			System.out.println("Alteração realizada com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Alteração não realizada! Favor verificar as informações.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public void remover(int numero) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Conta.class, numero));
			et.commit();
			System.out.println("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Exclusão não realizada! Favor verificar as informações.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public Conta pesquisar(Conta conta) {
		int idCli = conta.getCliente().getIdCliente();
		try {
			this.em = JpaUtil.getEntityManager();
			StoredProcedureQuery query = em.createStoredProcedureQuery("BUSCA_CONTA")
					.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
					.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT)
					.setParameter(1, conta.getNumero()).setParameter(2, idCli);

			query.execute();

			int idConta = (int) query.getOutputParameterValue(3);
			conta = em.find(Conta.class, idConta);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Conta não localizada! Favor verificar as informações.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return conta;
	}

	public List<Conta> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Conta e");
		List<Conta> listaConta = query.getResultList();
		em.close();
		return listaConta;
	}

}
