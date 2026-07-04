package org.utn.tarea_climalert.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.utn.tarea_climalert.entities.RegistroClima;
import org.utn.tarea_climalert.repositories.RegistroClimaRepository;

@Service
public class AlertaService {

    private static final Logger logger = LoggerFactory.getLogger(AlertaService.class);
    private final RegistroClimaRepository registroClimaRepository;
    private final EmailService emailService;

    public AlertaService(RegistroClimaRepository registroClimaRepository, EmailService emailService) {
        this.registroClimaRepository = registroClimaRepository;
        this.emailService = emailService;
    }

    public void generarAlerta() {

        try {
            RegistroClima ultimoRegistro = registroClimaRepository.ultimo();

            if (ultimoRegistro == null) {
                logger.info("Todavía no existen registros climáticos.");
                return;
            }

            logger.info("Analizando registro obtenido a las {}", ultimoRegistro.getFechaObtencion());

            if(alerta(ultimoRegistro) && !ultimoRegistro.isAlertaNotificada()) {
                emailService.enviarAlerta(ultimoRegistro);

                logger.info("Alerta enviada exitosamente");

                ultimoRegistro.setAlertaNotificada(true);

                registroClimaRepository.save(ultimoRegistro);
            }else {
                logger.info("No se detectaron condiciones de alerta.");
            }

        }catch(Exception e){
            logger.error("Hubo un error en el procesamiento de alertas");
        }


    }

    private Boolean alerta(RegistroClima registroClima) {
        return registroClima.getTemperatura() > 35 || registroClima.getTemperatura() > 60;
    }
}
