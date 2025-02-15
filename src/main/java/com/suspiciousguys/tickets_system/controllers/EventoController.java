package com.suspiciousguys.tickets_system.controllers;

import com.suspiciousguys.tickets_system.dtos.EventoDTO;
import com.suspiciousguys.tickets_system.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<EventoDTO> create(@RequestBody @Valid EventoDTO eventoDTO) {
        this.eventoService.create(eventoDTO);
        return ResponseEntity.ok().header("message","Evento criado com sucesso.").build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> update(@PathVariable Long id, @RequestBody @Valid EventoDTO eventoDTO) {
        this.eventoService.update(eventoDTO,id);
        return ResponseEntity.ok().header("message","Evento atualizado com sucesso.").build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.eventoService.delete(id);
        return ResponseEntity.ok().header("message","Evento removido com sucesso.").build();
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> getAll() {
        return ResponseEntity.ok().body(this.eventoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.eventoService.getById(id));
    }
}
