package com.cipriano.demo.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Prestamo {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private boolean devuelto = false;

  @ManyToOne private Libro libro;
  @ManyToOne private Usuario usuario;
}
