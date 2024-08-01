package edu.curso2.modelos;

import edu.curso2.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel  {

    private String diretor;

    public String getDiretor() {
        return diretor;
    }


    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {

        return (int) getMedia() / 2 ;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
