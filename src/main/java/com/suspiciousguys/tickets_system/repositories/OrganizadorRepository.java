package com.suspiciousguys.tickets_system.repositories;

import com.suspiciousguys.tickets_system.models.OrganizadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizadorRepository extends JpaRepository<OrganizadorModel, Long> {
}
