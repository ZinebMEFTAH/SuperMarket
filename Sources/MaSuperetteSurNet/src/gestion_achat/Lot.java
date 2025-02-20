package gestion_achat;

import java.sql.Date;

public class Lot {
    private int idLot;
    private int idProduit;
    private double prixUnt;
    private int lotQuantite;
    private Date dateAchat;
    private Date datePeremption;

    // Constructeur
    public Lot(int idLot, int idProduit, double prixUnt, int lotQuantite, Date dateAchat, Date datePeremption) {
        this.idLot = idLot;
        this.idProduit = idProduit;
        this.prixUnt = prixUnt;
        this.lotQuantite = lotQuantite;
        this.dateAchat = dateAchat;
        this.datePeremption = datePeremption;
    }

    // Getters et Setters
    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public double getPrixUnt() {
        return prixUnt;
    }

    public void setPrixUnt(double prixUnt) {
        this.prixUnt = prixUnt;
    }

    public int getLotQuantite() {
        return lotQuantite;
    }

    public void setLotQuantite(int lotQuantite) {
        this.lotQuantite = lotQuantite;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    // Méthode pour afficher les informations du lot
    public void afficher() {
        System.out.printf("ID Lot : %d, ID Produit : %d, Quantité : %d, Prix Unitaire : %.2f€, Date Achat : %s, Date Péremption : %s%n",
                idLot, idProduit, lotQuantite, prixUnt, dateAchat.toString(), datePeremption.toString());
    }
}
