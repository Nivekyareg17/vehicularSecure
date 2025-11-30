package com.example.segurosMeca_col.controller;

import com.example.segurosMeca_col.entity.Conductor;
import com.example.segurosMeca_col.entity.Seguro;
import com.example.segurosMeca_col.service.ConductorService;
import com.example.segurosMeca_col.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conductor")
public class ConductorController {
    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public ResponseEntity<List<Conductor>> getAllConductor() {
        List<Conductor> conductor = conductorService.ListConductor();
        return ResponseEntity.ok(conductor);
    }
    @GetMapping("/search/idConductor/{idConductor}")
    public ResponseEntity<?> searchidConductor(@PathVariable Long idConductor) {
        Optional<Conductor> conductor = conductorService.searchByidConductor(idConductor);

        return conductor.isPresent()
                ? ResponseEntity.ok(conductor.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    @PostMapping("/register")
    public ResponseEntity<Conductor> registerConductor(@RequestBody Conductor conductor) {
        Conductor newConductor = conductorService.registerConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConductor);
    }
    @PutMapping("/update/{idConductor}")
    public ResponseEntity<?> updateConductor(@PathVariable Long idConductor, @RequestBody Conductor conductor) {
        try {
            Conductor conductorDB = conductorService.updateConductor(idConductor, conductor);
            return ResponseEntity.ok(conductorDB);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{idConductor}") // no usages
    public ResponseEntity<?> deleteConductor(@PathVariable Long idConductor) {
        try {
            conductorService.deleteConductor(idConductor);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
