package com.suspiciousguys.tickets_system.controllers;

import com.suspiciousguys.tickets_system.dtos.OrganizadorDTO;
import com.suspiciousguys.tickets_system.models.OrganizadorModel;
import com.suspiciousguys.tickets_system.services.OrganizadorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/organizadores")
@RestController
public class OrganizadorController {

    private final OrganizadorService organizadorService;

    public OrganizadorController(OrganizadorService organizadorService) {
        this.organizadorService = organizadorService;
    }

    @PostMapping
    public ResponseEntity<OrganizadorModel> create(@RequestBody @Valid OrganizadorDTO organizadorDTO) {
        OrganizadorModel organizador = new OrganizadorModel(organizadorDTO);
        this.organizadorService.create(organizador);
        return ResponseEntity.ok().body(organizador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizadorModel> update (@PathVariable Long id, @RequestBody @Valid OrganizadorDTO organizadorDTO) {
        OrganizadorModel organizadorNow = organizadorService.findById(id);
        if (organizadorNow == null) {
            return ResponseEntity.notFound().build();
        }
        OrganizadorModel organizador = new OrganizadorModel(organizadorDTO);
        organizador.setId(id);
        this.organizadorService.update(organizador);
        return ResponseEntity.ok().body(organizador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrganizadorModel> delete (@PathVariable Long id) {
        OrganizadorModel organizador = organizadorService.findById(id);
        if (organizador == null) {
            return ResponseEntity.notFound().build();
        }
        this.organizadorService.delete(organizador);
        return ResponseEntity.ok().body(organizador);
    }

    @GetMapping
    public List<OrganizadorModel> findAll(){
        return this.organizadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorModel> findById(@PathVariable Long id){
        OrganizadorModel organizador = organizadorService.findById(id);
        return ResponseEntity.ok().body(organizador);
    }



}
