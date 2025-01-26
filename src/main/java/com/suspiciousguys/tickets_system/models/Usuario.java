package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String login;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(nullable = false, unique = true, length = 50)
    private String identificador;

    @OneToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "id", unique = true)
    private Cliente cliente;
}
