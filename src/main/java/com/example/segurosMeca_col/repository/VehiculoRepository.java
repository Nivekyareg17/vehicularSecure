package com.example.segurosMeca_col.repository;

import com.example.segurosMeca_col.entity.Vehiculo;
import com.example.segurosMeca_col.entity.VehiculoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {


    Optional<Vehiculo> findByPlaca(String placa);
    List<Vehiculo> findByTipoVehiculo(VehiculoType tipoVehiculo);




}
