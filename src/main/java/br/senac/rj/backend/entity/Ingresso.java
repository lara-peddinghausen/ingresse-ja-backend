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
 * Entidade que representa a tabela ingresso.
 */
@Entity
@Table(name = "ingresso")
@Data
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingressoId;

    @Column(length = 80, nullable = false)
    private String tipoIngresso;
    
    @Column(nullable = false)
    private float valorIngresso;   // << NOVO ATRIBUTO

    @ManyToOne
    @JoinColumn(name = "eventoId", nullable = false)
    private Evento evento;
}
