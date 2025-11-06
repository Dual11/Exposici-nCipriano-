package com.cipriano.demo.web;

import com.cipriano.demo.domain.Libro;
import com.cipriano.demo.repo.LibroRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    private final LibroRepository repo;
    public LibroController(LibroRepository repo){ this.repo = repo; }

    @GetMapping
    public List<Libro> list(@RequestParam(required=false) String titulo,
                            @RequestParam(required=false) Long autorId,
                            @RequestParam(required=false) Long categoriaId){
        if (titulo != null) return repo.findByTituloContainingIgnoreCase(titulo);
        if (autorId != null) return repo.findByAutor_Id(autorId);
        if (categoriaId != null) return repo.findByCategoria_Id(categoriaId);
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> get(@PathVariable Long id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Libro create(@RequestBody @Valid Libro libro){ return repo.save(libro); }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro in){
        return repo.findById(id).map(db -> {
            db.setTitulo(in.getTitulo());
            db.setIsbn(in.getIsbn());
            db.setAnioPublicacion(in.getAnioPublicacion());
            db.setDisponible(in.isDisponible());
            db.setAutor(in.getAutor());
            db.setCategoria(in.getCategoria());
            return ResponseEntity.ok(repo.save(db));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}
