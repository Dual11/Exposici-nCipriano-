package com.cipriano.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cipriano.demo.domain.Libro;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar por título (coincidencia parcial, sin mayúsculas)
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    // Buscar todos los libros de un autor
    List<Libro> findByAutor_Id(Long autorId);

    // Buscar todos los libros de una categoría
    List<Libro> findByCategoria_Id(Long categoriaId);
}
