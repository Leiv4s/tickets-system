package com.suspiciousguys.tickets_system.dtos;

import com.suspiciousguys.tickets_system.models.ClienteModel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    ClienteDTO(ClienteModel clienteModel) {
        this.id = clienteModel.getId();
        this.nome = clienteModel.getNome();
        this.login = clienteModel.getLogin();
        this.email = clienteModel.getEmail();
        this.senha = clienteModel.getSenha();
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
