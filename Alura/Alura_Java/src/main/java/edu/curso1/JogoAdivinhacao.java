package edu.curso1;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

    public static void main(String[] args) {

        System.out.println("Um número foi sorteado e você deve tentar descobrir qual ele é, o número vai de 0 à 100, vocẽ possui 5 chances");
        int numeroSorteado = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int tentativasAdivinhar = 0;
        boolean usuarioJogando = true;
        boolean usuarioGanhou = false;

        while (usuarioJogando) {
            System.out.println("\nDigite um número para tentar adivinhar o número sorteado:");
            int numeroUser = scanner.nextInt();
            if (numeroUser == numeroSorteado || tentativasAdivinhar == 5){
                if (numeroUser == numeroSorteado) {
                    usuarioGanhou = true;
                }
                break;

            } else {
                tentativasAdivinhar++;
                if (numeroUser > numeroSorteado) {
                    System.out.println("O número sorteado é menor do qual você digitou");
                } else {
                    System.out.println("O número sorteado é maior do qual você digitou");
                }
            }
        }

        if (usuarioGanhou) {
            System.out.printf("Parábens você acertou! O número era %d e você demorou %d tentativas até acertar", numeroSorteado, tentativasAdivinhar);
        } else {
            System.out.printf("Você não acertou! O número era %d", numeroSorteado);
        }
    }
}
