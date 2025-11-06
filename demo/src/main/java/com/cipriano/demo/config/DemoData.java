package com.cipriano.demo.config;

import com.cipriano.demo.domain.*;
import com.cipriano.demo.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DemoData {
    @Bean
    CommandLineRunner initData(AutorRepository autorRepo,
                               CategoriaRepository catRepo,
                               LibroRepository libroRepo,
                               UsuarioRepository usuarioRepo,
                               PrestamoRepository prestamoRepo) {
        return args -> {
            var a1 = autorRepo.save(Autor.builder().nombre("Isaac Asimov").pais("Rusia/EEUU").build());
            var a2 = autorRepo.save(Autor.builder().nombre("Ursula K. Le Guin").pais("EEUU").build());

            var c1 = catRepo.save(Categoria.builder().nombre("Ciencia Ficción").descripcion("Sci-Fi").build());
            var c2 = catRepo.save(Categoria.builder().nombre("Fantasía").descripcion("Fantasy").build());

            var l1 = libroRepo.save(Libro.builder().titulo("Fundación").isbn("978-0-553-80371-0").anioPublicacion(1951).autor(a1).categoria(c1).build());
            var l2 = libroRepo.save(Libro.builder().titulo("La mano izquierda de la oscuridad").isbn("978-0-441-47812-5").anioPublicacion(1969).autor(a2).categoria(c2).build());

            var u1 = usuarioRepo.save(Usuario.builder().nombre("Ana Lectora").email("ana@demo.local").rol(Usuario.Rol.LECTOR).build());
            var u2 = usuarioRepo.save(Usuario.builder().nombre("Admin").email("admin@demo.local").rol(Usuario.Rol.ADMIN).build());

            prestamoRepo.save(Prestamo.builder().libro(l1).usuario(u1).fechaInicio(LocalDate.now().minusDays(2)).build());
        };
    }
}
