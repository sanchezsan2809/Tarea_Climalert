package org.utn.tarea_climalert.services;

import org.springframework.stereotype.Service;
import org.utn.tarea_climalert.clients.ClimaApiClient;
import org.utn.tarea_climalert.clients.ClimaApiClient;
import org.utn.tarea_climalert.dtos.ClimaResponse;
import org.utn.tarea_climalert.entities.RegistroClima;
import org.utn.tarea_climalert.repositories.RegistroClimaRepository;

import java.time.LocalDateTime;

@Service
public class ClimaService {
    private final ClimaApiClient climaApiClient;
    private final RegistroClimaRepository repository;

    public ClimaService(ClimaApiClient climaApiClient, RegistroClimaRepository repository) {
        this.climaApiClient = climaApiClient;
        this.repository = repository;
    }

    public void actualizarClima() {
        log.info()
        try{
            ClimaResponse response = climaApiClient.obtenerClimaActual();

            if(response == null || response.current() == null){
                throw new RuntimeException("No se pudo obtener el clima");
            }

            RegistroClima registroClima = RegistroClima.from(response);

            repository.save(registroClima);
        }catch(Exception e){
            throw new RuntimeException("No se pudo obtener el clima");
        }


    }
}
