package gestion_achat;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Achat {

    // Ajouter un achat et mettre à jour le stock
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
}
