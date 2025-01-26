package com.suspiciousguys.tickets_system.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "datasEvento")
public class DatasEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate data;


    @OneToMany(mappedBy = "dataEvento")
    private Set<EventoDataEvento> eventoDataEvento = new HashSet<>();
}
