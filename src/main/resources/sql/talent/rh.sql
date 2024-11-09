CREATE TABLE diplome(
    id_diplome SERIAL,
    libelle VARCHAR(50)  NOT NULL,
    niveau INTEGER NOT NULL,
    PRIMARY KEY(id_diplome)
);

CREATE TABLE cv(
    id_cv SERIAL,
    date_postulation DATE NOT NULL,
    nom VARCHAR(255) ,
    prenom VARCHAR(255) ,
    date_naissance DATE,
    adresse VARCHAR(255) ,
    email VARCHAR(255) ,
    telephone VARCHAR(13) ,
    annees_experience INTEGER,
    id_diplome INTEGER NOT NULL,
    PRIMARY KEY(id_cv),
    FOREIGN KEY(id_diplome) REFERENCES diplome(id_diplome)
);

CREATE TABLE type_contrat(
    id_type SERIAL,
    nom VARCHAR(50) ,
    abreviation VARCHAR(50) ,
    PRIMARY KEY(id_type)
);

CREATE TABLE personnel(
    id_personnel SERIAL,
    nom VARCHAR(255) ,
    prenom VARCHAR(255) ,
    date_naissance DATE,
    adresse VARCHAR(255) ,
    email VARCHAR(255) ,
    telephone VARCHAR(13) ,
    date_embauche DATE,
    salaire NUMERIC(15,2)  ,
    id_role INTEGER,
    poste VARCHAR(50) ,
    id_cv INTEGER NOT NULL,
    PRIMARY KEY(id_personnel),
    UNIQUE(id_cv),
    FOREIGN KEY (id_role) REFERENCES role(id),
    FOREIGN KEY(id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE test(
    id_test SERIAL,
    date_test DATE,
    id_cv INTEGER,
    PRIMARY KEY(id_test),
    UNIQUE(id_cv),
    FOREIGN KEY(id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE resultat_test(
    id_resultat_test SERIAL,
    points NUMERIC(5,2)  ,
    id_test INTEGER NOT NULL,
    PRIMARY KEY(id_resultat_test),
    UNIQUE(id_test),
    FOREIGN KEY(id_test) REFERENCES test(id_test)
);

CREATE TABLE entretien(
    id_entretien SERIAL,
    date_entretien DATE,
    id_cv INTEGER NOT NULL,
    PRIMARY KEY(id_entretien),
    UNIQUE(id_cv),
    FOREIGN KEY(id_cv) REFERENCES cv(id_cv)
);

CREATE TABLE besoin_recrutement(
    id_besoin_recrutement SERIAL,
    id_role INTEGER NOT NULL,
    date_demande DATE NOT NULL,
    annees_experience INTEGER,
    id_diplome INTEGER NOT NULL,
    PRIMARY KEY(id_besoin_recrutement),
    FOREIGN KEY(id_diplome) REFERENCES diplome(id_diplome),
    FOREIGN KEY(id_role) REFERENCES role(id)
);

CREATE TABLE contrat_employe(
    id_contrat_employe SERIAL,
    date_debut DATE,
    date_fin DATE,
    id_personnel INTEGER NOT NULL,
    id_type INTEGER NOT NULL,
    PRIMARY KEY(id_contrat_employe),
    FOREIGN KEY(id_personnel) REFERENCES personnel(id_personnel),
    FOREIGN KEY(id_type) REFERENCES type_contrat(id_type)
);

CREATE TABLE Asso_17(
    id_besoin_recrutement INTEGER,
    id_cv INTEGER,
    PRIMARY KEY(id_besoin_recrutement, id_cv),
    FOREIGN KEY(id_besoin_recrutement) REFERENCES besoin_recrutement(id_besoin_recrutement),
    FOREIGN KEY(id_cv) REFERENCES cv(id_cv)
);
