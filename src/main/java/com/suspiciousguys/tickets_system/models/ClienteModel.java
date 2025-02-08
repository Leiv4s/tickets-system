package com.suspiciousguys.tickets_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suspiciousguys.tickets_system.dtos.ClienteDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@Table(name = "cliente")
public class ClienteModel extends UsuarioModel {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CompraModel> compras = new HashSet<>();

    public ClienteModel(ClienteDTO clienteDTO){
        this.setId(clienteDTO.getId());
        this.setNome(clienteDTO.getNome());
        this.setLogin(clienteDTO.getLogin());
        this.setEmail(clienteDTO.getEmail());
        this.setSenha(clienteDTO.getSenha());
    }
}
