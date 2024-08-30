package com.morro.edson.screenmatch_curso2.main;

import com.morro.edson.screenmatch_curso2.model.*;
import com.morro.edson.screenmatch_curso2.repository.SerieRepository;
import com.morro.edson.screenmatch_curso2.service.ConsumoApi;
import com.morro.edson.screenmatch_curso2.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner leitura = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi();

    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=d21eae24";

    private List<DadosSerie> dadosSeries = new ArrayList<>();

    private SerieRepository repositorio;

    private List<Serie> series = new ArrayList<>();

    private Optional<Serie> serieBusca;

    public Main(SerieRepository serieRepository) {
        this.repositorio = serieRepository;
    }

    public void exibirMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries buscadas
                    4 - Buscar série por título
                    5 - Buscar séries por ator
                    6 - Top 5 Séries
                    7 - Filtrar séries por categoria
                    8 - Buscar episódios por trecho
                    9 - Filtrar séries por quantidade temporadas e avaliação
                    10 - Top 5 Episódios por série
                    11 - Buscar episódios a partir de uma data
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriePorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriePorCategoria();
                    break;
                case 8:
                    buscarEpisodioPorTrecho();
                    break;
                case 9:
                    buscarSeriePorQtdTemporadaEAvaliacao();
                case 10:
                    topEpisodiosPorSerie();
                    break;
                case 11:
                    buscarEpisodiosDepoisDeUmaData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb () {
            DadosSerie dados = getDadosSerie();
           // dadosSeries.add(dados);
            Serie serie = new Serie(dados);
            repositorio.save(serie);
            System.out.println(dados);
        }

        private DadosSerie getDadosSerie () {
            System.out.println("Digite o nome da série para busca");
            var nomeSerie = leitura.nextLine();
            var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
            DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
            return dados;
        }

        private void buscarEpisodioPorSerie () {
            listarSeriesBuscadas();
            System.out.println("Escolha uma série pelo nome");
            var nomeSerie = leitura.nextLine();

            Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

            if (serie.isPresent()) {
                Serie serieEncontrada = serie.get();
                List<DadosTemporada> temporadas = new ArrayList<>();

                for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                    var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                    DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                    temporadas.add(dadosTemporada);
                }
                List<Episodio> episodios = temporadas.stream()
                        .flatMap(d -> d.episodios().stream()
                                .map(e -> new Episodio(d.numero(), e)))
                        .collect(Collectors.toList());

                serieEncontrada.setEpisodios(episodios);
                repositorio.save(serieEncontrada);
            } else {
                System.out.println("Série não encontrada!");
            }
        }

        private void listarSeriesBuscadas () {
            series = repositorio.findAll();
            series.stream()
                    .sorted(Comparator.comparing(Serie::getGenero))
                    .forEach(System.out::println);
        }

        private void buscarSeriePorTitulo () {
            System.out.println("Escolha uma série pelo nome: ");
            var nomeSerie = leitura.nextLine();
            serieBusca = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

            if (serieBusca.isPresent()) {
                System.out.println("Dados da Série: " + serieBusca.get());
            } else {
                System.out.println("Série não encontrada!");
            }
        }

        private void buscarSeriePorAtor () {
            System.out.println("Digite o nome de um ator: ");
            var nomeAtor = leitura.nextLine();
            System.out.println("Avaliações a partir de que valor?");
            var avaliacao = leitura.nextDouble();
            List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacao);
            System.out.println("Séries em que " + nomeAtor + " trabalhou: ");
            seriesEncontradas.forEach(s -> System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
        }

        private void buscarTop5Series () {
            List<Serie> serieTop = repositorio.findTop5ByOrderByAvaliacaoDesc();
            serieTop.forEach(s -> System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
        }

        private void buscarSeriePorCategoria () {
            System.out.println("Deseja buscar séries de que categoria/gênero? ");
            var nomeGenero = leitura.nextLine();
            Categoria categoria = Categoria.fromPortugues(nomeGenero);
            List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
            System.out.println("Séries da categoria " + nomeGenero);
            seriesPorCategoria.forEach(s -> System.out.println(s.getTitulo() + " categoria " + s.getGenero()));
        }

        private void buscarSeriePorQtdTemporadaEAvaliacao() {
            System.out.println("Quantas temporadas no máximo? ");
            var qtdTemp = leitura.nextInt();
            System.out.println("Qual é a avaliação mínima? ");
            var avaliacao = leitura.nextDouble();
            leitura.nextLine();
            List<Serie> seriesPorQtdTempEAvaliacao = repositorio.seriesPorTemporadaEAvaliacao(qtdTemp, avaliacao);
            System.out.println("*** Séries filtradas ***");
            System.out.println("Séries com no máximo " + qtdTemp + " temporadas e no mínimo " + avaliacao + " de avaliação");
            seriesPorQtdTempEAvaliacao.forEach(s -> System.out.println(s.getTitulo() + " Quantidade Temporadas " + s.getTotalTemporadas() + " avaliação " + s.getAvaliacao()));
        }

        private void buscarEpisodioPorTrecho() {
            System.out.println("Qual o nome do episódio para busca?");
            var trechoEpisodio = leitura.nextLine();
            List<Episodio> episodiosEncontrados = repositorio.episodiosPorTrecho(trechoEpisodio);
            episodiosEncontrados.forEach(e -> System.out.printf("Série %s Temporada %s - Episódio %s - %s\n",
                    e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
        }

        private void topEpisodiosPorSerie() {
           buscarSeriePorTitulo();
           if (serieBusca.isPresent()) {
               Serie serie = serieBusca.get();
               List<Episodio> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
               topEpisodios.forEach( e -> System.out.printf("Série: %s Temporada %s - Episódio %s - %s Avaliação %s\n",
                       e.getSerie().getTitulo(), e.getTemporada(),
                       e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
           }
        }

        private void buscarEpisodiosDepoisDeUmaData() {
            buscarSeriePorTitulo();
            if (serieBusca.isPresent()) {
                Serie serie = serieBusca.get();
                System.out.println("Digite o ano mínimo de lançamento: ");
                var anoLancamento = leitura.nextInt();
                leitura.nextLine();

                List<Episodio> episodioAno = repositorio.episodiosPorSerieEAno(serie, anoLancamento);
                episodioAno.forEach(System.out::println);
            }
        }
}