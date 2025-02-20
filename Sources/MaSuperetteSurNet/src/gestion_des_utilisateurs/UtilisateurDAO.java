package gestion_des_utilisateurs;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {

    // Ajouter un utilisateur
    public static void addUtilisateur(String username, String passwordHash, String email, String prenom, String nom, String status, String role) {
        String sql = "INSERT INTO utilisateur (username, passwordHash, uEmail, uPrenom, uNom, status, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, passwordHash);
            stmt.setString(3, email);
            stmt.setString(4, prenom);
            stmt.setString(5, nom);
            stmt.setString(6, status);
            stmt.setString(7, role);
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lister tous les utilisateurs
    public static List<String> getAllUtilisateurs() {
        List<String> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String utilisateur = "ID: " + rs.getInt("idUser") +
                                     ", Nom d'utilisateur: " + rs.getString("username") +
                                     ", Email: " + rs.getString("uEmail") +
                                     ", Prénom: " + rs.getString("uPrenom") +
                                     ", Nom: " + rs.getString("uNom") +
                                     ", Statut: " + rs.getString("status") +
                                     ", Rôle: " + rs.getString("role");
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    // Modifier un utilisateur
    public static void updateUtilisateur(int idUser, String username, String email, String prenom, String nom, String status, String role) {
        String sql = "UPDATE utilisateur SET username = ?, uEmail = ?, uPrenom = ?, uNom = ?, status = ?, role = ? WHERE idUser = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, prenom);
            stmt.setString(4, nom);
            stmt.setString(5, status);
            stmt.setString(6, role);
            stmt.setInt(7, idUser);
            stmt.executeUpdate();
            System.out.println("Utilisateur mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un utilisateur
    public static void deleteUtilisateur(int idUser) {
        String sql = "DELETE FROM utilisateur WHERE idUser = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUser);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " ligne(s) supprimée(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    // Méthode pour vérifier les identifiants utilisateur
    public static int authenticateUser(String username, String password) {
        String sql = "SELECT idUser FROM utilisateur WHERE username = ? AND passwordHash = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idUser"); // Retourne l'ID de l'utilisateur si authentifié
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retourne -1 si l'authentification échoue
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
