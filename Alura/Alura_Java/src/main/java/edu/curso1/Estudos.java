package edu.curso1;

import edu.curso1.estudos.operacoes.Soma;
import edu.curso1.estudos.operacoes.Subtracao;

import java.util.Scanner;

public class Estudos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Primeiro número:");
        int num1 = scanner.nextInt();
        System.out.println("Digite o Segundo número:");
        int num2 = scanner.nextInt();

        Soma soma = new Soma();
        Subtracao subtracao = new Subtracao();

        System.out.println("A soma desses números é " + soma.somar(num1, num2));
        System.out.println("A subtração desses números é " + subtracao.subtrair(num1, num2));
    }
}
