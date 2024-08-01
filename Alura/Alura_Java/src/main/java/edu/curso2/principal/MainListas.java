package edu.curso2.principal;

import edu.curso2.modelos.Filme;
import edu.curso2.modelos.Serie;
import edu.curso2.modelos.Titulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainListas {

    public static void main(String[] args) {

        Filme filme1 = new Filme("Políticos do Caribe: Taxados em Marés obscuras", 2003);
        filme1.avaliar(9);
        Filme filme2 = new Filme("O Taxador do Futuro", 2024);
        filme2.avaliar(6);
        var filme3 = new Filme("De volta para a Taxa", 2020);
        filme3.avaliar(8);
        Serie serie1 = new Serie("Taxados na Cozinha", 2018);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie1);
        for (Titulo item:lista){
            System.out.println(item.getNome());
            if (item instanceof Filme) {
                Filme filme = (Filme) item;
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Jackie Chan");
        buscaPorArtista.add("Nicholas Cage");
        buscaPorArtista.add("Bruce Lee");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da Ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de Títulos Ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        System.out.println("Ordenado por Ano");
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
