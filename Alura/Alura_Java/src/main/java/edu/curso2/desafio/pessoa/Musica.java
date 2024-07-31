package edu.curso2.desafio.pessoa;

public class Musica {

    String titulo;
    String artista;
    int anoDeLancamento;
    double somaAvaliacoes;
    int numAvaliacoes;

    void exibirFichaTecnica() {
        System.out.println("Nome dessa música é: " + titulo);
        System.out.println("O compositor dessa música é: " + artista);
        System.out.println("Essa música foi lançada em: " + anoDeLancamento);
    }

    void avaliar(double avaliacaoParam) {
        somaAvaliacoes += avaliacaoParam;
        numAvaliacoes++;
    }

    double getMediaAvaliacoes() {
        return somaAvaliacoes / numAvaliacoes;
    }
}
