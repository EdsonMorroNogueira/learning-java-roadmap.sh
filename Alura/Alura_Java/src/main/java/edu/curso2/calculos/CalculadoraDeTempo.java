package edu.curso2.calculos;

import edu.curso2.modelos.Filme;
import edu.curso2.modelos.Serie;
import edu.curso2.modelos.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void incluir(Titulo titulo){
        System.out.println("Adicionando duração em minutos de " + titulo);
        tempoTotal += titulo.getDuracaoEmMinutos();
    }

}
