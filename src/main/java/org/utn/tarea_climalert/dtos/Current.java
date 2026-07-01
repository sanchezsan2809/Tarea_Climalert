package org.utn.tarea_climalert.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Current(
        @JsonProperty("temp_c")
        double temperatura,

        @JsonProperty("humidity")
        int humedad
) {
}
