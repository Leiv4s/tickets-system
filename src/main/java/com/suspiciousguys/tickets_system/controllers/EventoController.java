package com.suspiciousguys.tickets_system.controllers;

import com.suspiciousguys.tickets_system.dtos.EventoDTO;
import com.suspiciousguys.tickets_system.models.EventoModel;
import com.suspiciousguys.tickets_system.models.OrganizadorModel;
import com.suspiciousguys.tickets_system.services.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/eventos")
@RestController
public class EventoController {

    EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<EventoModel> create(@RequestBody EventoDTO eventoDTO) {
        EventoModel newEvento = new EventoModel(eventoDTO);
        eventoService.create(newEvento);
        return ResponseEntity.ok().body(newEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoModel> update(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
        EventoModel oldEvento = eventoService.findById(id);
        if (oldEvento == null) {
            return ResponseEntity.notFound().build();
        }
        EventoModel newEvento = new EventoModel(eventoDTO);
        newEvento.setId(oldEvento.getId());
        this.eventoService.update(newEvento);
        return ResponseEntity.ok().body(newEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventoModel> delete(@PathVariable Long id) {
        EventoModel evento = eventoService.findById(id);
        System.out.println("AQUIIIIIIIIIIIIIIIIII__________________________________________");
        System.out.println(evento.toString());
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        this.eventoService.delete(evento);
        return ResponseEntity.ok().body(evento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoModel> findById(@PathVariable Long id) {
        EventoModel evento = eventoService.findById(id);
        return ResponseEntity.ok().body(evento);
    }

    @GetMapping
    public ResponseEntity<List<EventoModel>> findAll() {
        List<EventoModel> eventoModels = eventoService.findAll();
        return ResponseEntity.ok().body(eventoModels);
    }
}
