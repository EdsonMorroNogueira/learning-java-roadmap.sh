package edu.curso2;

import edu.curso2.calculos.CalculadoraDeTempo;
import edu.curso2.modelos.Filme;
import edu.curso2.modelos.Serie;

public class Main {

    public static void main(String[] args) {

        Filme meuFilme = new Filme();

        meuFilme.setNome("Ratatouille");
        meuFilme.setAnoDeLancamento(2004);
        meuFilme.setDuracaoEmMinutos(120);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.exibirFichaTecnica();
        meuFilme.avaliar(8);
        meuFilme.avaliar(3);
        meuFilme.avaliar(10);

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getMedia());


        Serie anime = new Serie();
        anime.setNome("Lost");
        anime.setAnoDeLancamento(2000);
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
    }
}
