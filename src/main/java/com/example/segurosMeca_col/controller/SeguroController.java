package com.example.segurosMeca_col.controller;

import com.example.segurosMeca_col.entity.Seguro;
import com.example.segurosMeca_col.entity.Vehiculo;
import com.example.segurosMeca_col.service.SeguroService;
import com.example.segurosMeca_col.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seguro")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @GetMapping
    public ResponseEntity<List<Seguro>> getAllSeguro() {
        List<Seguro> seguro = seguroService.ListSeguro();
        return ResponseEntity.ok(seguro);
    }
    @GetMapping("/search/idSeguro/{idSeguros}")
    public ResponseEntity<?> searchidSeguros(@PathVariable String idSeguros) {
        Optional<Seguro> seguro = seguroService.searchByIdSeguro(idSeguros);

        return seguro.isPresent()
                ? ResponseEntity.ok(seguro.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    @PostMapping("/register")
    public ResponseEntity<Seguro> registerVehiculo(@RequestBody Seguro seguro) {
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeguro);
    }
    @PutMapping("/update/{idSeguro}")
    public ResponseEntity<?> updateSeguro(@PathVariable Long idSeguro, @RequestBody Seguro seguro) {
        try {
            Seguro seguroDB = seguroService.updateSeguro(idSeguro, seguro);
            return ResponseEntity.ok(seguroDB);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{idSeguro}") // no usages
    public ResponseEntity<?> deleteSeguros(@PathVariable Long idSeguro) {
        try {
            seguroService.deleteSeguro(idSeguro);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping("/vehiculo/{idVehiculo}")
    public ResponseEntity<?> getSegurosByVehiculo(@PathVariable Long idVehiculo) {
        List<Seguro> seguros = seguroService.findSegurosByVehiculo(idVehiculo);

        if (seguros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay seguros para el vehículo con ID " + idVehiculo);
        }

        return ResponseEntity.ok(seguros);
    }



}
