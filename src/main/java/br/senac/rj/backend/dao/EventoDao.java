package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Evento salvar(Evento evento) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Evento EventoSalvo = em.merge(evento); // obter objeto completo salvo
			em.getTransaction().commit();
			return EventoSalvo;
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

	public Evento buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Evento.class, id);
		} finally {
			em.close();
		}
	}
}
