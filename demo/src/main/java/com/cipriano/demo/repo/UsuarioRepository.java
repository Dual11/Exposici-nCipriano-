package com.cipriano.demo.repo;
import com.cipriano.demo.domain.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuario_Id(Long usuarioId);
}
