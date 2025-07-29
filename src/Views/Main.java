package Views;

import Controllers.PerfumeController;
import Models.Categoria;
import Models.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        PerfumeController perfumeController = new PerfumeController();

        while (true) {
            System.out.println("\n=== MENU PERFUMES ===");
            System.out.println("1 - Cadastrar perfume");
            System.out.println("2 - Listar perfumes");
            System.out.println("3 - Ver detalhes do perfume");
            System.out.println("4 - Remover perfume");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = scan.nextInt();
            scan.nextLine(); // limpa buffer

            switch (op) {
                case 1 -> perfumeController.cadastrarPerfume(produtos, categorias);
                case 2 -> perfumeController.listarPerfumes(produtos);
                case 3 -> perfumeController.verDetalhes(produtos);
                case 4 -> perfumeController.removerPerfume(produtos);
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
