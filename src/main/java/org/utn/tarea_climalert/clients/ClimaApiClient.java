package org.utn.tarea_climalert.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.utn.tarea_climalert.dtos.ClimaResponse;

@Service
public class ClimaApiClient {
    private static String API_KEY = "026694342d1e4336a0e235635263006";
    private static String ubicacion = "CABA";

    private final RestClient restClient;

    public ClimaApiClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://api.weatherapi.com/v1")
                .build();
    }



    public ClimaResponse obtenerClimaActual() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", API_KEY)
                        .queryParam("q", ubicacion)
                        .build())
                .retrieve()
                .body(ClimaResponse.class);
    }
}
