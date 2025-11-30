package com.example.segurosMeca_col.service.implementacion;

import com.example.segurosMeca_col.entity.Conductor;
import com.example.segurosMeca_col.entity.Vehiculo;
import com.example.segurosMeca_col.repository.ConductorRepository;
import com.example.segurosMeca_col.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Conductor> ListConductor() {
        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> searchByidConductor(Long idConductor) {
        return conductorRepository.findByidConductor(idConductor);
    }

    @Override
    public Conductor registerConductor(Conductor conductor) {
        return conductorRepository.save(conductor);

    }

    @Override
    public Conductor updateConductor(Long idConductor, Conductor conductor) {

        Conductor conductorExisting = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new RuntimeException("Conductor con ID " + idConductor + " no encontrado"));


        conductorExisting.setNombre(conductor.getNombre());
        conductorExisting.setLicencia(conductor.getLicencia());
        conductorExisting.setTelefono(conductor.getTelefono());
        conductorExisting.setDireccion(conductor.getDireccion());
        conductorExisting.setActivo(conductor.getActivo());


        return conductorRepository.save(conductorExisting);
    }

    @Override
    public void deleteConductor(Long idConductor) throws Exception {
        Conductor conductorExisting = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new Exception("Vehículo con Id " + idConductor + " no encontrado"));

        conductorRepository.deleteById(idConductor);
    }
}
