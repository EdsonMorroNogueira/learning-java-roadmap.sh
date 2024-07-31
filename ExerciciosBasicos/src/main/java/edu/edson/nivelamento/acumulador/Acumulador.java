package edu.edson.nivelamento.acumulador;

import java.util.Random;

public class Acumulador {

    public static void main(String[] args) {

        Random random = new Random();
        int soma = 0;

        while (true) {

            int numeroSorteado = random.nextInt(10);

            if (numeroSorteado == 0) {
                break;
            } else {
                soma += numeroSorteado;
            }
            System.out.println(numeroSorteado);
        }

        System.out.println("A soma dos números é " + soma);
    }
}
