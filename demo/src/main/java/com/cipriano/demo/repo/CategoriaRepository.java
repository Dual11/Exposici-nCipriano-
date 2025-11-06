package com.cipriano.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cipriano.demo.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
