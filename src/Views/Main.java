package Views;

import Controllers.PerfumeController;
import Models.Categoria;
import Models.Perfume;
import Models.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        // Perfumes iniciais salvos para testar a pesquisa!
        for (Perfume perfume : Perfume.getPerfumesIniciais()) {
            produtos.add(perfume);
        }

        PerfumeController perfumeController = new PerfumeController();

        while (true) {
            System.out.println("\n=== MENU PERFUMES ===");
            System.out.println("1 - Cadastrar perfume");
            System.out.println("2 - Listar perfumes");
            System.out.println("3 - Ver detalhes do perfume");
            System.out.println("4 - Remover perfume");
            System.out.println("5 - Pesquisar perfume");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int op;
            try {
                op = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (op) {
                case 1 -> perfumeController.cadastrarPerfume(produtos, categorias);
                case 2 -> perfumeController.listarPerfumes(produtos);
                case 3 -> perfumeController.verDetalhes(produtos);
                case 4 -> perfumeController.removerPerfume(produtos);
                case 5 -> perfumeController.pesquisarPerfume(produtos);
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }


    }

}
