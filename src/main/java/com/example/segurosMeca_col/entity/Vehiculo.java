package com.example.segurosMeca_col.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    @Column(nullable = false, length = 20)
    private String placa;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 50)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehiculoType tipoVehiculo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehiculoTypeC tipoGVehiculo;

    @OneToOne
    @JoinColumn(name = "idConductor",referencedColumnName = "idConductor", nullable = false)
    private Conductor conductor;

}
