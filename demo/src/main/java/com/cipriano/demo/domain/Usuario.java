package com.cipriano.demo.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String email;
  @Enumerated(EnumType.STRING)
  private Rol rol;

  public enum Rol { ADMIN, LECTOR }
}
