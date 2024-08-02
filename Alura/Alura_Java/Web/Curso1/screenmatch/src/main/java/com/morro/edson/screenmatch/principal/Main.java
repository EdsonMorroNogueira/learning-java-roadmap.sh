package com.morro.edson.screenmatch.principal;

import com.morro.edson.screenmatch.model.DadosEpisodio;
import com.morro.edson.screenmatch.model.DadosTemporada;
import com.morro.edson.screenmatch.model.Episodio;
import com.morro.edson.screenmatch.service.ConsumoApi;
import com.morro.edson.screenmatch.model.DadosSerie;
import com.morro.edson.screenmatch.service.implementation.ConverteDadosImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDadosImpl conversor = new ConverteDadosImpl();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    public void exibirMenu() {

        System.out.println("Digite o nome da série para a busca: ");
        var nomeSerie = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }

        // AO INVÉS DE:

//		for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
//			List<DadosEpisodio> episodios = temporadas.get(i).episodios();
//			for ( int j = 0; j < episodios.size(); j++){
//				System.out.println(episodios.get(j).titulo());
//			}
//		}

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("A partir de que ano você deseja ver os episódios? ");
        var ano = scanner.nextInt();
        scanner.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                " Episódio: " + e.getTitulo() +
                                " Data Lançamento: " + e.getDataLancamento().format(formatador)
                ));

//        System.out.println("\n Top 5 episódios");
//        episodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                .limit(5)
//                .forEach(System.out::println);


//        List<String> nomes = Arrays.asList("Jacque", "Iasmin", "Paulo", "Rodrigo", "Nico");
//
//        nomes.stream()
//                .sorted()
//                .limit(3)
//                .filter(n -> n.startsWith("N"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);

    }
}