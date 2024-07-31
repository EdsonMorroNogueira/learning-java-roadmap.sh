package edu.curso1;

import java.util.Scanner;

public class Positivo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número:");
        int numUser = scanner.nextInt();

        if (numUser < 0) {
            System.out.println("Seu número é negativo");
        } else {
            System.out.println("Seu número é positivo");
        }

        System.out.println("Digite outro número:");
        int numUser2 = scanner.nextInt();

        if (numUser == numUser2) {
            System.out.println("Seus números são iguais");
        } else {
            System.out.println("Seus números são diferentes");

            if (numUser < numUser2) {
                System.out.println("O segundo número é maior que o primeiro");
            } else {
                System.out.println("O segundo é menor que o primeiro");
            }
        }

            System.out.println("""
                    Escolha uma das opções abaixo:

                    1. Calcular área do quadrado
                    2. Calcular área do círculo
                    """);
            int userEscolha = scanner.nextInt();

            if (userEscolha == 1) {
                int areaQuadrado = 20 * 15;
                System.out.printf("Digamos que o quadrado possui a Altura de 20m² e a Largura de 15m²," +
                        "para calcular a área do quadrado multiplicamos a Altura pela Largura como na fórmula " +
                        "A x L = áreaQuadrado, a área desse quadrado de exemplo é de %d", areaQuadrado);
            } else {
                double pi = 3.14;
                double circunferencia = (2 * pi) * 4;
                System.out.printf("Digamos que um círculo possui um raio de 4m² para calcular a circunferência " +
                        "do círculo multiplicamos o raio por π e então multiplicamos por 2 como na fórmula " +
                        " C = 2πr, a circunferência desse círculo de exemplo é de %.2f", circunferencia);
            }

        System.out.println("\nDigite um número para ser mostrado sua tabuada do 1 até o 10");
            int numTabuada = scanner.nextInt();

            for (int f = 1; f <= 10; f++) {
                System.out.println(numTabuada * f);
            }

        System.out.println("\nDigite um número para ser verificado se ele é par ou ímpar");
            int numParImpar = scanner.nextInt();
            if (numParImpar % 2 == 0){
                System.out.println("Ele é par");
            } else {
                System.out.println("Ele é ímpar");
            }

        System.out.println("\nDigite um número para ter seu fatorial calculado");
            int numFatorial = scanner.nextInt();
            long totalFator = numFatorial;

            while (numFatorial > 1) {
                int proximoFator = numFatorial - 1;
                totalFator *= proximoFator;
                numFatorial--;
            }
        System.out.printf("\nO resultado do fatorial é %d", totalFator);
    }
}
