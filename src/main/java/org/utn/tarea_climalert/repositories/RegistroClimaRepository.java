package org.utn.tarea_climalert.repositories;

import org.springframework.stereotype.Repository;
import org.utn.tarea_climalert.dtos.ClimaResponse;
import org.utn.tarea_climalert.entities.RegistroClima;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RegistroClimaRepository {
    private final Map<Long, RegistroClima> registros;
    static long id;


    public RegistroClimaRepository() {
        this.registros = new HashMap<>();
        this.id = 0;
    }

    public void save(RegistroClima response) {
        registros.put(id,  response);
        id++;
    }
}
