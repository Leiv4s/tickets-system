package com.suspiciousguys.tickets_system.dtos;

import com.suspiciousguys.tickets_system.models.ClienteModel;
import com.suspiciousguys.tickets_system.models.CompraModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Set<Long> comprasIds; // Apenas os IDs das compras, evitando expor objetos inteiros

    public ClienteDTO(ClienteModel clienteModel) {
        this.id = clienteModel.getId();
        this.nome = clienteModel.getNome();
        this.login = clienteModel.getLogin();
        this.email = clienteModel.getEmail();
        this.senha = clienteModel.getSenha();
        if (clienteModel.getCompras() != null) {
            this.comprasIds = clienteModel.getCompras().stream()
                    .map(CompraModel::getId)
                    .collect(Collectors.toSet());
        } else {
            this.comprasIds = Set.of(); // Retorna um conjunto vazio caso o cliente não tenha compras
        }
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
