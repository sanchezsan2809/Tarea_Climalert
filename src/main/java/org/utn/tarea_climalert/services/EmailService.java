package org.utn.tarea_climalert.services;

import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.utn.tarea_climalert.entities.RegistroClima;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarAlerta(RegistroClima clima) {
        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(
                "admin@clima.com",
                "emergencias@clima.com",
                "meteorologia@clima.com"
        );

        mensaje.setSubject("Alerta meteorológica");

        String cuerpo = construirMensaje(clima);

        mensaje.setText(cuerpo);

        mensaje.setFrom("santiasanchez@frba.utn.edu.ar");

        mailSender.send(mensaje);
    }

    private String construirMensaje(RegistroClima clima){
        return """
        Se detectó una alerta meteorológica.

        Fecha: %s

        Temperatura: %.1f °C
        Sensación térmica: %.1f °C
        Humedad: %d %%
        Presión: %.1f hPa
        Velocidad del viento: %.1f km/h
        Condición: %s
        """.formatted(
                clima.getFechaObtencion(),
                clima.getTemperatura(),
                clima.getSensacionTermica(),
                clima.getHumedad(),
                clima.getPresion(),
                clima.getVelocidadViento(),
                clima.getCondicion()
        );
    }
}
