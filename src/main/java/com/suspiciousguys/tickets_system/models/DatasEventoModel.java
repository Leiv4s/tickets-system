package com.suspiciousguys.tickets_system.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.suspiciousguys.tickets_system.dtos.DatasEventoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "datasEvento")
public class DatasEventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "datasEvento", fetch = FetchType.LAZY)
    private Set<EventoModel> eventos = new HashSet<>();

    public DatasEventoModel(DatasEventoDTO datasEventoDTO) {
        this.data = datasEventoDTO.getData();
        this.id = datasEventoDTO.getId();
    }

}
