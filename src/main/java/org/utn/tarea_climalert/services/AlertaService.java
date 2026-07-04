package org.utn.tarea_climalert.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.utn.tarea_climalert.entities.RegistroClima;
import org.utn.tarea_climalert.repositories.RegistroClimaRepository;

@Service
public class AlertaService {

    private final Logger logger = LoggerFactory.getLogger(AlertaService.class);
    private final RegistroClimaRepository registroClimaRepository;

    public AlertaService(RegistroClimaRepository registroClimaRepository) {
        this.registroClimaRepository = registroClimaRepository;
    }

    public void generarAlerta() {
        RegistroClima ultimoRegistro = registroClimaRepository.ultimo();

        if(alerta(ultimoRegistro)) {

        }
    }

    private Boolean alerta(RegistroClima registroClima) {
        return registroClima.getTemperatura() > 35 || registroClima.getTemperatura() < 60;
    }
}
