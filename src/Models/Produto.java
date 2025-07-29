package Models;

public class Produto {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(String nome, double preco, Categoria categoria) {
        this.id = contadorId++;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Categoria: " + categoria.getNome());
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (R$ " + preco + ") - " + categoria.getNome();
    }
}
