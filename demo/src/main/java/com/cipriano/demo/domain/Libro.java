package com.cipriano.demo.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Libro {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String isbn;
  private Integer anioPublicacion;
  private boolean disponible = true;

  @ManyToOne @JoinColumn(name = "autor_id")
  private Autor autor;

  @ManyToOne @JoinColumn(name = "categoria_id")
  private Categoria categoria;
}
