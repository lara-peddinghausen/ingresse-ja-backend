package br.senac.rj.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author reinaldo.jose
 * Entidade que representa a tabela cupom.
 */
@Entity
@Table(name = "cupom")
@Data
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cupomId;

    @Column(length = 80, nullable = false)
    private String cupomNome;
    
    @Column(length = 80, nullable = false)
    private float valorDesconto;

    @ManyToOne
    @JoinColumn(name = "eventoId")
    private Evento evento;
}
