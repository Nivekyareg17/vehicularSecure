package com.example.segurosMeca_col.repository;

import com.example.segurosMeca_col.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByidConductor(Long id);
    Optional<Conductor> findByNombre(String nombre);
    List<Conductor> findByActivo(Boolean activo);


}
