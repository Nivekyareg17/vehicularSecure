package com.example.segurosMeca_col.service;

import com.example.segurosMeca_col.entity.Conductor;
import com.example.segurosMeca_col.entity.Seguro;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    //Buscar Conductor
    List<Conductor> ListConductor();
    Optional<Conductor> searchByidConductor(Long idConductor);
    // Registrar Conductor
    Conductor registerConductor(Conductor conductor);

    //Actualizar Conductor
    Conductor updateConductor(Long idConductor, Conductor conductor);

    //Eliminar Conductor
    void deleteConductor(Long idConductor) throws Exception;
}
