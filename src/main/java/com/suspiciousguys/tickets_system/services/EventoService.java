package com.suspiciousguys.tickets_system.services;

import com.suspiciousguys.tickets_system.dtos.EventoDTO;
import com.suspiciousguys.tickets_system.models.EventoModel;
import com.suspiciousguys.tickets_system.repositories.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void create(EventoDTO eventoDTO) {
        EventoModel evento = new EventoModel(eventoDTO);
        eventoRepository.save(evento);
    }

    public EventoDTO update(EventoDTO eventoDTO, Long id) {
        EventoModel oldEvento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        EventoModel newEvento = new EventoModel(eventoDTO);
        newEvento.setId(oldEvento.getId());
        eventoRepository.save(newEvento);
        return new EventoDTO(newEvento);
    }

    public void delete(Long id) {
        EventoModel Evento = this.eventoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
        if (Evento != null) {
            this.eventoRepository.delete(Evento);
        }
    }

    public List<EventoDTO> getAll() {
        List<EventoModel> eventos = this.eventoRepository.findAll();
        return eventos.stream().map(EventoDTO::new).toList();
    }

    public EventoDTO getById(Long id) {
        EventoModel eventoModel = this.eventoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
        return new EventoDTO(eventoModel);
    }
}
