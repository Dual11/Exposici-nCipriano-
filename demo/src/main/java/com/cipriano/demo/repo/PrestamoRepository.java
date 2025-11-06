package com.cipriano.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cipriano.demo.domain.Prestamo;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // Buscar préstamos por usuario
    List<Prestamo> findByUsuario_Id(Long usuarioId);
}
