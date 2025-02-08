package com.suspiciousguys.tickets_system.repositories;

import com.suspiciousguys.tickets_system.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
