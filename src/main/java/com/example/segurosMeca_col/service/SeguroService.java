package com.example.segurosMeca_col.service;

import com.example.segurosMeca_col.entity.Seguro;
import com.example.segurosMeca_col.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface SeguroService {

    //Buscar Seguro
    List<Seguro> ListSeguro();
    Optional<Seguro> searchByIdSeguro(String idSeguros);
    List<Seguro> findSegurosByVehiculo(Long idVehiculo);
    // Registrar seguro
    Seguro registerSeguro(Seguro seguro);

    //Actualizar seguro
   Seguro updateSeguro(Long idSeguro, Seguro seguro);

    //Eliminar Seguro
    void deleteSeguro(Long idSeguro) throws Exception;


}
