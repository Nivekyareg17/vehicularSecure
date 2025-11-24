package com.example.segurosMeca_col.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguro;

    @Column(nullable = false, length = 100)
    private String id_Seguro;

    @Column(nullable = false, length = 100)
    private String compania;

    @Column(nullable = false, length = 100)
    private String numeroPoliza;

    @Column (nullable = false,length = 100)
    private String fechaInicio;

    @Column (nullable = false,length = 100)
    private String fechaVencimiento;

}
