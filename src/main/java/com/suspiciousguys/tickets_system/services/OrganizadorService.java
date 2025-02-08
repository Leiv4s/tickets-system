package com.suspiciousguys.tickets_system.services;

import com.suspiciousguys.tickets_system.models.OrganizadorModel;
import com.suspiciousguys.tickets_system.repositories.OrganizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class OrganizadorService {
    private final OrganizadorRepository organizadorRepository;

    public OrganizadorService(OrganizadorRepository organizadorRepository) {
        this.organizadorRepository = organizadorRepository;
    }

    public void create(OrganizadorModel organizador) {
        this.organizadorRepository.save(organizador);
    }

    public void update(OrganizadorModel organizador) {
        this.organizadorRepository.save(organizador);
    }

    public void delete(OrganizadorModel organizador) {
        this.organizadorRepository.delete(organizador);
    }

    public OrganizadorModel findById(Long id) {
        return this.organizadorRepository.findById(id).orElseThrow(()->new RuntimeException("organizador não encontrado."));
    }

    public List<OrganizadorModel> findAll() {return this.organizadorRepository.findAll();}



}
