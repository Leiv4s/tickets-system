package com.suspiciousguys.tickets_system.repositories;

import com.suspiciousguys.tickets_system.dtos.EventoDTO;
import com.suspiciousguys.tickets_system.models.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long> {

    @Query(value = "SELECT * FROM public.evento ORDER BY id ASC", nativeQuery = true)
    List<EventoModel> findAllOrderedNative();

}

