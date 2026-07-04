package org.utn.tarea_climalert.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.utn.tarea_climalert.services.AlertaService;

@Scheduled
public class AlertaScheduler {
    private final AlertaService alertaService;
    public AlertaScheduler(AlertaService alertaService) {this.alertaService = alertaService;}

    @Scheduled(fixedRate = 60 * 1000)
    public void generarAlerta() {
        this.alertaService.generarAlerta();
    }
}
