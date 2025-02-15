package com.suspiciousguys.tickets_system.dtos;

import com.suspiciousguys.tickets_system.models.DatasEventoModel;
import com.suspiciousguys.tickets_system.models.EventoModel;
import com.suspiciousguys.tickets_system.models.IngressoModel;
import com.suspiciousguys.tickets_system.models.OrganizadorModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class EventoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalTime horario;
    private String local;
    private Integer capacidadeMax;
    private Set<Long> organizadoresIds;
    private Set<Long> datasEventoIds;
    private Set<Long> ingressosIds;

    public EventoDTO(EventoModel eventoModel) {
        BeanUtils.copyProperties(eventoModel, this);
        if (!eventoModel.getOrganizadores().isEmpty()) {
            this.organizadoresIds = eventoModel.getOrganizadores().stream().map(OrganizadorModel::getId).collect(Collectors.toSet());
        } else {
            this.organizadoresIds = Set.of();
        }

        if (!eventoModel.getDatasEvento().isEmpty()) {
            this.datasEventoIds = eventoModel.getDatasEvento().stream().map(DatasEventoModel::getId).collect(Collectors.toSet());
        } else {
            this.datasEventoIds = Set.of();
        }

        if (!eventoModel.getIngressos().isEmpty()) {
            this.ingressosIds = eventoModel.getIngressos().stream().map(IngressoModel::getId).collect(Collectors.toSet());
        } else {
            this.ingressosIds = Set.of();
        }
    }

}
