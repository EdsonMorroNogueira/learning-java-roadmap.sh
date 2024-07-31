package edu.curso2.desafio.pessoa;

import java.time.LocalDateTime;

public class Carro {

    String modelo;
    int ano;
    String cor;

    void exibirFichaTecnica() {
        System.out.println("O modelo deste carro é: " + modelo);
        System.out.println("O ano deste carro é: " + ano);
        System.out.println("A cor deste carro é: " + cor);
    }

    int getIdade() {
      return LocalDateTime.now().getYear() - ano;
    }
}
