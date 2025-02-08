package com.suspiciousguys.tickets_system.dtos;

import com.suspiciousguys.tickets_system.models.OrganizadorModel;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizadorDTO {
    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    OrganizadorDTO(OrganizadorModel organizadorModel) {
        this.id = organizadorModel.getId();
        this.nome = organizadorModel.getNome();
        this.login = organizadorModel.getLogin();
        this.email = organizadorModel.getEmail();
        this.senha = organizadorModel.getSenha();
    }

}
