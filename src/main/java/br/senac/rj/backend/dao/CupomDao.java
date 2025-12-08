package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Cupom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CupomDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Cupom salvar(Cupom cupom) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Cupom CupomSalvo = em.merge(cupom); // obter objeto completo salvo
			em.getTransaction().commit();
			return CupomSalvo;
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

	public Cupom buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Cupom.class, id);
		} finally {
			em.close();
		}
	}
}
