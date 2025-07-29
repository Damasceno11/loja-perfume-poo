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
        Categoria categoria = encontrarOuCriarCategoria(categorias, "Perfume");

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

        System.out.println("✅ Perfume cadastrado com sucesso!");
    }

    public void listarPerfumes(ArrayList<Produto> produtos) {
        System.out.println("\n--- Lista de Perfumes ---");
        boolean encontrou = false;

        for (Produto p : produtos) {
            if (p instanceof Perfume) {
                System.out.println(p);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum perfume cadastrado.");
        }
    }

    public void verDetalhes(ArrayList<Produto> produtos) {
        System.out.print("Digite o nome do perfume para ver os detalhes: ");
        String nomeBusca = scan.nextLine().toLowerCase();

        boolean encontrou = false;
        for (Produto p : produtos) {
            if (p instanceof Perfume && p.getNome().toLowerCase().equals(nomeBusca)) {
                p.exibirDetalhes();
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Perfume não encontrado.");
        }
    }

    public void removerPerfume(ArrayList<Produto> produtos) {
        System.out.print("Digite o nome do perfume a ser removido: ");
        String nomeBusca = scan.nextLine().toLowerCase();

        boolean removido = produtos.removeIf(p -> p instanceof Perfume && p.getNome().toLowerCase().equals(nomeBusca));

        if (removido) {
            System.out.println("Perfume removido com sucesso.");
        } else {
            System.out.println("Perfume não encontrado.");
        }
    }

    public void pesquisarPerfume(ArrayList<Produto> produtos) {
        System.out.print("Digite nome ou característica para pesquisar: ");
        String termo = scan.nextLine().toLowerCase();

        boolean encontrou = false;
        System.out.println("\n--- Resultado da Pesquisa ---");

        for (Produto p : produtos) {
            if (p instanceof Perfume perfume) {
                if (
                        perfume.getNome().toLowerCase().contains(termo) ||
                                perfume.getDescricao().toLowerCase().contains(termo) ||
                                perfume.getFragrancia().toLowerCase().contains(termo) ||
                                perfume.getGenero().toLowerCase().contains(termo) ||
                                perfume.getFabricante().toLowerCase().contains(termo)
                ) {
                    System.out.println(perfume);
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum perfume encontrado com esse termo.");
        }
    }

    private Categoria encontrarOuCriarCategoria(ArrayList<Categoria> categorias, String nome) {
        for (Categoria c : categorias) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        Categoria nova = new Categoria(nome);
        categorias.add(nova);
        return nova;
    }

    private double lerDouble() {
        while (true) {
            try {
                String entrada = scan.nextLine().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite novamente (ex: 199.99): ");
            }
        }
    }


}
