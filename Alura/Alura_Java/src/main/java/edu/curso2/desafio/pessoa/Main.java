package edu.curso2.desafio.pessoa;

public class Main {

    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.ano = 1990;
        System.out.println(carro.getIdade());

        Aluno aluno = new Aluno();
        aluno.nome = "Clodoaldo";
        aluno.idade = 19;
        aluno.exibirInformacoes();
    }
}
