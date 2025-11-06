package com.cipriano.demo.web;

import com.cipriano.demo.domain.Prestamo;
import com.cipriano.demo.repo.LibroRepository;
import com.cipriano.demo.repo.PrestamoRepository;
import com.cipriano.demo.repo.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {
    private final PrestamoRepository repo;
    private final LibroRepository libroRepo;
    private final UsuarioRepository usuarioRepo;

    public PrestamoController(PrestamoRepository repo, LibroRepository libroRepo, UsuarioRepository usuarioRepo) {
        this.repo = repo; this.libroRepo = libroRepo; this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public List<Prestamo> list(@RequestParam(required=false) Long usuarioId){
        return (usuarioId!=null) ? repo.findByUsuario_Id(usuarioId) : repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Prestamo> crear(@RequestParam Long usuarioId, @RequestParam Long libroId){
        var libro = libroRepo.findById(libroId).orElse(null);
        var usuario = usuarioRepo.findById(usuarioId).orElse(null);
        if (libro==null || usuario==null || !libro.isDisponible()) return ResponseEntity.badRequest().build();
        libro.setDisponible(false);
        var p = Prestamo.builder().libro(libro).usuario(usuario).fechaInicio(LocalDate.now()).build();
        return ResponseEntity.ok(repo.save(p));
    }

    @PatchMapping("/{id}/devolver")
    public ResponseEntity<Prestamo> devolver(@PathVariable Long id){
        return repo.findById(id).map(p -> {
            p.setDevuelto(true);
            p.setFechaFin(LocalDate.now());
            p.getLibro().setDisponible(true);
            return ResponseEntity.ok(repo.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }
}
