package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.EnderecoDao;
import entidade.Endereco;
import util.JpaUtil;

public class EnderecoDaoImpl implements EnderecoDao {

	private EntityManager em;
	private EntityTransaction et;

	public void salvar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(endereco);
			et.commit();
			System.out.println("Cadastro realizado com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Cadastro n?o realizado! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public void alterar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(endereco);
			et.commit();
			System.out.println("Altera??o realizada com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Altera??o n?o realizada! Favor verificar as informa??es. ");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public void remover(int id) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Endereco.class, id));
			et.commit();
			System.out.println("Exclus?o realizada com sucesso!");
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Exclus?o n?o realizada! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public Endereco pesquisar(Endereco endereco) {

		try {
			this.em = JpaUtil.getEntityManager();
			endereco = em.find(Endereco.class, endereco.getIdEndereco());
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Endere?o n?o localizado! Favor verificar as informa??es.");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return endereco;
	}

	public List<Endereco> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Endereco e");
		List<Endereco> listaEndereco = query.getResultList();
		em.close();
		return listaEndereco;
	}

}
