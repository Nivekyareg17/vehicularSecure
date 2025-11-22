package com.example.segurosMeca_col.service;

import com.example.segurosMeca_col.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    Vehiculo registerVehiculo(Vehiculo vehiculo);
    List<Vehiculo> ListVehiculo();
    Optional<Vehiculo> searchVehiculoByPlaca(String placa) throws Exception;

    Vehiculo updateVehiculoById(Long idVehiculo, Vehiculo vehiculo);

    void deleteVehiculo(Long idVehiculo) throws Exception;

    Optional<Vehiculo> searchPlaca(String placa);

}

