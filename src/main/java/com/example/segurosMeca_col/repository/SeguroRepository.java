package com.example.segurosMeca_col.repository;

import com.example.segurosMeca_col.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

    Optional<Seguro> findByIdSeguros(String idSeguros);
    List<Seguro> findByCompania(String compania);
    List<Seguro> findByVehiculo_IdVehiculo(Long idVehiculo);
}

