package org.utn.tarea_climalert.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Condition(
        @JsonProperty("text")
        String text
) {
}
