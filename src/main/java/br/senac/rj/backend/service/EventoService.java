package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.EventoDao;
import br.senac.rj.backend.entity.Evento;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Evento.
 */
public class EventoService {
    private final EventoDao dao = new EventoDao();

    public Response salvar(Evento evento) {
        Evento eventoSalvo = dao.salvar(evento);
        if (eventoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o evento.\"}")
            		.build();
        }
        return Response.ok(eventoSalvo).build();
    }

    public Response buscar(Long id) {
        Evento EventoObtido = dao.buscarPorId(id);
        if (EventoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Evento não encontrado.\"}")
            		.build();
        }
        return Response.ok(EventoObtido).build();
    }
}
