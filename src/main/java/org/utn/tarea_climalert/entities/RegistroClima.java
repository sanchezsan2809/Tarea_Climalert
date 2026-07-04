package org.utn.tarea_climalert.entities;

import lombok.Getter;
import lombok.Setter;
import org.utn.tarea_climalert.dtos.ClimaResponse;

import java.time.LocalDateTime;

@Getter
public class RegistroClima{
    private final LocalDateTime fechaObtencion;
    private final double temperatura;
    private final int humedad;
    private final double sensacionTermica;
    private final double velocidadViento;
    private final double presion;
    private final String condicion;
    @Setter
    private boolean alertaNotificada;

    public RegistroClima(LocalDateTime fechaObtencion, double temperatura, int humedad, double sensacionTermica, double velocidadViento, double presion, String condicion) {
        this.fechaObtencion = fechaObtencion;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.sensacionTermica = sensacionTermica;
        this.velocidadViento = velocidadViento;
        this.presion = presion;
        this.condicion = condicion;
        this.alertaNotificada = false;
    }

    public static RegistroClima from(ClimaResponse response){
        return new RegistroClima(
                LocalDateTime.now(),
                response.current().temperatura(),
                response.current().humedad(),
                response.current().sensacionTermica(),
                response.current().velocidadViento(),
                response.current().presion(),
                response.current().condicion().text()
        );
    }
}

