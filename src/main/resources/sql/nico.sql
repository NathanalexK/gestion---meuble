CREATE TABLE diplome(
                        id_diplome SERIAL,
                        libelle VARCHAR(50)  NOT NULL,
                        niveau INTEGER NOT NULL,
                        PRIMARY KEY(id_diplome)
);

CREATE TABLE moyen_pub(
                          id_moyen_pub SERIAL,
                          libelle VARCHAR(50)  NOT NULL,
                          prix NUMERIC(18,2)   NOT NULL,
                          PRIMARY KEY(id_moyen_pub)
);

CREATE TABLE type_contrat(
                             id_type SERIAL,
                             nom SERIAL,
                             abreviation VARCHAR(50) ,
                             PRIMARY KEY(id_type)
);

CREATE TABLE fournisseur_pub(
                                id_fournisseur_pub SERIAL,
                                nom varchar(50),
                                contact VARCHAR(50) ,
                                prix NUMERIC(15,2)  ,
                                PRIMARY KEY(id_fournisseur_pub)
);

CREATE TABLE besoin_recrutement(
                                   id_besoin_recrutement SERIAL,
                                   id_role INTEGER NOT NULL,
                                   date_demande DATE NOT NULL,
                                   annees_experience INTEGER,
                                   id_diplome INTEGER NOT NULL,
                                   PRIMARY KEY(id_besoin_recrutement),
                                   FOREIGN KEY(id_diplome) REFERENCES diplome(id_diplome)
);

CREATE TABLE offre_emploi(
                             id_offre_emploi SERIAL,
                             date_publication DATE NOT NULL,
                             id_fournisseur_pub INTEGER,
                             id_besoin_recrutement INTEGER NOT NULL,
                             PRIMARY KEY(id_offre_emploi),
                             UNIQUE(id_besoin_recrutement),
                             FOREIGN KEY(id_fournisseur_pub) REFERENCES fournisseur_pub(id_fournisseur_pub),
                             FOREIGN KEY(id_besoin_recrutement) REFERENCES besoin_recrutement(id_besoin_recrutement)
);

CREATE TABLE cv(
                   id_cv SERIAL,
                   date_postulation DATE NOT NULL,
                   nom VARCHAR(255) ,
                   prenom VARCHAR(255) ,
                   date_naissance DATE,
                   adresse VARCHAR(255) ,
                   annees_experience INTEGER,
                   id_offre_emploi INTEGER NOT NULL,
                   id_diplome INTEGER NOT NULL,
                   PRIMARY KEY(id_cv),
                   FOREIGN KEY(id_offre_emploi) REFERENCES offre_emploi(id_offre_emploi),
                   FOREIGN KEY(id_diplome) REFERENCES diplome(id_diplome)
);

CREATE TABLE personnel(
                          id_personnel SERIAL,
                          nom VARCHAR(255) ,
                          prenom VARCHAR(255) ,
                          date_naissance DATE,
                          adresse VARCHAR(255) ,
                          date_embauche DATE,
                          salaire NUMERIC(15,2)  ,
                          id_departement INTEGER,
                          poste VARCHAR(50) ,
                          id_cv INTEGER NOT NULL,
                          PRIMARY KEY(id_personnel),
                          UNIQUE(id_cv),
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

CREATE TABLE resulat_test(
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

CREATE TABLE fournisseur_moyen(
                                  id_moyen_pub INTEGER,
                                  id_fournisseur_pub INTEGER,
                                  PRIMARY KEY(id_moyen_pub, id_fournisseur_pub),
                                  FOREIGN KEY(id_moyen_pub) REFERENCES moyen_pub(id_moyen_pub),
                                  FOREIGN KEY(id_fournisseur_pub) REFERENCES fournisseur_pub(id_fournisseur_pub)
);
