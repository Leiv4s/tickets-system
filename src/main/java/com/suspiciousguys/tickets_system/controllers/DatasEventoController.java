package com.suspiciousguys.tickets_system.controllers;

import com.suspiciousguys.tickets_system.dtos.DatasEventoDTO;
import com.suspiciousguys.tickets_system.models.DatasEventoModel;
import com.suspiciousguys.tickets_system.services.DatasEventoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datasevento")
public class DatasEventoController {
    private final DatasEventoService datasEventoService;

    public DatasEventoController(final DatasEventoService datasEventoService) {
        this.datasEventoService = datasEventoService;
    }

    @PostMapping
    public ResponseEntity<DatasEventoModel> create(@RequestBody @Valid DatasEventoDTO datasEventoDTO) {
        DatasEventoModel newDatasEvento = new DatasEventoModel(datasEventoDTO);
        datasEventoService.create(newDatasEvento);
        return ResponseEntity.ok(newDatasEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatasEventoModel> update(@PathVariable Long id, @RequestBody @Valid DatasEventoDTO datasEventoDTO) {
        DatasEventoModel oldDatasEvento = datasEventoService.findById(id);
        DatasEventoModel newDatasEvento = new DatasEventoModel(datasEventoDTO);
        newDatasEvento.setId(oldDatasEvento.getId());
        datasEventoService.update(newDatasEvento);
        return ResponseEntity.ok(newDatasEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DatasEventoModel> delete(@PathVariable Long id) {
        DatasEventoModel datasEvento = datasEventoService.findById(id);

        if (datasEvento == null) {
            return ResponseEntity.notFound().build();
        };
        datasEventoService.delete(datasEvento);
        return ResponseEntity.ok(datasEvento);
    }

    @GetMapping
    public ResponseEntity<List<DatasEventoModel>> findAll() {
        List<DatasEventoModel> allDatas = datasEventoService.findAll();
        return ResponseEntity.ok(allDatas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatasEventoModel> findById(@PathVariable final Long id) {
        DatasEventoModel datasEvento = datasEventoService.findById(id);
        return ResponseEntity.ok(datasEvento);
    }




}
