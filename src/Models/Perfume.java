package Models;

import java.util.ArrayList;
import java.util.List;

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

    public String getDescricao() {
        return descricao;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public String getGenero() {
        return genero;
    }

    public String getFabricante() {
        return fabricante;
    }

    public static List<Perfume> getPerfumesIniciais() {
        List<Perfume> perfumes = new ArrayList<>();
        Categoria categoria = new Categoria("Perfume");

        perfumes.add(new Perfume("Dior Sauvage", 549.90, categoria,
                "Notas de bergamota e ambroxan", "Amadeirada aromática", "Masculino", "Dior"));
        perfumes.add(new Perfume("Chanel N°5", 729.00, categoria,
                "Ícone da perfumaria com notas florais", "Floral aldeídica", "Feminino", "Chanel"));
        perfumes.add(new Perfume("Acqua di Gio", 399.00, categoria,
                "Notas aquáticas com incenso", "Aquática amadeirada", "Masculino", "Armani"));
        perfumes.add(new Perfume("La Vie Est Belle", 479.00, categoria,
                "Doce com íris, praliné e baunilha", "Floral gourmand", "Feminino", "Lancôme"));
        perfumes.add(new Perfume("212 VIP", 429.00, categoria,
                "Rum, maracujá e almíscar", "Oriental amadeirada", "Feminino", "Carolina Herrera"));
        perfumes.add(new Perfume("CK One", 299.00, categoria,
                "Fragrância cítrica leve e unissex", "Cítrica fresca", "Unissex", "Calvin Klein"));

        return perfumes;
    }
}



