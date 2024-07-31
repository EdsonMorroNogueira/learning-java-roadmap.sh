package edu.edson.nivelamento.loteria;

import java.util.Random;
import java.util.Scanner;

public class Loteria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Escolha um número entre 1 e 10:");
        int numEscolhido = scanner.nextInt();

        int contador = 1;
        String resposta = "";
        int numSorteado = 0;

        do {
            numSorteado = random.nextInt(11);

            if (numSorteado == numEscolhido) {
                if (contador <= 3) {
                    resposta = "Você é muito sortudo";
                } else if (contador < 10) {
                    resposta = "Você é sortudo";
                } else {
                    resposta = "É melhor você parar de apostar e ir trabalhar";
                }
                System.out.println(resposta);
                break;
            }

            contador++;
        }
        while (numSorteado != numEscolhido);
        }
    }
