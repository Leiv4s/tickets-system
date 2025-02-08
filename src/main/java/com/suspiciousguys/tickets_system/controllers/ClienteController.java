package com.suspiciousguys.tickets_system.controllers;

import com.suspiciousguys.tickets_system.dtos.ClienteDTO;
import com.suspiciousguys.tickets_system.models.ClienteModel;
import com.suspiciousguys.tickets_system.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> create(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteModel clienteModel = new ClienteModel(clienteDTO);
        this.clienteService.create(clienteModel);
        return ResponseEntity.ok().body(clienteModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> update(@RequestBody @Valid ClienteDTO clienteDTO, @PathVariable Long id) {
        ClienteModel clienteModel = new ClienteModel(clienteDTO);
        ClienteModel clienteModelUpdated = this.clienteService.findById(id);
        if (clienteModelUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        clienteModel.setId(clienteModelUpdated.getId());
        System.out.println(clienteModel.getId());
        this.clienteService.update(clienteModel);
        return ResponseEntity.ok().body(clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteModel> deleteById(@PathVariable Long id) {
        ClienteModel clienteModel = this.clienteService.findById(id);
        this.clienteService.delete(clienteModel);
        return ResponseEntity.ok().body(clienteModel);
    }

    @GetMapping
    public List<ClienteModel> getAll() {
        return this.clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getById(@PathVariable Long id) {
        ClienteModel clienteModel = this.clienteService.findById(id);
        if (clienteModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteModel);
    }
}
