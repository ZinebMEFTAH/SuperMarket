package gestion_des_fournisseur;



import database.DBConnection;
import java.sql.*;

public class ContratDAO {

    // Ajouter un contrat
    public static void addContrat(int idFournisseur, int idProduit, int minQuantite, String dateDebut, String dateFin, double prixFixe) {
        String sql = "INSERT INTO contrat (idFournisseur, idProduit, minQuantite, dateDebut, dateFin, prixFixe) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFournisseur);
            stmt.setInt(2, idProduit);
            stmt.setInt(3, minQuantite);
            stmt.setDate(4, java.sql.Date.valueOf(dateDebut));
            stmt.setDate(5, java.sql.Date.valueOf(dateFin));
            stmt.setDouble(6, prixFixe);
            stmt.executeUpdate();
            System.out.println("Contrat ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lister tous les contrats
    public static void listContrats() {
        String sql = """
            SELECT c.idContrat, f.nomEntreprise, p.nomProd, c.minQuantite, c.dateDebut, c.dateFin, c.prixFixe
            FROM contrat c
            JOIN fournisseur f ON c.idFournisseur = f.idFournisseur
            JOIN produit p ON c.idProduit = p.idProduit;
        """;
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("=== Liste des Contrats ===");
            while (rs.next()) {
                System.out.printf("ID Contrat : %d, Fournisseur : %s, Produit : %s, Min Quantité : %d, Début : %s, Fin : %s, Prix Fixe : %.2f€%n",
                        rs.getInt("idContrat"), rs.getString("nomEntreprise"), rs.getString("nomProd"),
                        rs.getInt("minQuantite"), rs.getDate("dateDebut"), rs.getDate("dateFin"), rs.getDouble("prixFixe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Vérifier si un contrat respecte la quantité minimale
    public static boolean verifierContrat(int idFournisseur, int idProduit, int quantite) {
        String sql = """
            SELECT minQuantite
            FROM contrat
            WHERE idFournisseur = ? AND idProduit = ? AND minQuantite <= ?;
        """;
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFournisseur);
            stmt.setInt(2, idProduit);
            stmt.setInt(3, quantite);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retourne vrai si le contrat est respecté
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
