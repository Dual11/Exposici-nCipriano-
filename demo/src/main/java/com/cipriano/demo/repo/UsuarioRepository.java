package com.cipriano.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cipriano.demo.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
