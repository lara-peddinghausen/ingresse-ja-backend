package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.IngressoDao;
import br.senac.rj.backend.entity.Ingresso;

import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Ingresso.
 */
public class IngressoService {
    private final IngressoDao dao = new IngressoDao();

    public Response salvar(Ingresso ingresso) {
        Ingresso ingressoSalvo = dao.salvar(ingresso);
        if (ingressoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o ingresso.\"}")
            		.build();
        }
        return Response.ok(ingressoSalvo).build();
    }

    public Response buscar(Long id) {
        Ingresso IngressoObtido = dao.buscarPorId(id);
        if (IngressoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Ingresso não encontrado.\"}")
            		.build();
        }
        return Response.ok(IngressoObtido).build();
    }
}
