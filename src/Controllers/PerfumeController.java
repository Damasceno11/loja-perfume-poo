package Controllers;

import Models.Categoria;
import Models.Perfume;
import Models.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PerfumeController {
    private Scanner scan = new Scanner(System.in);

    public void cadastrarPerfume(ArrayList<Produto> produtos, ArrayList<Categoria> categorias) {
        Categoria categoria = encontrarOuCriarCategoria(categorias, "Perfumes");

        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.print("Preço: ");
        double preco = lerDouble();

        System.out.print("Descrição: ");
        String descricao = scan.nextLine();

        System.out.print("Fragrância: ");
        String fragrancia = scan.nextLine();

        System.out.print("Gênero: ");
        String genero = scan.nextLine();

        System.out.print("Fabricante: ");
        String fabricante = scan.nextLine();

        Perfume perfume = new Perfume(nome, preco, categoria, descricao, fragrancia, genero, fabricante);
        produtos.add(perfume);

        System.out.println("Perfume cadastrado com sucesso!");
    }

    public void listarPerfumes(ArrayList<Produto> produtos) {
        System.out.println("\n--- Lista de Perfumes ---");
        boolean encontrou = false;
        for (Produto p : produtos) {
            if (p.getCategoria().getNome().equalsIgnoreCase("Perfumes")) {
                System.out.println(p);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum perfume cadastrado.");
        }
    }

    public void verDetalhes(ArrayList<Produto> produtos) {
        listarPerfumes(produtos);
        System.out.print("ID do perfume para ver detalhes: ");
        int id = lerInt();

        for (Produto p : produtos) {
            if (p.getId() == id && p instanceof Perfume) {
                p.exibirDetalhes();
                return;
            }
        }
        System.out.println("Perfume não encontrado.");
    }

    public void removerPerfume(ArrayList<Produto> produtos) {
        listarPerfumes(produtos);
        System.out.print("ID do perfume para remover: ");
        int id = lerInt();

        boolean removido = produtos.removeIf(p -> p.getId() == id && p.getCategoria().getNome().equalsIgnoreCase("Perfumes"));

        if (removido) {
            System.out.println("Perfume removido.");
        } else {
            System.out.println("Perfume não encontrado.");
        }
    }

    private Categoria encontrarOuCriarCategoria(ArrayList<Categoria> categorias, String nome) {
        for (Categoria c : categorias) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        Categoria nova = new Categoria(nome);
        categorias.add(nova);
        return nova;
    }

    private int lerInt() {
        while (true) {
            try {
                int val = scan.nextInt();
                scan.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro válido:");
                scan.nextLine();
            }
        }
    }

    private double lerDouble() {
        while (true) {
            try {
                String entrada = scan.nextLine().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor decimal válido (ex: 299.99):");
            }
        }
    }
}
