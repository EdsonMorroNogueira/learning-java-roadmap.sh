package edu.curso2.principal;

import edu.curso2.calculos.CalculadoraDeTempo;
import edu.curso2.calculos.FiltroRecomendacao;
import edu.curso2.modelos.Episodio;
import edu.curso2.modelos.Filme;
import edu.curso2.modelos.Serie;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Filme meuFilme = new Filme("Ratatouille", 2004);
        meuFilme.setDuracaoEmMinutos(120);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.exibirFichaTecnica();
        meuFilme.avaliar(8);
        meuFilme.avaliar(3);
        meuFilme.avaliar(10);

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getMedia());


        Serie anime = new Serie("Boku no Hero Academia", 2000);
        anime.exibirFichaTecnica();
        anime.setTemporadas(10);
        anime.setEpisodiosPorTemporada(10);
        anime.setMinutosPorEpisodio(30);
        System.out.println("Duração da série: " + anime.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(meuFilme);
        calculadora.incluir(outroFilme);
        calculadora.incluir(anime);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(anime);
        episodio.setTotalVisualizacoes(300);
        filtro.filtrar(episodio);

        var filme3 = new Filme("Carros", 2003);
        filme3.setDuracaoEmMinutos(200);
        filme3.avaliar(10);

        ArrayList<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(filme3);
        listaFilmes.add(meuFilme);
        listaFilmes.add(outroFilme);
        System.out.println("Tamanho da lista " + listaFilmes.size());
        System.out.println("Primeiro filme" + listaFilmes.get(0).getNome());
    }
}
