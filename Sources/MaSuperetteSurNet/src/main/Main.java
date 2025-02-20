package main;
import java.sql.Connection;
import java.sql.Statement;
import gestion_des_produit.ProduitDAO;
import gestion_des_produit.PromotionDAO;
import gestion_des_utilisateurs.UtilisateurDAO;
import gestion_des_ventes.Ticket;
import gestion_des_ventes.VenteDAO;
import database.DBConnection;
import gestion_achat.Achat;
import gestion_achat.LotDAO;
import gestion_des_client.ClientDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import gestion_des_fournisseur.ContratDAO;
import gestion_des_fournisseur.FournisseurDAO;

import java.util.Scanner;

import java.util.*;



import java.time.LocalDate;




public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	LocalDate dateAujourdhui = LocalDate.now();
        // Authentification avant d'afficher le menu
        if (!authentification(scanner)) {
            System.out.println("Échec de l'authentification. Programme terminé.");
            return;
        }

        int mainChoice;
        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("0. Gestion des Achats"); // Nouvelle option ajoutée
            System.out.println("1. Gestion des Produits");
            System.out.println("2. Gestion des Fournisseurs");
            System.out.println("3. Gestion des Promotions");
            System.out.println("4. Gestion des Ventes");
            System.out.println("5. Gestion des Clients");
            System.out.println("6. Gestion des Utilisateurs");
            System.out.println("7. Tableaux de Bord");
            System.out.println("8. Gestion des Contrats"); // Nouvelle option ajoutée
            System.out.println("9. Quitter");
            System.out.print("Votre choix : ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
            	case 0 -> gestionAchats(scanner); // Gestion des achats ajoutée
                case 1 -> gestionProduits(scanner);
                case 2 -> gestionFournisseurs(scanner);
                case 3 -> gestionPromotions(scanner);
                case 4 -> gestionVentes(scanner);
                case 5 -> gestionClients(scanner);
                case 6 -> gestionUtilisateurs(scanner);
                case 7 -> tableauxDeBord(scanner);
                case 8 -> gestionContrats(scanner); // Nouvelle gestion ajoutée
                case 9 -> {System.out.println("Au revoir !");
                System.exit(1);
                }
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (mainChoice != 8);
    }

    // Méthode d'authentification
  

    private static boolean authentification(Scanner scanner) {
        System.out.println("=== Authentification ===");
        System.out.print("Nom d'utilisateur : ");
        String username = scanner.next();
        System.out.print("Mot de passe : ");
        String password = scanner.next();

        utilisateurConnecteId = UtilisateurDAO.authenticateUser(username, password);
        if (utilisateurConnecteId > 0) {
            System.out.println("Connexion réussie !");
            return true;
        } else {
            System.out.println("Identifiants incorrects.");
            return false;
        }
    }

    
    
    
    
    
    

    // Sous-menu : Gestion des Produits
    private static void gestionProduits(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Produits ===");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Lister les produits");
            System.out.println("5. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
            case 1 -> {
                System.out.print("Nom du produit : ");
                scanner.nextLine(); // Consommer le saut de ligne
                String nomProd = scanner.nextLine();
                System.out.print("Description : ");
                String descProd = scanner.nextLine();
                System.out.print("Catégorie : ");
                String catProd = scanner.nextLine();
                System.out.print("Prix de vente : ");
                double prixVente = scanner.nextDouble();
                
                // Ajoutez l'ID de log pour suivre l'utilisateur
                int idLog = 1; // À remplacer par l'ID réel de l'utilisateur connecté
                
                ProduitDAO.addProduit(nomProd, descProd, catProd, prixVente, idLog);
                System.out.println("Produit ajouté avec succès !");
            }

                case 2 -> {
                    System.out.print("ID du produit à supprimer : ");
                    int id = scanner.nextInt();
                    ProduitDAO.deleteProduit(id);
                }
                case 3 -> {
                    System.out.print("ID du produit à modifier : ");
                    int id = scanner.nextInt();
                    System.out.print("Nouveau nom du produit : ");
                    scanner.nextLine(); // Consomme la fin de ligne restante
                    String nomProd = scanner.nextLine();
                    System.out.print("Nouvelle description : ");
                    String descProd = scanner.nextLine();
                    System.out.print("Nouvelle catégorie : ");
                    String catProd = scanner.nextLine();
                    System.out.print("Nouveau prix de vente : ");
                    double prixVente = scanner.nextDouble();

                    ProduitDAO.updateProduit(id, nomProd, descProd, catProd, prixVente);
                }
                case 4 -> {
                    System.out.println("Liste des produits : ");
                    for (String produit : ProduitDAO.getAllProduits()) {
                        System.out.println(produit);
                    }
                }

                case 5 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 5);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Sous-menu : Gestion des Fournisseurs
    private static void gestionFournisseurs(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Fournisseurs ===");
            System.out.println("1. Ajouter un fournisseur");
           
            System.out.println("2. Modifier un fournisseur");
            System.out.println("3. Lister les fournisseurs");
            System.out.println("4. Lister les contacts d’un fournisseur");
            System.out.println("5. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nom de l'entreprise : ");
                    scanner.nextLine(); // Consomme la fin de ligne
                    String nomEntreprise = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Email principal : ");
                    String email = scanner.nextLine();

                    if (!FournisseurDAO.fournisseurExiste(nomEntreprise)) {
                        FournisseurDAO.addFournisseur(nomEntreprise, adresse, email);
                    } else {
                        System.out.println("Le fournisseur existe déjà !");
                    }
                }
    
                
                case 2 -> {
                    System.out.print("ID du fournisseur à modifier : ");
                    int id = scanner.nextInt();
                    System.out.print("Nouveau nom de l'entreprise : ");
                    scanner.nextLine(); // Consomme la fin de ligne
                    String nomEntreprise = scanner.nextLine();
                    System.out.print("Nouvelle adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Nouvel email principal : ");
                    String email = scanner.nextLine();

                    FournisseurDAO.updateFournisseur(id, nomEntreprise, adresse, email);
                }
                case 3 -> {
                    System.out.println("Liste des fournisseurs : ");
                    for (String fournisseur : FournisseurDAO.getAllFournisseurs()) {
                        System.out.println(fournisseur);
                    }
                }

                case 4 -> {
                    System.out.print("ID du fournisseur : ");
                    int idFournisseur = scanner.nextInt();
                    FournisseurDAO.listerContactsParFournisseur(idFournisseur);
                }
                
                
                case 5 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
                
            }
        } while (choice != 5);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    

    // Sous-menu : Gestion des Promotions
    private static void gestionPromotions(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Promotions ===");
            System.out.println("1. Ajouter une promotion");
            System.out.println("2. Supprimer une promotion");
            System.out.println("3. Modifier une promotion");
            System.out.println("4. Lister les promotions");
            System.out.println("5. Associer une promotion à un produit");
            System.out.println("6. Lister les produits pour une promotion");
            System.out.println("7. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nom de la promotion : ");
                    scanner.nextLine();
                    String nomPromo = scanner.nextLine();
                    System.out.print("Description : ");
                    String descPromo = scanner.nextLine();
                    System.out.print("Pourcentage de réduction : ");
                    double pourcentagePromo = scanner.nextDouble();
                    System.out.print("Date de début (YYYY-MM-DD) : ");
                    String dateDebut = scanner.next();
                    System.out.print("Date de fin (YYYY-MM-DD) : ");
                    String dateFin = scanner.next();

                    PromotionDAO.addPromotion(nomPromo, descPromo, pourcentagePromo, dateDebut, dateFin);
                }
                case 2 -> {
                    System.out.print("ID de la promotion à supprimer : ");
                    int idPromo = scanner.nextInt();
                    PromotionDAO.deletePromotion(idPromo);
                }
                case 3 -> {
                    System.out.print("ID de la promotion à modifier : ");
                    int idPromo = scanner.nextInt();
                    System.out.print("Nouveau nom de la promotion : ");
                    scanner.nextLine();
                    String nomPromo = scanner.nextLine();
                    System.out.print("Nouvelle description : ");
                    String descPromo = scanner.nextLine();
                    System.out.print("Nouveau pourcentage de réduction : ");
                    double pourcentagePromo = scanner.nextDouble();
                    System.out.print("Nouvelle date de début (YYYY-MM-DD) : ");
                    String dateDebut = scanner.next();
                    System.out.print("Nouvelle date de fin (YYYY-MM-DD) : ");
                    String dateFin = scanner.next();

                    PromotionDAO.updatePromotion(idPromo, nomPromo, descPromo, pourcentagePromo, dateDebut, dateFin);
                }
                case 4 -> {
                    System.out.println("Liste des promotions : ");
                    for (String promotion : PromotionDAO.getAllPromotions()) {
                        System.out.println(promotion);
                    }
                }
                case 5 -> {
                    System.out.print("ID de la promotion : ");
                    int idPromo = scanner.nextInt();
                    System.out.print("ID du produit : ");
                    int idProd = scanner.nextInt();

                    PromotionDAO.addProduitToPromotion(idPromo, idProd);
                }
                case 6 -> {
                    System.out.print("ID de la promotion : ");
                    int idPromo = scanner.nextInt();
                    PromotionDAO.listProduitsForPromotion(idPromo);
                }
                case 7 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 7);
    }

    
    
    
    
    
 // Variable globale pour l'utilisateur connecté
    private static int utilisateurConnecteId;

    private static void gestionVentes(Scanner scanner) {
        Ticket ticket = null; // Un seul ticket pour regrouper toutes les ventes
        int choice;

        do {
            System.out.println("\n=== Gestion des Ventes ===");
            System.out.println("1. Enregistrer une vente");
            System.out.println("2. Lister les ventes");
            System.out.println("3. Afficher le ticket de caisse");
            System.out.println("4. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Récupérer la date du jour automatiquement
                    String dateVente = LocalDate.now().toString();

                    System.out.print("ID du client : ");
                    int idClient = scanner.nextInt();
                    System.out.print("ID du lot vendu : ");
                    int idLot = scanner.nextInt();
                    System.out.print("Quantité vendue : ");
                    int quantite = scanner.nextInt();

                    // Vérifier le stock disponible
                    if (!VenteDAO.verifierStock(idLot, quantite)) {
                        System.out.println("Erreur : Stock insuffisant pour le lot sélectionné.");
                        break;
                    }

                    // Récupérer le prix unitaire depuis la base de données
                    double prixUnt = VenteDAO.getPrixUnitaire(idLot);
                    if (prixUnt < 0) { // Si le prix est introuvable
                        System.out.println("Erreur : Impossible de récupérer le prix unitaire pour ce lot.");
                        break;
                    }

                    // Ajouter la vente dans la base de données
                    VenteDAO.addVente(java.sql.Date.valueOf(dateVente), utilisateurConnecteId, idClient, idLot, quantite, prixUnt);

                    // Initialiser le ticket si ce n'est pas déjà fait
                    if (ticket == null) {
                        ticket = new Ticket(0, "Client #" + idClient, "Utilisateur #" + utilisateurConnecteId);
                    }

                    // Ajouter le produit au ticket
                    ticket.ajouterProduit("Produit #" + idLot, quantite, prixUnt);
                    System.out.println("Vente enregistrée et ajoutée au ticket !");
                }

                case 2 -> VenteDAO.listVentes(); // Liste toutes les ventes dans la base

                case 3 -> {
                    if (ticket == null) {
                        System.out.println("Aucun ticket généré pour cette session.");
                    } else {
                        ticket.afficher(); // Affiche le ticket unique
                    }
                }

                case 4 -> {
                    System.out.println("Retour au menu principal.");
                    ticket = null; // Réinitialise le ticket à la sortie
                }

                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 4);
    }

    
    
    
    
    

    // Sous-menu : Gestion des Clients
    private static void gestionClients(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Clients ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Modifier un client");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Lister les clients");
            System.out.println("5. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Prénom : ");
                    scanner.nextLine();
                    String prenom = scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();

                    ClientDAO.addClient(prenom, nom, email, tel, adresse);
                }
                case 2 -> {
                    System.out.print("ID du client à modifier : ");
                    int idClient = scanner.nextInt();
                    System.out.print("Nouveau prénom : ");
                    scanner.nextLine();
                    String prenom = scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Nouvel email : ");
                    String email = scanner.nextLine();
                    System.out.print("Nouveau téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Nouvelle adresse : ");
                    String adresse = scanner.nextLine();

                    ClientDAO.updateClient(idClient, prenom, nom, email, tel, adresse);
                }
                case 3 -> {
                    System.out.print("ID du client à supprimer : ");
                    int idClient = scanner.nextInt();
                    ClientDAO.deleteClient(idClient);
                }
                case 4 -> {
                    System.out.println("Liste des clients : ");
                    for (String client : ClientDAO.getAllClients()) {
                        System.out.println(client);
                    }
                }
                case 5 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 5);
    }

    
    
    
    
    
    
    
    
    
    
    

    // Sous-menu : Gestion des Utilisateurs
    private static void gestionUtilisateurs(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Utilisateurs ===");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Modifier un utilisateur");
            System.out.println("3. Supprimer un utilisateur");
            System.out.println("4. Lister les utilisateurs");
            System.out.println("5. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nom d'utilisateur : ");
                    scanner.nextLine();
                    String username = scanner.nextLine();
                    System.out.print("Hash du mot de passe : ");
                    String passwordHash = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Statut (active/inactive) : ");
                    String status = scanner.nextLine();
                    System.out.print("Rôle (admin/cashier) : ");
                    String role = scanner.nextLine();

                    UtilisateurDAO.addUtilisateur(username, passwordHash, email, prenom, nom, status, role);
                }
                case 2 -> {
                    System.out.print("ID de l'utilisateur à modifier : ");
                    int idUser = scanner.nextInt();
                    System.out.print("Nom d'utilisateur : ");
                    scanner.nextLine();
                    String username = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Statut : ");
                    String status = scanner.nextLine();
                    System.out.print("Rôle : ");
                    String role = scanner.nextLine();

                    UtilisateurDAO.updateUtilisateur(idUser, username, email, prenom, nom, status, role);
                }
                case 3 -> {
                    System.out.print("ID de l'utilisateur à supprimer : ");
                    int idUser = scanner.nextInt();
                    UtilisateurDAO.deleteUtilisateur(idUser);
                }
                case 4 -> {
                    System.out.println("Liste des utilisateurs : ");
                    for (String utilisateur : UtilisateurDAO.getAllUtilisateurs()) {
                        System.out.println(utilisateur);
                    }
                }
                case 5 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 5);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
 // Sous-menu : Tableaux de Bord
    private static void tableauxDeBord(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Tableaux de Bord ===");
            System.out.println("1. Produits les Plus Vendus");
            System.out.println("2. Ventes par Client");
            System.out.println("3. État du Stock Actuel");
            System.out.println("4. Ventes par Utilisateur");
            System.out.println("5. Résultats du Jour");
            System.out.println("6. Résultats du Mois");
            System.out.println("7. Prix d'Achat Moyen par Produit");
            System.out.println("8. Lots Proches de la Date de Péremption");
            System.out.println("9. Retour au Menu Principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> VenteDAO.produitsLesPlusVendus();
                case 2 -> VenteDAO.ventesParClient();
                case 3 -> VenteDAO.etatStockActuel();
                case 4 -> VenteDAO.ventesParUtilisateur();
                case 5 -> VenteDAO.resultatsVentes("jour");
                case 6 -> VenteDAO.resultatsVentes("mois");
                case 7 -> LotDAO.prixAchatMoyen();
                case 8 -> {
                    System.out.print("Nombre de jours avant péremption : ");
                    int jours = scanner.nextInt();
                    LotDAO.lotsProchesPeremption(jours);
                }
                case 9 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 9);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Méthode pour lire un double de manière sécurisée
  

    private static double getDoubleInput(Scanner scanner) {
        scanner.useLocale(Locale.US); // Forcer l'utilisation du point comme séparateur décimal
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre décimal valide (exemple : 10.5) :");
            scanner.next(); // Consomme l'entrée invalide
        }
        return scanner.nextDouble();
    }
    
    
    
    
    
    private static void gestionAchats(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Achats ===");
            System.out.println("1. Ajouter un achat (lot)");
            System.out.println("2. Lister les lots");
            System.out.println("3. Produits en rupture de stock");
            System.out.println("4. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID du produit : ");
                    int idProduit = scanner.nextInt();
                    System.out.print("Quantité : ");
                    int quantite = scanner.nextInt();
                    System.out.print("Prix unitaire : ");
                    double prixUnitaire = scanner.nextDouble();
                    System.out.print("Date d'achat (YYYY-MM-DD) : ");
                    String dateAchat = scanner.next();
                    System.out.print("Date de péremption (YYYY-MM-DD) : ");
                    String datePeremption = scanner.next();

                    LotDAO.ajouterAchat(idProduit, quantite, prixUnitaire, dateAchat, datePeremption);
                }
                case 2 -> LotDAO.listerLots();
                case 3 -> LotDAO.produitsEnRuptureDeStock();
                case 4 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 4);
    }
    
    
    
    
    
    
    
    
    
    
    
    private static void gestionContrats(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Gestion des Contrats ===");
            System.out.println("1. Ajouter un contrat");
            System.out.println("2. Lister les contrats");
            System.out.println("3. Vérifier un contrat");
            System.out.println("4. Retour au menu principal");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID du fournisseur : ");
                    int idFournisseur = scanner.nextInt();
                    System.out.print("ID du produit : ");
                    int idProduit = scanner.nextInt();
                    System.out.print("Quantité minimale : ");
                    int minQuantite = scanner.nextInt();
                    System.out.print("Date de début (YYYY-MM-DD) : ");
                    String dateDebut = scanner.next();
                    System.out.print("Date de fin (YYYY-MM-DD) : ");
                    String dateFin = scanner.next();
                    System.out.print("Prix fixe : ");
                    double prixFixe = scanner.nextDouble();

                    ContratDAO.addContrat(idFournisseur, idProduit, minQuantite, dateDebut, dateFin, prixFixe);
                }
                case 2 -> ContratDAO.listContrats();
                case 3 -> {
                    System.out.print("ID du fournisseur : ");
                    int idFournisseur = scanner.nextInt();
                    System.out.print("ID du produit : ");
                    int idProduit = scanner.nextInt();
                    System.out.print("Quantité commandée : ");
                    int quantite = scanner.nextInt();

                    if (ContratDAO.verifierContrat(idFournisseur, idProduit, quantite)) {
                        System.out.println("Le contrat est respecté pour cette commande.");
                    } else {
                        System.out.println("Le contrat n'est pas respecté. Veuillez vérifier les conditions.");
                    }
                }
                case 4 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        } while (choice != 4);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}











