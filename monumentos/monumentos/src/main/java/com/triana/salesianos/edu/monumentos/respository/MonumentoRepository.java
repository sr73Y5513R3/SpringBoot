package com.triana.salesianos.edu.monumentos.respository;

import com.triana.salesianos.edu.monumentos.model.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    /*
    * private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String codigoPais;
    private String pais;
    private String ciudad;
    private double longitud;
    private double latitud;
    * */

    @PostConstruct
    public void init() {
        add(Monumento.builder().nombre("Plaza Juan Vázquez de Molina").descripcion("\n" +
                "La Plaza Vázquez de Molina está considerada como la plaza de toda Europa que mayor concentración de edificios históricos tiene por metro cuadrado")
                .imagen("https://www.vandelviraturismo.com/wp-content/uploads/2020/09/plaza-vazquez-de-molina2-900x480.jpg")
                .codigoPais("ES").pais("España").ciudad("Úbeda").longitud().latitud().build());
    }

    public Monumento add (Monumento monumento) {
        long id = counter.incrementAndGet();
        monumento.setId(id);
        monumentos.put(id, monumento);
        return monumento;
    }
}
