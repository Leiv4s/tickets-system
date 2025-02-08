package com.suspiciousguys.tickets_system.repositories;

import com.suspiciousguys.tickets_system.models.DatasEventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasEventoRepository extends JpaRepository<DatasEventoModel, Long> {
}
