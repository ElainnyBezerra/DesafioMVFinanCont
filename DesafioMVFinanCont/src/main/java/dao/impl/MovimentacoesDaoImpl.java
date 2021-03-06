package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import dao.MovimentacoesDao;
import entidade.Movimentacoes;
import util.JpaUtil;

public class MovimentacoesDaoImpl implements MovimentacoesDao {

	private EntityManager em;
	private EntityTransaction et;

	public void salvar(Movimentacoes movimentacoes) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(movimentacoes);
			et.commit();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Cadastro N?o realizado! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public Movimentacoes pesquisar(Movimentacoes movimentacoes) {

		try {
			this.em = JpaUtil.getEntityManager();

			movimentacoes = em.find(Movimentacoes.class, movimentacoes.getIdMovim());
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Movimenta??o n?o localizada! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return movimentacoes;
	}

	public int idMov(Movimentacoes movimentacoes, int qtMov) {

		try {
			this.em = JpaUtil.getEntityManager();

			StoredProcedureQuery query = em.createStoredProcedureQuery("BUSCA_MOV")
					.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
					.registerStoredProcedureParameter(3, int.class, ParameterMode.OUT)
					.setParameter(1, movimentacoes.getCliente().getIdCliente())
					.setParameter(2, movimentacoes.getConta().getIdConta());

			query.execute();

			qtMov = (int) query.getOutputParameterValue(3);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Movimenta??o n?o localizada! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return qtMov;
	}

	public List<Movimentacoes> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Movimentacoes e");
		List<Movimentacoes> listaMovimentacoes = query.getResultList();
		em.close();
		return listaMovimentacoes;
	}

}
