package gestion_des_client;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    // Ajouter un client
    public static void addClient(String prenom, String nom, String email, String tel, String adresse) {
        String sql = "INSERT INTO client (prenom, nom, email, tel, adresse) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prenom);
            stmt.setString(2, nom);
            stmt.setString(3, email);
            stmt.setString(4, tel);
            stmt.setString(5, adresse);
            stmt.executeUpdate();
            System.out.println("Client ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lister tous les clients
    public static List<String> getAllClients() {
        List<String> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String client = "ID: " + rs.getInt("idClient") +
                                ", Prénom: " + rs.getString("prenom") +
                                ", Nom: " + rs.getString("nom") +
                                ", Email: " + rs.getString("email") +
                                ", Téléphone: " + rs.getString("tel") +
                                ", Adresse: " + rs.getString("adresse");
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // Modifier un client
    public static void updateClient(int idClient, String prenom, String nom, String email, String tel, String adresse) {
        String sql = "UPDATE client SET prenom = ?, nom = ?, email = ?, tel = ?, adresse = ? WHERE idClient = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prenom);
            stmt.setString(2, nom);
            stmt.setString(3, email);
            stmt.setString(4, tel);
            stmt.setString(5, adresse);
            stmt.setInt(6, idClient);
            stmt.executeUpdate();
            System.out.println("Client mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un client
    public static void deleteClient(int idClient) {
        String sql = "DELETE FROM client WHERE idClient = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idClient);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " ligne(s) supprimée(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
