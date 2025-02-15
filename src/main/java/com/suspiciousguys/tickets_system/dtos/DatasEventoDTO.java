package com.suspiciousguys.tickets_system.dtos;

import com.suspiciousguys.tickets_system.models.DatasEventoModel;
import com.suspiciousguys.tickets_system.models.EventoModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class DatasEventoDTO {

    private Long id;
    private LocalDate data;
    private Set<Long> eventosIds;

    DatasEventoDTO(DatasEventoModel datasEventoModel){
        BeanUtils.copyProperties(datasEventoModel, this);
        if (!datasEventoModel.getEventos().isEmpty()){
            this.eventosIds = datasEventoModel.getEventos().stream().map(EventoModel::getId).collect(Collectors.toSet());
        } else {
            this.eventosIds = Set.of();
        }

    }
}
