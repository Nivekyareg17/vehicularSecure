package com.example.segurosMeca_col.service.implementacion;

import com.example.segurosMeca_col.entity.Vehiculo;
import com.example.segurosMeca_col.repository.VehiculoRepository;
import com.example.segurosMeca_col.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> ListVehiculo() {
        return vehiculoRepository.findAll();
    }


    @Override
    public Optional<Vehiculo> searchVehiculoByPlaca(String placa) throws Exception {
        return Optional.empty();
    }


    @Override
    public Vehiculo updateVehiculoById(Long idVehiculo, Vehiculo vehiculo) {

        Vehiculo vehiculoExisting = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new RuntimeException("Vehículo con ID " + idVehiculo + " no encontrado"));

        vehiculoExisting.setPlaca(vehiculo.getPlaca());
        vehiculoExisting.setMarca(vehiculo.getMarca());
        vehiculoExisting.setModelo(vehiculo.getModelo());
        vehiculoExisting.setColor(vehiculo.getColor());
        vehiculoExisting.setTipoVehiculo(vehiculo.getTipoVehiculo());
        vehiculoExisting.setTipoGVehiculo(vehiculo.getTipoGVehiculo());

        return vehiculoRepository.save(vehiculoExisting);
    }

    @Override
    public void deleteVehiculo(Long idVehiculo) throws Exception {
        Vehiculo vehiculoExisting = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new Exception("Vehículo con Id " + idVehiculo + " no encontrado"));

        vehiculoRepository.deleteById(idVehiculo);
    }

    @Override
    public Optional<Vehiculo> searchPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);

    }


}
