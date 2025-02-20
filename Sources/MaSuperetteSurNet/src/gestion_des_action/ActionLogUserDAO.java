package gestion_des_action;


import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActionLogUserDAO {

	public static void logAction(int idAction, int idLog) {
	    String checkSql = "SELECT COUNT(*) FROM actionloguser WHERE idaction = ? AND idlog = ?";
	    String insertSql = "INSERT INTO actionloguser (idaction, idlog) VALUES (?, ?)";

	    try (Connection conn = DBConnection.connect();
	         PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
	        
	        // Vérifiez si l'action est déjà loguée
	        checkStmt.setInt(1, idAction);
	        checkStmt.setInt(2, idLog);
	        ResultSet rs = checkStmt.executeQuery();
	        rs.next();
	        if (rs.getInt(1) > 0) {
	            System.out.println("L'action est déjà loguée pour cet utilisateur.");
	            return; // Ne pas insérer à nouveau
	        }

	        // Insérez si elle n'existe pas
	        try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
	            insertStmt.setInt(1, idAction);
	            insertStmt.setInt(2, idLog);
	            insertStmt.executeUpdate();
	            System.out.println("Action loguée avec succès !");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void listActionsByUser(int idUser) {
	    String sql = """
	        SELECT a.action, l.date, l.time
	        FROM ActionLogUser alu
	        JOIN action a ON alu.idAction = a.idAction
	        JOIN LogUser l ON alu.idLog = l.idLog
	        WHERE l.idUser = ?
	        ORDER BY l.date, l.time
	    """;

	    try (Connection conn = DBConnection.connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, idUser);
	        ResultSet rs = stmt.executeQuery();
	        System.out.println("=== Actions de l'utilisateur ===");
	        while (rs.next()) {
	            System.out.println("Action : " + rs.getString("action"));
	            System.out.println("Date   : " + rs.getDate("date"));
	            System.out.println("Heure  : " + rs.getTime("time"));
	            System.out.println("------------------------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
