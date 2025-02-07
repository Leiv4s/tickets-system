package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String login;

    @Column(nullable = false, length = 255)
    private String senha;


}
