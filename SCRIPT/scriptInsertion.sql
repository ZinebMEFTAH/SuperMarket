-- Table Utilisateur
INSERT INTO utilisateur (username, passwordHash, uEmail, uPrenom, uNom, status, role)
VALUES
('admin', 'hashpassword123', 'admin@superette.com', 'Admin', 'Super', 'active', 'admin'),
('syphax', '0000', 'syphax@gmail.com', 'Syphax', 'Nom', 'active', 'admin');

-- Table Client
INSERT INTO client (prenom, nom, email, tel, adresse)
VALUES
('Alice', 'Durand', 'alice@example.com', '0612345678', '10 rue de Paris'),
('Bob', 'Lemoine', 'bob@example.com', '0612345679', '15 avenue de Lyon');

-- Table Produit
INSERT INTO produit (nomProd, descProd, catProd, prixVente)
VALUES
('Pomme Golden', 'Fruit sucré et doré', 'Fruits', 1.50),
('Chocolat Noir', 'Chocolat 70% cacao', 'Snacks', 2.50);
INSERT INTO produit (nomProd, descProd, catProd, prixVente) VALUES
-- Électronique
('Apple iPhone 14', 'Smartphone 128 Go, écran OLED', 'Électronique', 999.99),
('Samsung Galaxy Tab S8', 'Tablette AMOLED, 11 pouces', 'Électronique', 749.99),
('Google Pixel 7', 'Smartphone avec Android pur, 128 Go', 'Électronique', 649.99),
('Apple Watch Series 8', 'Montre connectée avec capteur de température', 'Électronique', 429.99),
('Sony Bravia XR', 'Téléviseur OLED 55 pouces', 'Électronique', 1299.99),

-- Informatique
('MacBook Air M2', 'Ordinateur portable, puce M2', 'Informatique', 1249.99),
('HP Spectre x360', 'PC portable convertible tactile', 'Informatique', 1349.99),
('Dell XPS 13', 'Ultrabook haut de gamme, écran 4K', 'Informatique', 1499.99),
('Asus ROG Zephyrus', 'PC gamer avec RTX 3060', 'Informatique', 1799.99),
('Logitech MX Master 3', 'Souris ergonomique sans fil', 'Informatique', 99.99),

-- Audio
('Sony WH-1000XM5', 'Casque avec réduction de bruit', 'Audio', 399.99),
('Bose QuietComfort 45', 'Casque circum-aural Bluetooth', 'Audio', 329.99),
('JBL Flip 6', 'Enceinte portable étanche', 'Audio', 119.99),
('Apple AirPods Pro 2', 'Écouteurs Bluetooth avec ANC', 'Audio', 279.99),
('Marshall Emberton', 'Enceinte rétro portable', 'Audio', 149.99),

-- Jeux Vidéo
('PlayStation 5', 'Console de jeux nouvelle génération', 'Jeux Vidéo', 499.99),
('Xbox Series X', 'Console 4K UHD avec SSD', 'Jeux Vidéo', 499.99),
('Nintendo Switch OLED', 'Console hybride avec écran OLED', 'Jeux Vidéo', 349.99),
('FIFA 24', 'Jeu de football édition standard', 'Jeux Vidéo', 69.99),
('The Legend of Zelda: BOTW', 'Jeu d’action-aventure pour Nintendo Switch', 'Jeux Vidéo', 59.99),

-- Mode
('Nike Air Max 90', 'Chaussures de sport rétro', 'Mode', 139.99),
('Adidas Ultraboost Light', 'Chaussures de running Boost', 'Mode', 179.99),
('Levi’s 501 Original', 'Jean classique coupe droite', 'Mode', 89.99),
('The North Face Nuptse', 'Doudoune imperméable', 'Mode', 279.99),
('Gucci Marmont', 'Sac à main en cuir de luxe', 'Mode', 1999.99),

-- Maison
('Dyson Airwrap', 'Sèche-cheveux et fer à boucler', 'Maison', 549.99),
('Philips Airfryer XXL', 'Friteuse sans huile grande capacité', 'Maison', 299.99),
('iRobot Roomba i7+', 'Aspirateur robot connecté', 'Maison', 799.99),
('Nest Thermostat', 'Thermostat connecté intelligent', 'Maison', 249.99),
('Philips Hue Starter Kit', 'Kit d’éclairage connecté', 'Maison', 189.99),

-- Photographie
('Canon EOS R50', 'Appareil photo hybride 4K', 'Photographie', 899.99),
('DJI Mini 3 Pro', 'Drone compact avec caméra HDR', 'Photographie', 1099.99),
('GoPro HERO11 Black', 'Caméra d’action 5.3K', 'Photographie', 499.99),
('Sony Alpha a7 III', 'Appareil photo hybride plein format', 'Photographie', 1999.99),
('Nikon Z50', 'Appareil photo avec objectif 16-50mm', 'Photographie', 999.99),

-- Cuisine
('Nespresso Vertuo Next', 'Machine à café à capsules', 'Cuisine', 179.99),
('KitchenAid Artisan', 'Robot pâtissier avec bol inox', 'Cuisine', 699.99),
('Thermomix TM6', 'Robot cuiseur multifonction', 'Cuisine', 1399.99),
('Tefal Ingenio', 'Set de casseroles antiadhésives', 'Cuisine', 149.99),
('Smeg Blender', 'Blender design rétro', 'Cuisine', 249.99),

-- Sport
('Babolat Pure Aero', 'Raquette utilisée par Rafael Nadal', 'Sport', 229.99),
('Decathlon Rockrider ST 100', 'Vélo VTT tout terrain', 'Sport', 349.99),
('Nike Dri-FIT', 'T-shirt de sport respirant', 'Sport', 39.99),
('Fitbit Charge 5', 'Bracelet connecté pour fitness', 'Sport', 149.99),
('Adidas Predator Edge', 'Chaussures de football professionnelles', 'Sport', 229.99),

-- Livres
('Atomic Habits', 'Livre de développement personnel', 'Livres', 25.99),
('Dune', 'Roman de science-fiction par Frank Herbert', 'Livres', 19.99),
('Harry Potter à l’École des Sorciers', 'Roman fantastique pour enfants', 'Livres', 15.99),
('Le Petit Prince', 'Classique intemporel de Saint-Exupéry', 'Livres', 10.99),
('1984', 'Dystopie politique par George Orwell', 'Livres', 14.99),

-- Jouets
('LEGO Technic Ferrari', 'Maquette détaillée de Ferrari', 'Jouets', 399.99),
('Barbie Dreamhouse', 'Maison de poupée avec accessoires', 'Jouets', 299.99),
('Playmobil Château de Princes', 'Château de jeu pour enfants', 'Jouets', 149.99),
('Monopoly Classic', 'Jeu de société familial', 'Jouets', 39.99),
('Puzzle 3D Taj Mahal', 'Puzzle complexe de 3000 pièces', 'Jouets', 89.99);


-- Table Lot
INSERT INTO lot (idProduit, lotQuantite, prixUnt, dateAchat, datePeremption)
VALUES
(1, 100, 1.20, '2024-01-01', '2024-02-01'),
(2, 50, 2.30, '2024-01-02', '2024-03-01');

-- Table Fournisseur
INSERT INTO fournisseur (nomEntreprise, F_Adresse, emailPrincipal)
VALUES
('Fournisseur A', '123 Rue Exemple, Paris', 'contact@fournisseura.com'),
('Fournisseur B', '456 Avenue Exemple, Lyon', 'contact@fournisseurb.com');

-- Table Contact
INSERT INTO contact (nomContact, prenomContact, fonction, email, tel)
VALUES
('Dupont', 'Jean', 'Responsable', 'jean.dupont@exemple.com', '0601234567'),
('Martin', 'Sophie', 'Assistante', 'sophie.martin@exemple.com', '0607654321');

-- Table Fournisseur_Contact
INSERT INTO fournisseur_contact (idContact, idFournisseur)
VALUES
(1, 1),
(2, 2);

-- Table Promotion
INSERT INTO promotion (nomPromo, descPromo, pourcentagePromo, dateDebut, dateFin)
VALUES
('Promo Fruits', 'Réduction sur les fruits', 10.00, '2024-01-01', '2024-01-15'),
('Promo Snacks', 'Réduction sur les snacks', 15.00, '2024-01-10', '2024-01-20');

-- Table Produit_Promotion
INSERT INTO produit_promotion (idPromo, idProd)
VALUES
(1, 1),
(2, 2);

-- Table Contrat
INSERT INTO contrat (idFournisseur, idProduit, minQuantite, dateDebut, dateFin, prixFixe)
VALUES
(1, 1, 50, '2024-01-01', '2024-06-30', 1.00),
(2, 2, 30, '2024-02-01', '2024-07-31', 2.50);

-- Table Vente
INSERT INTO vente (dateVente, idUser, idClient, idLot, Vquantite, prixUnt)
VALUES
('2024-01-10', 1, 1, 1, 10, 1.20),
('2024-01-11', 2, 2, 2, 5, 2.30);

-- Table LogUser
INSERT INTO loguser (idUser, date, time)
VALUES
(1, '2024-01-10 10:00:00', '10:00:00'),
(2, '2024-01-11 11:00:00', '11:00:00');

-- Table Action
INSERT INTO action (action)
VALUES
('Ajout de produit'),
('Suppression de produit'),
('Ajout de client'),
('Connexion utilisateur');

-- Table ActionLogUser
INSERT INTO actionloguser (idAction, idLog)
VALUES
(1, 1),
(2, 2);

-- Table UserRatingFournisseur
INSERT INTO userratingfournisseur (idUser, idFournisseur, rating)
VALUES
(1, 1, 5),
(2, 2, 4);
