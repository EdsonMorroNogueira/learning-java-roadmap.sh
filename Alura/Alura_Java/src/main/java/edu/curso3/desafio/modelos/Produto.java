package edu.curso3.desafio.modelos;

public class Produto implements Comparable<Produto> {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {

        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto outroProduto) {

        if (this.getPreco() < outroProduto.getPreco()) {
            return -1;
        } else if (this.getPreco() == outroProduto.getPreco()) {
            return 0;
        } else {
            return 1;
        }
    }
}
