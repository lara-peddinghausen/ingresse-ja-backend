package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.CupomDao;
import br.senac.rj.backend.entity.Cupom;

import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Cupom.
 */
public class CupomService {
    private final CupomDao dao = new CupomDao();

    public Response salvar(Cupom cupom) {
        Cupom cupomSalvo = dao.salvar(cupom);
        if (cupomSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o cupom.\"}")
            		.build();
        }
        return Response.ok(cupomSalvo).build();
    }

    public Response buscar(Long id) {
        Cupom CupomObtido = dao.buscarPorId(id);
        if (CupomObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Cupom não encontrado.\"}")
            		.build();
        }
        return Response.ok(CupomObtido).build();
    }
}
