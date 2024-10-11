package com.morro.edson.screenmatch_curso2.serviceAntiga.traducao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResposta(
        @JsonAlias(value = "translatedText") String textoTraduziado
) {
}
