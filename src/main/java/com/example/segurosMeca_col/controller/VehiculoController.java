package com.example.segurosMeca_col.controller;

import com.example.segurosMeca_col.entity.Vehiculo;
import com.example.segurosMeca_col.repository.VehiculoRepository;
import com.example.segurosMeca_col.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.ListVehiculo();
        return ResponseEntity.ok(vehiculos);
    }
    @GetMapping("/search/placa/{placa}")
    public ResponseEntity<?> searchPlaca(@PathVariable String placa) {
        Optional<Vehiculo> vehiculo = vehiculoService.searchPlaca(placa);

        return vehiculo.isPresent()
                ? ResponseEntity.ok(vehiculo.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    @PostMapping("/register")
    public ResponseEntity<Vehiculo> registerVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo newVehiculo = vehiculoService.registerVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehiculo);
    }
    @PutMapping("/update/{idVehiculo}")
    public ResponseEntity<?> updateProduct(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo vehiculoDB = vehiculoService.updateVehiculoById(idVehiculo, vehiculo);
            return ResponseEntity.ok(vehiculoDB);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{idVehiculo}") // no usages
    public ResponseEntity<?> deleteVehiculo(@PathVariable Long idVehiculo) {
        try {
            vehiculoService.deleteVehiculo(idVehiculo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }




}
