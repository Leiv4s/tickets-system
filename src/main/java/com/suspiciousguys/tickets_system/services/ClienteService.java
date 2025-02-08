package com.suspiciousguys.tickets_system.services;

import com.suspiciousguys.tickets_system.models.ClienteModel;
import com.suspiciousguys.tickets_system.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void create(ClienteModel clienteModel) {
        clienteRepository.save(clienteModel);
    }

    public void update(ClienteModel clienteModel) {
        this.clienteRepository.save(clienteModel);
    }

    public void delete(ClienteModel clienteModel) {
        this.clienteRepository.delete(clienteModel);
    }

    public List<ClienteModel> findAll() {
        return this.clienteRepository.findAll();
    }

    public ClienteModel findById(Long id) {
        return this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }


}
