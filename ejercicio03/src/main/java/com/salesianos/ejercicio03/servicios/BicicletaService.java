package com.salesianos.ejercicio03.servicios;

import com.salesianos.ejercicio03.models.Bicicleta;
import com.salesianos.ejercicio03.repos.BicicletaRepositorio;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepositorio bicicletaRepositorio;

    public List<Bicicleta> findAll(){
         return bicicletaRepositorio.findAll();
    }



}
