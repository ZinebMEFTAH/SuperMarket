package gestion_des_ventes;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private int idVente;
    private String client;
    private String utilisateur;
    private List<ProduitVendu> produits;
    private double total;

    public Ticket(int idVente, String client, String utilisateur) {
        this.idVente = idVente;
        this.client = client;
        this.utilisateur = utilisateur;
        this.produits = new ArrayList<>();
        this.total = 0.0;
    }

    public void ajouterProduit(String nomProd, int quantite, double prixUnt) {
        produits.add(new ProduitVendu(nomProd, quantite, prixUnt));
        total += quantite * prixUnt;
    }

    public void afficher() {
        System.out.println("=== Ticket de Caisse ===");
        System.out.printf("ID Vente : %d%n", idVente);
        System.out.printf("Client : %s%n", client);
        System.out.printf("Utilisateur : %s%n", utilisateur);
        System.out.println("Produits :");
        for (ProduitVendu produit : produits) {
            System.out.printf(" - %s, Quantité : %d, Prix Unitaire : %.2f€, Total : %.2f€%n",
                produit.getNomProd(), produit.getQuantite(), produit.getPrixUnt(),
                produit.getQuantite() * produit.getPrixUnt());
        }
        System.out.printf("Total : %.2f€%n", total);
    }
}

class ProduitVendu {
    private String nomProd;
    private int quantite;
    private double prixUnt;

    public ProduitVendu(String nomProd, int quantite, double prixUnt) {
        this.nomProd = nomProd;
        this.quantite = quantite;
        this.prixUnt = prixUnt;
    }

    public String getNomProd() {
        return nomProd;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnt() {
        return prixUnt;
    }
}
