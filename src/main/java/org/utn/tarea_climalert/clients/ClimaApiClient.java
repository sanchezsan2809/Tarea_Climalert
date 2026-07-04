package org.utn.tarea_climalert.clients;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.utn.tarea_climalert.dtos.ClimaResponse;

@Service
public class ClimaApiClient {
    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.location}")
    private String ubicacion;

    @Value("${weather.api.base-url}")
    private String baseUrl;


    private final RestClient restClient;

    public ClimaApiClient(@Value("${weather.api.base-url}") String baseUrl) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }



    public ClimaResponse obtenerClimaActual() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", ubicacion)
                        .build())
                .retrieve()
                .body(ClimaResponse.class);
    }
}
