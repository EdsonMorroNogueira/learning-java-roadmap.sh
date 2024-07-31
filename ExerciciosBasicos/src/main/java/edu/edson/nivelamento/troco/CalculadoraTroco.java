package edu.edson.nivelamento.troco;

import java.util.Scanner;

public class CalculadoraTroco {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quanto custa 1 unidade desse produto?");
        double unitPreco = scanner.nextDouble();

        System.out.println("Quantas unidades foram vendidas?");
        int unitQtd = scanner.nextInt();

        System.out.println("Quanto o cliente pagou?");
        double precoPago = scanner.nextDouble();

        double troco = calcularTroco(unitPreco, unitQtd, precoPago);
        System.out.println("Seu troco será de R$" + troco);

    }

    public static double calcularTroco(double precoUnidade, int qtdUnidade, double precoPago) {

        double precoTotal = precoUnidade * qtdUnidade;

       return precoPago - precoTotal;
    }
}
