package gestion_des_ventes;



import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class VenteDAO {

    // Ajouter une vente
	public static void addVente(Date dateVente, int idUser, int idClient, int idLot, int quantite, double prixUnt) {
	    String insertVenteSql = "INSERT INTO vente (dateVente, idUser, idClient, idLot, Vquantite, prixUnt) VALUES (?, ?, ?, ?, ?, ?)";
	    String updateStockSql = "UPDATE lot SET lotQuantite = lotQuantite - ? WHERE idLot = ?";

	    try (Connection conn = DBConnection.connect();
	         PreparedStatement venteStmt = conn.prepareStatement(insertVenteSql);
	         PreparedStatement stockStmt = conn.prepareStatement(updateStockSql)) {

	        // Enregistrer la vente
	        venteStmt.setDate(1, dateVente);
	        venteStmt.setInt(2, idUser);
	        venteStmt.setInt(3, idClient);
	        venteStmt.setInt(4, idLot);
	        venteStmt.setInt(5, quantite);
	        venteStmt.setDouble(6, prixUnt);
	        venteStmt.executeUpdate();

	        // Mettre à jour le stock
	        stockStmt.setInt(1, quantite);
	        stockStmt.setInt(2, idLot);
	        int rowsUpdated = stockStmt.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("Stock mis à jour avec succès !");
	        } else {
	            System.out.println("Erreur : le lot n'a pas été trouvé pour la mise à jour du stock.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


    // Lister les ventes
    public static void listVentes() {
        String sql = "SELECT v.idVente, v.dateVente, u.username, l.idProduit, l.prixUnt, v.Vquantite, v.prixUnt " +
                     "FROM vente v " +
                     "JOIN utilisateur u ON v.idUser = u.idUser " +
                     "JOIN lot l ON v.idLot = l.idLot";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("=== Liste des Ventes ===");
            while (rs.next()) {
                System.out.println("ID Vente: " + rs.getInt("idVente") +
                                   ", Date: " + rs.getDate("dateVente") +
                                   ", Utilisateur: " + rs.getString("username") +
                                   ", Produit (Lot): " + rs.getInt("idProduit") +
                                   ", Quantité: " + rs.getInt("Vquantite") +
                                   ", Prix Unitaire: " + rs.getDouble("prixUnt") + "€");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public static boolean verifierStock(int idLot, int quantite) {
        String sql = "SELECT lotQuantite FROM lot WHERE idLot = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLot);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int stockDisponible = rs.getInt("lotQuantite");
                return stockDisponible >= quantite; // Retourne true si le stock est suffisant
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false en cas d'erreur ou de stock insuffisant
    }

    
    
    public static void produitsLesPlusVendus() {
        String sql = """
            SELECT p.nomProd, SUM(v.Vquantite) AS total_vendu, SUM(v.Vquantite * v.prixUnt) AS chiffre_affaires
            FROM vente v
            JOIN lot l ON v.idLot = l.idLot
            JOIN produit p ON l.idProduit = p.idProduit
            GROUP BY p.nomProd
            ORDER BY total_vendu DESC
        """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("=== Produits les Plus Vendus ===");
            while (rs.next()) {
                System.out.printf("Produit : %s, Total Vendu : %d, Chiffre d'Affaires : %.2f€%n",
                    rs.getString("nomProd"),
                    rs.getInt("total_vendu"),
                    rs.getDouble("chiffre_affaires"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    public static void ventesParClient() {
        String sql = """
            SELECT c.prenom || ' ' || c.nom AS client, SUM(v.Vquantite) AS total_quantite, SUM(v.Vquantite * v.prixUnt) AS total_montant
            FROM vente v
            JOIN client c ON v.idClient = c.idClient
            GROUP BY c.prenom, c.nom
            ORDER BY total_montant DESC
        """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("=== Ventes par Client ===");
            while (rs.next()) {
                System.out.printf("Client : %s, Quantité Totale : %d, Montant Total : %.2f€%n",
                    rs.getString("client"),
                    rs.getInt("total_quantite"),
                    rs.getDouble("total_montant"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    
    public static void etatStockActuel() {
        String sql = """
            SELECT p.nomProd, l.lotQuantite AS stock_restant, l.datePeremption
            FROM lot l
            JOIN produit p ON l.idProduit = p.idProduit
            ORDER BY stock_restant ASC
        """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("=== État du Stock Actuel ===");
            while (rs.next()) {
                System.out.printf("Produit : %s, Stock Restant : %d, Date de Péremption : %s%n",
                    rs.getString("nomProd"),
                    rs.getInt("stock_restant"),
                    rs.getDate("datePeremption"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    
    public static void ventesParUtilisateur() {
        String sql = """
            SELECT u.username, COUNT(v.idVente) AS nombre_ventes
            FROM vente v
            JOIN utilisateur u ON v.idUser = u.idUser
            GROUP BY u.username
            ORDER BY nombre_ventes DESC
        """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("=== Ventes par Utilisateur ===");
            while (rs.next()) {
                System.out.printf("Utilisateur : %s, Nombre de Ventes : %d%n",
                    rs.getString("username"),
                    rs.getInt("nombre_ventes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    

    public static void ventesParPeriode(String dateDebut, String dateFin) {
        String sql = """
            SELECT p.nomProd, SUM(v.Vquantite) AS total_vendu, SUM(v.Vquantite * v.prixUnt) AS chiffre_affaires
            FROM vente v
            JOIN lot l ON v.idLot = l.idLot
            JOIN produit p ON l.idProduit = p.idProduit
            WHERE v.dateVente BETWEEN ? AND ?
            GROUP BY p.nomProd
            ORDER BY total_vendu DESC
        """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Convertir les chaînes en dates
            java.sql.Date sqlDateDebut = java.sql.Date.valueOf(dateDebut);
            java.sql.Date sqlDateFin = java.sql.Date.valueOf(dateFin);

            stmt.setDate(1, sqlDateDebut);
            stmt.setDate(2, sqlDateFin);

            ResultSet rs = stmt.executeQuery();
            System.out.println("=== Ventes par Période ===");
            while (rs.next()) {
                System.out.printf("Produit : %s, Total Vendu : %d, Chiffre d'Affaires : %.2f€%n",
                    rs.getString("nomProd"),
                    rs.getInt("total_vendu"),
                    rs.getDouble("chiffre_affaires"));
            }
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Erreur : Vérifiez les dates fournies (format attendu : YYYY-MM-DD).");
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static Ticket creerTicket(int idVente) {
        String sql = """
            SELECT v.idVente, c.prenom || ' ' || c.nom AS client, u.username AS utilisateur, 
                   p.nomProd, v.Vquantite, v.prixUnt
            FROM vente v
            JOIN lot l ON v.idLot = l.idLot
            JOIN produit p ON l.idProduit = p.idProduit
            JOIN client c ON v.idClient = c.idClient
            JOIN utilisateur u ON v.idUser = u.idUser
            WHERE v.idVente = ?;
        """;

        Ticket ticket = null;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticket = new Ticket(rs.getInt("idVente"), rs.getString("client"), rs.getString("utilisateur"));
                do {
                    ticket.ajouterProduit(rs.getString("nomProd"), rs.getInt("Vquantite"), rs.getDouble("prixUnt"));
                } while (rs.next());
            } else {
                System.out.println("Aucune vente trouvée pour cet ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    
    
    
    
    
    public static double getPrixUnitaire(int idLot) {
        String sql = "SELECT prixUnt FROM lot WHERE idLot = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLot);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("prixUnt");
            } else {
                System.out.println("Aucun lot trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retourne -1 si le prix est introuvable
    }

    
    
    public static void resultatsVentes(String periode) {
        String sql = switch (periode) {
            case "jour" -> """
                SELECT SUM(v.vquantite * v.prixUnt) AS totalVentes, 
                       SUM((v.prixUnt - l.prixUnt) * v.vquantite) AS totalBenefices
                FROM vente v
                JOIN lot l ON v.idLot = l.idLot
                WHERE v.dateVente = CURRENT_DATE;
            """;
            case "mois" -> """
                SELECT SUM(v.vquantite * v.prixUnt) AS totalVentes, 
                       SUM((v.prixUnt - l.prixUnt) * v.vquantite) AS totalBenefices
                FROM vente v
                JOIN lot l ON v.idLot = l.idLot
                WHERE EXTRACT(MONTH FROM v.dateVente) = EXTRACT(MONTH FROM CURRENT_DATE);
            """;
            default -> throw new IllegalArgumentException("Période invalide");
        };

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                System.out.printf("Total des ventes : %.2f€%n", rs.getDouble("totalVentes"));
                System.out.printf("Bénéfices : %.2f€%n", rs.getDouble("totalBenefices"));
            } else {
                System.out.println("Aucune vente trouvée pour cette période.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    public static void classementVentes() {
        String sql = """
            SELECT p.nomProd, SUM(v.quantite) AS totalQuantite, SUM(v.quantite * v.prixUnt) AS totalBenefices
            FROM vente v
            JOIN lot l ON v.idLot = l.idLot
            JOIN produit p ON l.idProduit = p.idProduit
            GROUP BY p.nomProd
            ORDER BY totalQuantite DESC
            LIMIT 10;
        """;

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("=== Classement des 10 Meilleures Ventes ===");
            while (rs.next()) {
                System.out.printf("Produit : %s, Quantité : %d, Bénéfices : %.2f€%n",
                        rs.getString("nomProd"), rs.getInt("totalQuantite"), rs.getDouble("totalBenefices"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
}
