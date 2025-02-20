package gestion_des_utilisateurs;



import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogUserDAO {

    // Méthode pour insérer une connexion dans la table LogUser
    public static int addLogUser(int idUser) {
        String sql = "INSERT INTO loguser (idUser, date, time) VALUES (?, CURRENT_DATE, CURRENT_TIME) RETURNING idLog";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUser);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idLog"); // Retourne l'ID du log utilisateur
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retourne -1 si l'insertion échoue
    }
}
