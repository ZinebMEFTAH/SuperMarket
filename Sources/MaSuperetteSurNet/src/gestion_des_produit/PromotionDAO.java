package gestion_des_produit;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionDAO {

    // Ajouter une promotion

	public static void addPromotion(String nomPromo, String descPromo, double pourcentagePromo, String dateDebut, String dateFin) {
	    String sql = "INSERT INTO promotion (nomPromo, descPromo, pourcentagePromo, dateDebut, dateFin) VALUES (?, ?, ?, ?, ?)";
	    try (Connection conn = DBConnection.connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, nomPromo);
	        stmt.setString(2, descPromo);
	        stmt.setDouble(3, pourcentagePromo);
	        stmt.setDate(4, java.sql.Date.valueOf(dateDebut)); // Conversion String -> Date
	        stmt.setDate(5, java.sql.Date.valueOf(dateFin));   // Conversion String -> Date
	        stmt.executeUpdate();
	        System.out.println("Promotion ajoutée avec succès !");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

    
    
    
    

    // Récupérer toutes les promotions
    public static List<String> getAllPromotions() {
        List<String> promotions = new ArrayList<>();
        String sql = "SELECT * FROM promotion";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String promotion = "ID: " + rs.getInt("idPromo") +
                                   ", Nom: " + rs.getString("nomPromo") +
                                   ", Description: " + rs.getString("descPromo") +
                                   ", Pourcentage: " + rs.getDouble("pourcentagePromo") + "%" +
                                   ", Début: " + rs.getString("dateDebut") +
                                   ", Fin: " + rs.getString("dateFin");
                promotions.add(promotion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    // Modifier une promotion
    public static void updatePromotion(int idPromo, String nomPromo, String descPromo, double pourcentagePromo, String dateDebut, String dateFin) {
        String sql = "UPDATE promotion SET nomPromo = ?, descPromo = ?, pourcentagePromo = ?, dateDebut = ?, dateFin = ? WHERE idPromo = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomPromo);
            stmt.setString(2, descPromo);
            stmt.setDouble(3, pourcentagePromo);
            stmt.setString(4, dateDebut);
            stmt.setString(5, dateFin);
            stmt.setInt(6, idPromo);
            stmt.executeUpdate();
            System.out.println("Promotion mise à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer une promotion
    public static void deletePromotion(int idPromo) {
        String sql = "DELETE FROM promotion WHERE idPromo = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPromo);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " lignes supprimées dans la table 'promotion'.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 // Associer une promotion à un produit
    public static void addProduitToPromotion(int idPromo, int idProd) {
        String sql = "INSERT INTO produit_promotion (idPromo, idProd) VALUES (?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPromo);
            stmt.setInt(2, idProd);
            stmt.executeUpdate();
            System.out.println("Produit associé à la promotion avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
 // Lister les produits associés à une promotion
    public static void listProduitsForPromotion(int idPromo) {
        String sql = "SELECT p.idProduit, p.nomProd, p.descProd, p.catProd, p.prixVente " +
                     "FROM produit p " +
                     "JOIN produit_promotion pp ON p.idProduit = pp.idProd " +
                     "WHERE pp.idPromo = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPromo);
            ResultSet rs = stmt.executeQuery();
            System.out.println("=== Produits pour la Promotion ID: " + idPromo + " ===");
            while (rs.next()) {
                System.out.println("ID Produit: " + rs.getInt("idProduit") +
                                   ", Nom: " + rs.getString("nomProd") +
                                   ", Description: " + rs.getString("descProd") +
                                   ", Catégorie: " + rs.getString("catProd") +
                                   ", Prix: " + rs.getDouble("prixVente") + "€");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}
