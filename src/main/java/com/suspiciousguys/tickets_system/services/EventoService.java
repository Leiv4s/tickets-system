package com.suspiciousguys.tickets_system.services;

import com.suspiciousguys.tickets_system.models.EventoModel;
import com.suspiciousguys.tickets_system.repositories.EventoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService (EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void create(EventoModel eventoModel) {
        eventoRepository.save(eventoModel);
    }

    public void update(EventoModel eventoModel) {
        eventoRepository.save(eventoModel);
    }

    public void delete(EventoModel eventoModel) {
        System.out.println(eventoModel);
        this.eventoRepository.delete(eventoModel);
    }

    public List<EventoModel> findAll() {
        return eventoRepository.findAll();
    }

    public EventoModel findById(Long id) {
        return eventoRepository.findById(id).get();
    }


}
