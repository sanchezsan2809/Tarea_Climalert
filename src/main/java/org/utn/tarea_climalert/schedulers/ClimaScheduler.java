package org.utn.tarea_climalert.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.utn.tarea_climalert.services.ClimaService;

@Component
public class ClimaScheduler {
    private final ClimaService climaService;

    public ClimaScheduler(ClimaService cLimaService) {
        this.climaService = cLimaService;
    }

    @Scheduled(fixedRate = 300000)
    public void actualizarClima(){
        this.climaService.actualizarClima();
    }
}
