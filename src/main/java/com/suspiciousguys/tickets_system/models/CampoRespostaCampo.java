package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "campoRespostaCampo")
public class CampoRespostaCampo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idrespostaCampo", nullable = false)
    private RespostaCampo respostaCampo;

    @ManyToOne
    @JoinColumn(name = "idcampo", nullable = false)
    private Campo campo;
}
