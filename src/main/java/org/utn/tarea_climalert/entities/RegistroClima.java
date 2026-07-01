package org.utn.tarea_climalert.entities;

import org.utn.tarea_climalert.dtos.ClimaResponse;

import java.time.LocalDateTime;

public class RegistroClima(){
    private final LocalDateTime fechaObtencion;
    private final double temperatura;
    private final int humedad;

    public RegistroClima(LocalDateTime fechaObtencion, double temperatura, int humedad){
        this.fechaObtencion = fechaObtencion;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public static RegistroClima from(ClimaResponse response){
        return new RegistroClima(
                LocalDateTime.now(),
                response.current().temperatura(),
                response.current().humedad()
        );
    }
}

