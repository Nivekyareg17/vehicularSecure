package com.example.segurosMeca_col.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConductor;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column (nullable = false, length = 100)
    private String licencia;

    @Column (nullable = false, length = 11)
    private String telefono;

    @Column (nullable = false, length = 100)
    private String direccion;

    @Column (nullable = false)
    private Boolean activo;

}
