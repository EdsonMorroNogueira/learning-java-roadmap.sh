package edu.curso1;

import java.util.Scanner;

public class Temperatura {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a temperatura em Celsius: ");
        double cel1 = scanner.nextDouble();

        double faren1 = (cel1 * 1.8) + 32;

        int faren1Convertido = (int) faren1;

        System.out.printf("Essa temperatura em Fahrenheit é %.2f", faren1);
        System.out.printf("\nConvertida para inteiro %d", faren1Convertido);

    }
}
