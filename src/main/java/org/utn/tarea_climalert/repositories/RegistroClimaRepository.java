package org.utn.tarea_climalert.repositories;

import org.springframework.stereotype.Repository;
import org.utn.tarea_climalert.dtos.ClimaResponse;
import org.utn.tarea_climalert.entities.RegistroClima;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistroClimaRepository {
    private final List<RegistroClima> registros = new ArrayList<>();

    public void save(RegistroClima registro){
        registros.add(registro);
    }

    public RegistroClima ultimo(){
        if(registros.isEmpty()){
            return null;
        }

        return registros.getLast();
    }
}
