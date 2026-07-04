package org.utn.tarea_climalert.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;

public record Current(
        @JsonProperty("temp_c")
        double temperatura,

        @JsonProperty("humidity")
        int humedad,

        @JsonProperty("feelslike_c")
        double sensacionTermica,

        @JsonProperty("condition")
        Condition condicion,

        @JsonProperty("wind_kph")
        double velocidadViento,

        @JsonProperty("pressure_mb")
        double presion

) {
}

