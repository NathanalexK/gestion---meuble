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
    id_compte_mere integer,
    compte integer unique ,
    libelle text,
    FOREIGN KEY (id_mere) REFERENCES poste(id_poste),
    FOREIGN KEY (id_compte_mere) REFERENCES poste_fille(compte)
);

create table poste_fille_value(
    id serial primary key,
    compte integer,
    montant DECIMAL(15,2),
    id_exercice integer
);

pg_dump -U postgres -h localhost -p 5432 -F c -b -v -f "C:\Users\Miarantsoa\ITU\S5\Gestion entreprise\gestion-talent\src\main\resources\sql\030125.dmp mr_meuble"

pg_dump -U postgres -h localhost -p 5432 -F c -b -v -f "D:\travail\130125_2.dmp mr_meuble"
