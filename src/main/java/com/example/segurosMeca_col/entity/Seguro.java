package com.example.segurosMeca_col.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguro;

    @Column(nullable = false, length = 100)
    private String compania;

    @Column(nullable = false, length = 100)
    private String numeroPoliza;

    @Column (nullable = false,length = 100)
    private String fechaInicio;

    @Column (nullable = false,length = 100)
    private String fechaVencimiento;

    @OneToOne
    @JoinColumn(name = "idVehiculo", nullable = false)
    private Vehiculo vehiculo;

}
