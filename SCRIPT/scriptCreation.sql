-- Table Promotion
CREATE TABLE promotion (
    idPromo SERIAL PRIMARY KEY,
    nomPromo VARCHAR(50) NOT NULL,
    descPromo TEXT,
    pourcentagePromo NUMERIC(5, 2) CHECK (pourcentagePromo >= 0 AND pourcentagePromo <= 100),
    dateDebut DATE NOT NULL,
    dateFin DATE NOT NULL
);

-- Table Produit_Promotion (table de liaison)
CREATE TABLE produit_promotion (
    idPromo INT NOT NULL REFERENCES promotion(idPromo),
    idProd INT NOT NULL REFERENCES produit(idProduit),
    PRIMARY KEY (idPromo, idProd)
);

-- Table Contact
CREATE TABLE contact (
    idContact SERIAL PRIMARY KEY,
    nomContact VARCHAR(50) NOT NULL,
    prenomContact VARCHAR(50) NOT NULL,
    fonction VARCHAR(50),
    email VARCHAR(100),
    tel VARCHAR(15)
);

-- Table Fournisseur
CREATE TABLE fournisseur (
    idFournisseur SERIAL PRIMARY KEY,
    nomEntreprise VARCHAR(100) NOT NULL,
    F_Adresse TEXT NOT NULL,
    emailPrincipal VARCHAR(100) NOT NULL
);

-- Table Fournisseur_Contact (table de liaison)
CREATE TABLE fournisseur_contact (
    idContact INT NOT NULL REFERENCES contact(idContact),
    idFournisseur INT NOT NULL REFERENCES fournisseur(idFournisseur),
    PRIMARY KEY (idContact, idFournisseur)
);

-- Table Produit
CREATE TABLE produit (
    idProduit SERIAL PRIMARY KEY,
    nomProd VARCHAR(15) NOT NULL,
    descProd TEXT,
    catProd VARCHAR(50),
    prixVente NUMERIC(10, 2) NOT NULL
);

-- Table Lot
CREATE TABLE lot (
    idLot SERIAL PRIMARY KEY,
    idProduit INT NOT NULL REFERENCES produit(idProduit),
    lotQuantite INT NOT NULL,
    prixUnt NUMERIC(10, 2) NOT NULL,
    dateAchat DATE NOT NULL,
    datePeremption DATE
);

-- Table Client
CREATE TABLE client (
    idClient SERIAL PRIMARY KEY,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    email VARCHAR(100),
    tel VARCHAR(15),
    adresse TEXT
);

-- Table Vente
CREATE TABLE vente (
    idVente SERIAL PRIMARY KEY,
    dateVente DATE NOT NULL,
    idUser INT NOT NULL REFERENCES utilisateur(idUser),
    idClient INT NOT NULL REFERENCES client(idClient),
    idLot INT NOT NULL REFERENCES lot(idLot),
    Vquantite INT NOT NULL,
    prixUnt NUMERIC(10, 2) NOT NULL
);

-- Table Utilisateur
CREATE TABLE utilisateur (
    idUser SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    passwordHash VARCHAR(255) NOT NULL,
    uEmail VARCHAR(100),
    uPrenom VARCHAR(50),
    uNom VARCHAR(50),
    status VARCHAR(20),
    role VARCHAR(20)
);

-- Table LogUser
CREATE TABLE loguser (
    idLog SERIAL PRIMARY KEY,
    idUser INT NOT NULL REFERENCES utilisateur(idUser),
    date TIMESTAMP NOT NULL,
    time TIME NOT NULL
);

-- Table Action
CREATE TABLE action (
    idAction SERIAL PRIMARY KEY,
    action TEXT NOT NULL
);

-- Table ActionLogUser (table de liaison)
CREATE TABLE actionloguser (
    idAction INT NOT NULL REFERENCES action(idAction),
    idLog INT NOT NULL REFERENCES loguser(idLog),
    PRIMARY KEY (idAction, idLog)
);

-- Table Contrat
CREATE TABLE contrat (
    idContrat SERIAL PRIMARY KEY,
    idFournisseur INT NOT NULL REFERENCES fournisseur(idFournisseur),
    idProduit INT NOT NULL REFERENCES produit(idProduit),
    minQuantite INT NOT NULL,
    dateDebut DATE NOT NULL,
    dateFin DATE NOT NULL,
    prixFixe NUMERIC(10, 2) NOT NULL
);

-- Table UserRatingFournisseur
CREATE TABLE userratingfournisseur (
    idUser INT NOT NULL REFERENCES utilisateur(idUser),
    idFournisseur INT NOT NULL REFERENCES fournisseur(idFournisseur),
    rating INT CHECK (rating BETWEEN 1 AND 5),
    PRIMARY KEY (idUser, idFournisseur)
);
