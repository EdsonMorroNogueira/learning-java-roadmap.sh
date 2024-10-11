package com.morro.edson.screenmatch_curso2.dto;

import com.morro.edson.screenmatch_curso2.model.Categoria;

public record SerieDto(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse) {
}
