package com.morro.edson.screenmatch_curso2.service;

import com.morro.edson.screenmatch_curso2.dto.EpisodioDto;
import com.morro.edson.screenmatch_curso2.dto.SerieDto;
import com.morro.edson.screenmatch_curso2.model.Categoria;
import com.morro.edson.screenmatch_curso2.model.Episodio;
import com.morro.edson.screenmatch_curso2.model.Serie;
import com.morro.edson.screenmatch_curso2.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<SerieDto> obterTodasAsSeries() {

        return converteDados(serieRepository.findAll());
    }

    public List<SerieDto> obterTop5Series(){

        return converteDados(serieRepository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDto> obterLancamento(){

        return converteDados(serieRepository.findTop5ByOrderByEpisodiosDataLancamentoDesc());
    }

    private List<SerieDto> converteDados(List<Serie> series) {

        return series
                .stream()
                .map(s -> new SerieDto(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(),
                        s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }

    public SerieDto obterPorId(Long id) {

        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            Serie s= serie.get();
            return new SerieDto(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(),
                  s.getAtores(), s.getPoster(), s.getSinopse());
        }
        return null;
    }

    public List<EpisodioDto> obterTodasTemporadas(Long id) {

        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            Serie s = serie.get();
            return s.getEpisodios().stream().map(e -> new EpisodioDto(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodioDto> obterTemporadasPorNumero(Long id, Long numero) {
        return serieRepository.obterEpisodiosPorTemporada(id, numero)
                .stream()
                .map(e -> new EpisodioDto(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());

    }

    public List<SerieDto> obterSeriesPorCategoria(String nomeGenero) {
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        return converteDados(serieRepository.findByGenero(categoria));
    }

    public List<EpisodioDto> obterTop5Episodios(Long id) {
        return serieRepository.topEpisodiosPorIdSerie(id)
                .stream()
                .map(e -> new EpisodioDto(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());

    }
}
