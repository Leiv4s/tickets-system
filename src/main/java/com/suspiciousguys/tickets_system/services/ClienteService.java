package com.suspiciousguys.tickets_system.services;

import com.suspiciousguys.tickets_system.dtos.ClienteDTO;
import com.suspiciousguys.tickets_system.models.ClienteModel;
import com.suspiciousguys.tickets_system.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void create(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = new ClienteModel(clienteDTO);
        this.clienteRepository.save(clienteModel);
    }

    public void update(ClienteDTO clienteDTO, Long id) {
        ClienteModel newCliente = new ClienteModel(clienteDTO);
        ClienteModel oldCliente = this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        if (oldCliente != null) {
//            newCliente.setCompras((Set<CompraModel>) compraRepository.findAllById(Collections.singleton(id)));
            newCliente.setId(oldCliente.getId());
            this.clienteRepository.save(newCliente);
        }
    }

    public void delete(Long id) {
        ClienteModel cliente = this.clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));;
        if (cliente != null) {
            this.clienteRepository.delete(cliente);
        }
    }

    public List<ClienteDTO> findAll() {
        List<ClienteModel> list = this.clienteRepository.findAll();
        return list.stream().map(ClienteDTO::new).toList();
    }

    public ClienteDTO findById(Long id) {
        return new ClienteDTO(this.clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."))
        );
    }


}
