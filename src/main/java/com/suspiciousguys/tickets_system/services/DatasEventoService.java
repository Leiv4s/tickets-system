package com.suspiciousguys.tickets_system.services;

import com.suspiciousguys.tickets_system.models.DatasEventoModel;
import com.suspiciousguys.tickets_system.repositories.DatasEventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasEventoService {

    private final DatasEventoRepository datasEventoRepository;

    DatasEventoService(DatasEventoRepository datasEventoRepository) {
        this.datasEventoRepository = datasEventoRepository;
    }

    public void create(DatasEventoModel datasEventoModel) {
        datasEventoRepository.save(datasEventoModel);
    }

    public void update(DatasEventoModel datasEventoModel) {
        datasEventoRepository.save(datasEventoModel);
    }

    public void delete(DatasEventoModel datasEventoModel) {
        datasEventoRepository.delete(datasEventoModel);
    }

    public List<DatasEventoModel> findAll(){
        return datasEventoRepository.findAll();
    }

    public DatasEventoModel findById(Long id) {
        return datasEventoRepository.findById(id).orElseThrow(()-> new RuntimeException("Nenhum evento a exibir."));
    }


}
