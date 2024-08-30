package com.morro.edson.screenmatch_curso2.repository;

import com.morro.edson.screenmatch_curso2.model.Categoria;
import com.morro.edson.screenmatch_curso2.model.Episodio;
import com.morro.edson.screenmatch_curso2.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

     Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

     List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

     List<Serie> findTop5ByOrderByAvaliacaoDesc();

     List<Serie> findByGenero(Categoria categoria);

     @Query("select s from Serie s WHERE s.totalTemporadas <= :qtdTemp AND s.avaliacao >= :avaliacao")
     List<Serie> seriesPorTemporadaEAvaliacao(int qtdTemp, double avaliacao);

     @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
     List<Episodio> episodiosPorTrecho(String trechoEpisodio);

     @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
     List<Episodio> topEpisodiosPorSerie(Serie serie);

     @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
     List<Episodio> episodiosPorSerieEAno(Serie serie, int anoLancamento);
}
