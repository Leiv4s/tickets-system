package com.suspiciousguys.tickets_system.repositories;

import com.suspiciousguys.tickets_system.models.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoRepository extends JpaRepository<EventoModel, Long> {
}
