package com.cipriano.demo.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Autor {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String pais;

  @OneToMany(mappedBy = "autor")
  private List<Libro> libros;
}
