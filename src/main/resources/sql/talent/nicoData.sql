-- Insertion dans la table diplome
INSERT INTO diplome (libelle, niveau) VALUES
                                          ('Licence Informatique', 1),
                                          ('Master en Gestion', 2),
                                          ('Doctorat en Physique', 3);

-- Insertion dans la table moyen_pub
INSERT INTO moyen_pub (libelle, prix) VALUES
                                          ('Affiche publicitaire', 500.00),
                                          ('Publicité en ligne', 300.00),
                                          ('Spot radio', 250.00);

-- Insertion dans la table type_contrat
INSERT INTO type_contrat (nom, abreviation) VALUES
                                                (1, 'CDD'),
                                                (2, 'CDI'),
                                                (3, 'Freelance');

-- Insertion dans la table fournisseur_pub
INSERT INTO fournisseur_pub (nom, prix, contact) VALUES
                                                ('Agence MediaPro', 1500.00, '034 27 534 23'),
                                                ('Digital Ads', 800.00, '034 27 274 23'),
                                                ('Promotion360', 1200.00, '034 87 534 22');

-- Insertion dans la table besoin_recrutement
INSERT INTO besoin_recrutement (id_departement, date_demande, annees_experience, id_diplome) VALUES
                                                                                                 (1, '2024-01-15', 2, 1),
                                                                                                 (2, '2024-02-10', 5, 2),
                                                                                                 (3, '2024-03-05', 3, 3);

-- Insertion dans la table offre_emploi
INSERT INTO offre_emploi (date_publication, id_fournisseur_pub, id_besoin_recrutement) VALUES
                                                                                           ('2024-02-01', 1, 1),
                                                                                           ('2024-03-01', 2, 2),
                                                                                           ('2024-04-01', 3, 3);

-- Insertion dans la table cv
INSERT INTO cv (date_postulation, nom, prenom, date_naissance, adresse, annees_experience, id_offre_emploi, id_diplome) VALUES
                                                                                                                            ('2024-02-15', 'Dupont', 'Jean', '1990-05-10', '123 Rue A', 3, 1, 1),
                                                                                                                            ('2024-03-20', 'Martin', 'Paul', '1985-07-22', '456 Rue B', 5, 2, 2),
                                                                                                                            ('2024-04-18', 'Durand', 'Sophie', '1992-09-05', '789 Rue C', 1, 3, 3);

-- Insertion dans la table personnel
INSERT INTO personnel (nom, prenom, date_naissance, adresse, date_embauche, salaire, id_departement, poste, id_cv) VALUES
                                                                                                                       ('Dupont', 'Jean', '1990-05-10', '123 Rue A', '2024-05-01', 3000.00, 1, 'Développeur', 1),
                                                                                                                       ('Martin', 'Paul', '1985-07-22', '456 Rue B', '2024-06-01', 4500.00, 2, 'Gestionnaire', 2),
                                                                                                                       ('Durand', 'Sophie', '1992-09-05', '789 Rue C', '2024-07-01', 3200.00, 3, 'Chercheur', 3);

-- Insertion dans la table test
INSERT INTO test (date_test, id_cv) VALUES
                                        ('2024-03-01', 1),
                                        ('2024-04-01', 2),
                                        ('2024-05-01', 3);

-- Insertion dans la table resulat_test
INSERT INTO resulat_test (points, id_test) VALUES
                                               (85.50, 1),
                                               (90.00, 2),
                                               (75.25, 3);

-- Insertion dans la table entretien
INSERT INTO entretien (date_entretien, id_cv) VALUES
                                                  ('2024-03-10', 1),
                                                  ('2024-04-10', 2),
                                                  ('2024-05-10', 3);

-- Insertion dans la table contrat_employe
INSERT INTO contrat_employe (date_debut, date_fin, id_personnel, id_type) VALUES
                                                                              ('2024-05-01', '2025-05-01', 1, 1),
                                                                              ('2024-06-01', NULL, 2, 2),
                                                                              ('2024-07-01', '2024-12-31', 3, 3);

-- Insertion dans la table fournisseur_moyen
INSERT INTO fournisseur_moyen (id_moyen_pub, id_fournisseur_pub) VALUES
                                                                     (1, 1),
                                                                     (2, 2),
                                                                     (3, 3);
