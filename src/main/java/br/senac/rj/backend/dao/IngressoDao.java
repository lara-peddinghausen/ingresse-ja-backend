package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Ingresso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class IngressoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Ingresso salvar(Ingresso ingresso) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Ingresso IngressoSalvo = em.merge(ingresso); // obter objeto completo salvo
			em.getTransaction().commit();
			return IngressoSalvo;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // desfazer transações pendentes
			}
			e.printStackTrace(); // Para depuração
			return null;
		} finally {
			em.close();
		}
	}

	public Ingresso buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Ingresso.class, id);
		} finally {
			em.close();
		}
	}
}
