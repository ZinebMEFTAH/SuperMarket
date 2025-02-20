package gestion_achat;

import database.DBConnection;
import java.sql.*;

public class LotDAO {

    // Ajouter un achat (lot)
    public static void ajouterAchat(int idProduit, int quantite, double prixUnitaire, String dateAchat, String datePeremption) {
        String sql = "INSERT INTO lot (idProduit, lotQuantite, prixUnt, dateAchat, datePeremption) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduit);
            stmt.setInt(2, quantite);
            stmt.setDouble(3, prixUnitaire);
            stmt.setDate(4, java.sql.Date.valueOf(dateAchat));
            stmt.setDate(5, java.sql.Date.valueOf(datePeremption));
            stmt.executeUpdate();
            System.out.println("Achat ajouté avec succès, stock réapprovisionné !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lister tous les lots
    public static void listerLots() {
        String sql = """
            SELECT l.idLot, p.nomProd, l.lotQuantite, l.prixUnt, l.dateAchat, l.datePeremption
            FROM lot l
            JOIN produit p ON l.idProduit = p.idProduit;
        """;
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("=== Liste des Lots ===");
            while (rs.next()) {
                System.out.printf("ID Lot : %d, Produit : %s, Quantité : %d, Prix Unitaire : %.2f€, Date Achat : %s, Date Péremption : %s%n",
                        rs.getInt("idLot"), rs.getString("nomProd"), rs.getInt("lotQuantite"),
                        rs.getDouble("prixUnt"), rs.getDate("dateAchat"), rs.getDate("datePeremption"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Produits en rupture de stock
    public static void produitsEnRuptureDeStock() {
        String sql = """
            SELECT p.nomProd, l.lotQuantite
            FROM lot l
            JOIN produit p ON l.idProduit = p.idProduit
            WHERE l.lotQuantite <= 0;
        """;
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("=== Produits en Rupture de Stock ===");
            while (rs.next()) {
                System.out.printf("Produit : %s, Stock Restant : %d%n",
                        rs.getString("nomProd"), rs.getInt("lotQuantite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    







public static void prixAchatMoyen() {
    String sql = """
        SELECT p.nomProd, AVG(l.prixUnt) AS prixMoyen
        FROM lot l
        JOIN produit p ON l.idProduit = p.idProduit
        GROUP BY p.nomProd;
    """;

    try (Connection conn = DBConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        System.out.println("=== Prix d'Achat Moyen par Produit ===");
        while (rs.next()) {
            System.out.printf("Produit : %s, Prix Moyen : %.2f€%n", rs.getString("nomProd"), rs.getDouble("prixMoyen"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}





public static void lotsProchesPeremption(int joursAvantPeremption) {
    String sql = """
        SELECT l.idLot, p.nomProd, l.datePeremption, l.lotQuantite
        FROM lot l
        JOIN produit p ON l.idProduit = p.idProduit
        WHERE l.datePeremption <= CURRENT_DATE + CAST(? AS INTEGER) * INTERVAL '1 day';
    """;

    try (Connection conn = DBConnection.connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, joursAvantPeremption); // Passe le paramètre en jours
        ResultSet rs = stmt.executeQuery();
        System.out.println("=== Lots Proches de la Date de Péremption ===");
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.printf("Lot ID : %d, Produit : %s, Date Péremption : %s, Quantité : %d%n",
                    rs.getInt("idLot"), rs.getString("nomProd"), rs.getDate("datePeremption"), rs.getInt("lotQuantite"));
        }
        if (!found) {
            System.out.println("Aucun lot proche de la date de péremption trouvé.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
























}