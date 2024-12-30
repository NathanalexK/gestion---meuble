CREATE TABLE poste(
    id_poste serial PRIMARY KEY ,
    libelle varchar(50),
    categorie smallint CHECK (categorie IN (0, 1, 2))
);

CREATE TABLE nom_poste(
    id_nom_poste serial PRIMARY KEY,
    id_poste_mere integer,
    libelle varchar(50),
    FOREIGN KEY (id_poste_mere) REFERENCES poste(id_poste)
);

CREATE TABLE poste_fille(
    id_poste_fille serial primary key ,
    id_mere integer,
    libelle varchar(50),
    montant DECIMAL(15,2),
    id_exercice integer,
    FOREIGN KEY (id_mere) REFERENCES poste(id_poste)
);
