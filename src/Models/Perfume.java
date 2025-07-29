package Models;

public class Perfume extends Produto {
    private String descricao;
    private String fragrancia;
    private String genero;
    private String fabricante;

    public Perfume(String nome, double preco, Categoria categoria,
                   String descricao, String fragrancia, String genero, String fabricante) {
        super(nome, preco, categoria);
        this.descricao = descricao;
        this.fragrancia = fragrancia;
        this.genero = genero;
        this.fabricante = fabricante;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Descrição: " + descricao);
        System.out.println("Fragrância: " + fragrancia);
        System.out.println("Gênero: " + genero);
        System.out.println("Fabricante: " + fabricante);
    }

    @Override
    public String toString() {
        return super.toString() + " - " + genero + " - " + fabricante;
    }
}

