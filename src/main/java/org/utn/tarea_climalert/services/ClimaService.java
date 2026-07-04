package org.utn.tarea_climalert.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.utn.tarea_climalert.clients.ClimaApiClient;
import org.utn.tarea_climalert.clients.ClimaApiClient;
import org.utn.tarea_climalert.dtos.ClimaResponse;
import org.utn.tarea_climalert.entities.RegistroClima;
import org.utn.tarea_climalert.repositories.RegistroClimaRepository;

import java.time.LocalDateTime;

@Service
public class ClimaService {

    private final Logger logger = LoggerFactory.getLogger(ClimaService.class);
    private final ClimaApiClient climaApiClient;
    private final RegistroClimaRepository repository;

    public ClimaService(ClimaApiClient climaApiClient, RegistroClimaRepository repository) {
        this.climaApiClient = climaApiClient;
        this.repository = repository;
    }

    public void actualizarClima() {

        try{
            ClimaResponse response = climaApiClient.obtenerClimaActual();

            if(response == null || response.current() == null){
                logger.error("WeatherAPI respondió sin datos.");
                return;
            }

            RegistroClima registroClima = RegistroClima.from(response);

            repository.save(registroClima);

            logger.info(
                    "Clima registrado. Temp={}° Humedad={}%",
                    registroClima.getTemperatura(),
                    registroClima.getHumedad()
            );
        }catch(Exception e){
            logger.error("Error consultando WeatherAPI", e);
        }


    }
}
