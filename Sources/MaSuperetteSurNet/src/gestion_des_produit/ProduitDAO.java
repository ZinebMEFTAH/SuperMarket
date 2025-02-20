package gestion_des_produit;

import database.DBConnection;
import gestion_des_action.ActionLogUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    // Ajouter un produit
	public static void addProduit(String nomProd, String descProd, String catProd, double prixVente, int idLog) {
	    String sql = "INSERT INTO produit (nomProd, descProd, catProd, prixVente) VALUES (?, ?, ?, ?)";
	    try (Connection conn = DBConnection.connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, nomProd);
	        stmt.setString(2, descProd);
	        stmt.setString(3, catProd);
	        stmt.setDouble(4, prixVente);
	        stmt.executeUpdate();
	        System.out.println("Produit ajouté avec succès !");
	        
	        // Loguer l'action "Ajout de produit"
	        ActionLogUserDAO.logAction(1, idLog); // 1 est l'ID de l'action "Ajout de produit"
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	// Récupérer tous les produits avec toutes les informations
	public static List<String> getAllProduits() {
	    List<String> produits = new ArrayList<>();
	    String sql = "SELECT * FROM produit";
	    try (Connection conn = DBConnection.connect();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	        while (rs.next()) {
	            String produit = "ID: " + rs.getInt("idProduit") +
	                             ", Nom: " + rs.getString("nomProd") +
	                             ", Description: " + rs.getString("descProd") +
	                             ", Catégorie: " + rs.getString("catProd") +
	                             ", Prix: " + rs.getDouble("prixVente") + "€";
	            produits.add(produit);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produits;
	}

  

    // Rechercher un produit par ID
    public static void getProduitById(int id) {
        String sql = "SELECT * FROM produit WHERE idProduit = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Produit trouvé : " + rs.getString("nomProd") + " - " + rs.getDouble("prixVente") + "€");
            } else {
                System.out.println("Produit non trouvé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un produit
    public static void updateProduit(int id, String nomProd, String descProd, String catProd, double prixVente) {
        String sql = "UPDATE produit SET nomProd = ?, descProd = ?, catProd = ?, prixVente = ? WHERE idProduit = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomProd);
            stmt.setString(2, descProd);
            stmt.setString(3, catProd);
            stmt.setDouble(4, prixVente);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Produit mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un produit
    
    
    
    
    
    
    public static void deleteProduit(int id) {
        String deleteFromVenteSql = "DELETE FROM vente WHERE idLot IN (SELECT idLot FROM lot WHERE idProduit = ?)";
        String deleteFromLotSql = "DELETE FROM lot WHERE idProduit = ?";
        String deleteFromProduitPromotionSql = "DELETE FROM produit_promotion WHERE idProd = ?";
        String deleteFromContratSql = "DELETE FROM contrat WHERE idProduit = ?";
        String deleteProduitSql = "DELETE FROM produit WHERE idProduit = ?";

        try (Connection conn = DBConnection.connect()) {
            // Supprimer les références dans vente
            try (PreparedStatement stmt = conn.prepareStatement(deleteFromVenteSql)) {
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();
                System.out.println(rowsDeleted + " lignes supprimées dans la table 'vente'.");
            }

            // Supprimer les références dans lot
            try (PreparedStatement stmt = conn.prepareStatement(deleteFromLotSql)) {
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();
                System.out.println(rowsDeleted + " lignes supprimées dans la table 'lot'.");
            }

            // Supprimer les références dans produit_promotion
            try (PreparedStatement stmt = conn.prepareStatement(deleteFromProduitPromotionSql)) {
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();
                System.out.println(rowsDeleted + " lignes supprimées dans la table 'produit_promotion'.");
            }

            // Supprimer les références dans contrat
            try (PreparedStatement stmt = conn.prepareStatement(deleteFromContratSql)) {
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();
                System.out.println(rowsDeleted + " lignes supprimées dans la table 'contrat'.");
            }

            // Supprimer le produit
            try (PreparedStatement stmt = conn.prepareStatement(deleteProduitSql)) {
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();
                System.out.println(rowsDeleted + " lignes supprimées dans la table 'produit'.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    public static boolean produitExiste(String nomProd, String descProd, String catProd, double prixVente) {
        String sql = "SELECT COUNT(*) FROM produit WHERE nomProd = ? AND descProd = ? AND catProd = ? AND prixVente = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomProd);
            stmt.setString(2, descProd);
            stmt.setString(3, catProd);
            stmt.setDouble(4, prixVente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Le produit existe déjà
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Le produit n'existe pas
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}