package gestion_des_fournisseur;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDAO {

    // Ajouter un fournisseur
    public static void addFournisseur(String nomEntreprise, String adresse, String email) {
        String sql = "INSERT INTO fournisseur (NomEntreprise, F_Adresse, emailPrincipal) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomEntreprise);
            stmt.setString(2, adresse);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("Fournisseur ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Vérifier si un fournisseur existe
    public static boolean fournisseurExiste(String nomEntreprise) {
        String sql = "SELECT COUNT(*) FROM fournisseur WHERE NomEntreprise = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomEntreprise);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Récupérer tous les fournisseurs
 // Récupérer tous les fournisseurs avec toutes les informations
    public static List<String> getAllFournisseurs() {
        List<String> fournisseurs = new ArrayList<>();
        String sql = "SELECT * FROM fournisseur";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String fournisseur = "ID: " + rs.getInt("idFournisseur") +
                                     ", Nom: " + rs.getString("NomEntreprise") +
                                     ", Adresse: " + rs.getString("F_Adresse") +
                                     ", Email: " + rs.getString("emailPrincipal");
                fournisseurs.add(fournisseur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fournisseurs;
    }


    // Modifier un fournisseur
    public static void updateFournisseur(int id, String nomEntreprise, String adresse, String email) {
        String sql = "UPDATE fournisseur SET NomEntreprise = ?, F_Adresse = ?, emailPrincipal = ? WHERE idFournisseur = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomEntreprise);
            stmt.setString(2, adresse);
            stmt.setString(3, email);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Fournisseur mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
    
    
    
    
    
    
    
    public static void listerContactsParFournisseur(int idFournisseur) {
        String sql = """
            SELECT c.nomContact, c.prenomContact, c.fonction, c.email, c.tel
            FROM contact c
            JOIN fournisseur_contact fc ON c.idContact = fc.idContact
            WHERE fc.idFournisseur = ?;
        """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFournisseur);
            ResultSet rs = stmt.executeQuery();
            System.out.println("=== Contacts Associés au Fournisseur ===");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("Nom : %s, Prénom : %s, Fonction : %s, Email : %s, Téléphone : %s%n",
                        rs.getString("nomContact"), rs.getString("prenomContact"), rs.getString("fonction"),
                        rs.getString("email"), rs.getString("tel"));
            }
            if (!found) {
                System.out.println("Aucun contact associé à ce fournisseur.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    
}
