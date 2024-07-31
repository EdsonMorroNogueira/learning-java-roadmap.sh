package edu.edson.nivelamento.potencia;

import java.util.Scanner;

public class Potencia {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int base;
        int expoente;

        do {
            System.out.println("Digite a base da potência:");
            base = scanner.nextInt();

            System.out.println("Digite o expoente da potência:");
            expoente = scanner.nextInt();
        } while (base < 0 || expoente < 0);

        int potencia = base;

        for (int i = 1; i < expoente; i++){

            potencia = potencia * base;
        }

        System.out.println(potencia);
    }
}
