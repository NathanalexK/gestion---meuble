INSERT INTO poste (libelle, categorie) VALUES
-- Bilan
('Actifs non courants', 0),
('Actifs courants', 0),
('Passifs non courants', 1),
('Passifs courants', 1),
-- Compte de résultat
('Revenus', 2),
('Charges', 2);


INSERT INTO nom_poste (id_poste_mere, libelle) VALUES
-- Actifs non courants
(1, 'Immobilisations corporelles'),
(1, 'Immobilisations incorporelles'),
-- Actifs courants
(2, 'Stocks'),
(2, 'Créances clients'),
(2, 'Trésorerie'),
-- Passifs non courants
(3, 'Emprunts bancaires'),
-- Passifs courants
(4, 'Fournisseurs'),
(4, 'Dettes fiscales et sociales'),
-- Revenus
(5, 'Chiffre d’affaires'),
-- Charges
(6, 'Charges d’exploitation'),
(6, 'Charges financières');


INSERT INTO poste_fille (id_mere, libelle, montant, id_exercice) VALUES
-- Actifs non courants
(1, 'Immobilisations corporelles', 500000.00, 2024),
(1, 'Immobilisations incorporelles', 100000.00, 2024),
-- Actifs courants
(2, 'Stocks', 80000.00, 2024),
(2, 'Créances clients', 120000.00, 2024),
(2, 'Trésorerie', 50000.00, 2024),
-- Passifs non courants
(3, 'Emprunts bancaires', 100000.00, 2024),
-- Passifs courants
(4, 'Fournisseurs', 30000.00, 2024),
(4, 'Dettes fiscales et sociales', 20000.00, 2024),
-- Revenus
(5, 'Chiffre d’affaires', 1000000.00, 2024),
-- Charges
(6, 'Charges d’exploitation', 700000.00, 2024),
(6, 'Charges financières', 20000.00, 2024);
