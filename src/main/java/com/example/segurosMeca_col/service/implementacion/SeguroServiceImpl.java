package com.example.segurosMeca_col.service.implementacion;

import com.example.segurosMeca_col.entity.Seguro;
import com.example.segurosMeca_col.repository.SeguroRepository;
import com.example.segurosMeca_col.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    public List<Seguro> ListSeguro() {
        return seguroRepository.findAll();
    }

    @Override
    public Optional<Seguro> searchByIdSeguro(String idSeguros) {
        return seguroRepository.findByIdSeguros(idSeguros);
    }

    @Override
    public List<Seguro> findSegurosByVehiculo(Long idVehiculo) {
        return seguroRepository.findByVehiculo_IdVehiculo(idVehiculo);
    }

    @Override
    public Seguro registerSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

    @Override
    public Seguro updateSeguro(Long idSeguro, Seguro seguro) {

        Seguro seguroExisting = seguroRepository.findById(idSeguro)
                .orElseThrow(() -> new RuntimeException("Seguro con ID " + idSeguro + " no encontrado"));

        seguroExisting.setCompania(seguro.getCompania());
        seguroExisting.setNumeroPoliza(seguro.getNumeroPoliza());
        seguroExisting.setFechaInicio(seguro.getFechaInicio());
        seguroExisting.setFechaVencimiento(seguro.getFechaVencimiento());
        if (seguro.getVehiculo() != null) {
            seguroExisting.setVehiculo(seguro.getVehiculo());
        }
        return seguroRepository.save(seguroExisting);
    }


    @Override
    public void deleteSeguro(Long idSeguro) throws Exception {
        Seguro seguroExisting = seguroRepository.findById(idSeguro)
                .orElseThrow(() -> new Exception("Seguro con Id " + idSeguro + " no encontrado"));

        seguroRepository.deleteById(idSeguro);
    }

}
