-- Insertion pour 10 Capital, réserves et assimilés
--actif non-courant
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (1, null, 20, 'Immobilisations incorporelles'),
        (null, 20, 203, 'Frais de développement immobilisables'),
        (null, 20, 204, 'Logiciels informatiques et assimilés'),
        (null, 20, 205, 'Concessions et droits similaires, brevets, licences, marques'),
        (null, 20, 207, 'Fonds commercial'),
        (null, 20, 208, 'Autres immobilisations incorporelles'),

    (1, null, 21, 'Immobilisations corporelles'),
        (null, 21, 211, 'Terrains'),
        (null, 21, 212, 'Agencements et aménagements de terrain'),
        (null, 21, 213, 'Constructions'),
        (null, 21, 215, 'Installations techniques'),
        (null, 21, 218, 'Autres immobilisations corporelles'),

    (1, null, 22, 'Immobilisations mises en concession'),
        (null, 22, 221, 'Terrains en concession'),
        (null, 22, 222, 'Agencements et aménagements de terrain en concession'),
        (null, 22, 223, 'Constructions en concession'),
        (null, 22, 225, 'Installations techniques en concession'),
        (null, 22, 228, 'Autres immobilisations corporelles en concession'),
        (null, 22, 229, 'Droits du concédant'),

    (1, null, 23, 'Immobilisations en cours'),
        (null, 23, 232, 'Immobilisations corporelles en cours'),
        (null, 23, 237, 'Immobilisations incorporelles en cours'),
        (null, 23, 238, 'Avances et acomptes versés sur commandes d''immobilisations'),

    (1, null, 26, 'Participations et créances rattachées à des participations'),
        (null, 26, 261, 'Titres de participation'),
        (null, 26, 262, 'Autres formes de participations'),
        (null, 26, 265, 'Titres de participation évalués par équivalence'),
        (null, 26, 266, 'Créances rattachées à des participations groupe'),
        (null, 26, 267, 'Créances rattachées à des participations hors groupe'),
        (null, 26, 268, 'Créances rattachées à des sociétés en participation'),
        (null, 26, 269, 'Versements restant à effectuer sur titres de participation non libérés'),

    (1, null, 27, 'Autres immobilisations financières'),
        (null, 27, 271, 'Titres immobilisés autres que les titres immobilisés de l''activité de portefeuille'),
        (null, 27, 272, 'Titres représentatifs de droit de créance (obligations, bons)'),
        (null, 27, 273, 'Titres immobilisés de l''activité de portefeuille'),
        (null, 27, 274, 'Prêts'),
        (null, 27, 275, 'Dépôts et cautionnements versés'),
        (null, 27, 276, 'Autres créances immobilisées'),
        (null, 27, 277, 'Actions propres (ou parts propres)'),
        (null, 27, 279, 'Versements restant à effectuer sur titres immobilisés non libérés'),

    (1, null, 28, 'Amortissement des immobilisations'),
        (null, 28, 280, 'Amortissement des immobilisations incorporelles'),
        (null, 28, 281, 'Amortissement des immobilisations corporelles'),
        (null, 28, 282, 'Amortissement des immobilisations mises en concession'),

    (1, null, 29, 'Pertes de valeur sur immobilisations'),
        (null, 29, 290, 'Perte de valeur sur immobilisations incorporelles'),
        (null, 29, 291, 'Perte de valeur sur immobilisations corporelles'),
        (null, 29, 292, 'Dépréciation sur immobilisations mises en concession'),
        (null, 29, 293, 'Perte de valeur sur immobilisations en cours'),
        (null, 29, 296, 'Perte de valeur sur participations et créances rattachées à participations'),
        (null, 29, 297, 'Perte de valeur sur autres immobilisations financières');

--actif courant
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (2, null, 31, 'Matières premières et fournitures'),
        (null, 31, 601, 'Matières premières'),
        (null, 31, 602, 'Autres approvisionnements'),
        (null, 31, 606, 'Achats non stockés de matières et fournitures'),

    (2, null, 32, 'Autres approvisionnements'),
        (null, 32, 321, 'Matières consommables'),
        (null, 32, 322, 'Fournitures consommables'),
        (null, 32, 326, 'Emballages'),

    (2, null, 33, 'En cours de production de biens'),
        (null, 33, 331, 'Produits en cours'),
        (null, 33, 335, 'Travaux en cours'),

    (2, null, 34, 'En cours de production de services'),
        (null, 34, 341, 'Etudes en cours'),
        (null, 34, 345, 'Prestations de service en cours'),

    (2, null, 35, 'Stocks de produits'),
        (null, 35, 351, 'Produits intermédiaires'),
        (null, 35, 355, 'Produits finis'),
        (null, 35, 358, 'Produits résiduels ou matières de récupération (déchets, rebuts)'),

    (2, null, 37, 'Stocks de marchandises'),

    (2, null, 38, 'Stocks à l''extérieur (en cours de route, en dépôt ou en consignation)'),

    (2, null, 39, 'Pertes de valeur sur stocks et en cours'),
        (null, 39, 391, 'Pertes de valeur Matières premières et fournitures'),
        (null, 39, 392, 'Pertes de valeur Autres approvisionnements'),
        (null, 39, 393, 'Pertes de valeur En cours de production de biens'),
        (null, 39, 394, 'Pertes de valeur En cours de production de services'),
        (null, 39, 395, 'Pertes de valeur Stocks de produits'),
        (null, 39, 397, 'Pertes de valeur Stocks de marchandises'),
        (null, 39, 398, 'Pertes de valeur Stocks à l''extérieur'),

    (2, null, 40, 'Fournisseurs et comptes rattachés'),
        (null, 40, 409, 'Fournisseurs débiteurs : avances et acomptes, RRR à obtenir, autres créances'),

    (2, null, 41, 'Clients et comptes rattachés'),
        (null, 41, 411, 'Clients'),
        (null, 41, 413, 'Clients effets à recevoir'),
        (null, 41, 416, 'Clients douteux'),
        (null, 41, 417, 'Créances sur travaux non encore facturables'),
        (null, 41, 418, 'Clients - produits non encore facturés'),

    (2, null, 46, 'Débiteurs divers et créditeurs divers'),
        (null, 46, 462, 'Créances sur cessions d''immobilisations'),
        (null, 46, 465, 'Créances sur cessions de valeurs mobilières de placement'),
        (null, 46, 467, 'Autres comptes débiteurs ou créditeurs'),

    (2, null, 50, 'Valeurs mobilières de placement'),
        (null, 50, 501, 'Parts dans des entreprises liées'),
        (null, 50, 503, 'Actions'),
        (null, 50, 504, 'Autres titres conférant un droit de propriété'),
        (null, 50, 505, 'Obligations et bons émis par la société et rachetés par elle'),
        (null, 50, 506, 'Obligations'),
        (null, 50, 507, 'Bons du trésor et bons de caisse à court terme'),
        (null, 50, 508, 'Autres valeurs mobilières de placement et créances assimilées'),
        (null, 50, 509, 'Versements restant à effectuer sur VMP non libérées'),

    (2, null, 51, 'Banques, établissements financiers et assimilés'),
        (null, 51, 511, 'Valeurs à l''encaissement'),
        (null, 51, 512, 'Banques comptes courants'),
        (null, 51, 515, 'Caisse du Trésor Public et établissements publics'),
        (null, 51, 517, 'Autres organismes financiers'),
        (null, 51, 518, 'Intérêts courus'),
        (null, 51, 519, 'Concours bancaires courants'),

    (2, null, 52, 'Instruments de trésorerie'),

    (2, null, 53, 'Caisse'),

    (2, null, 54, 'Régies d''avances et accréditifs'),

    (2, null, 58, 'Virements internes'),
        (null, 58, 581, 'Virements de fonds'),
        (null, 58, 588, 'Autres virements internes'),

    (2, null, 59, 'Pertes de valeur sur comptes financiers'),
        (null, 59, 591, 'Pertes de valeur sur valeurs en banque et établissements financiers'),
        (null, 59, 594, 'Pertes de valeur sur régies d''avances et accréditifs');

--passif non-courant
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (3, null, 15, 'Provisions pour charges - passifs non courants'),
        (null, 15, 153, 'Provisions pour pensions et obligations similaires'),
        (null, 15, 155, 'Provisions pour impôts'),
        (null, 15, 156, 'Provisions pour renouvellement des immobilisations (concession)'),
        (null, 15, 158, 'Autres provisions pour charges - passifs non courants'),

   (3, null, 16, 'Emprunts et dettes assimilés'),
       (null, 16, 161, 'Emprunts obligataires convertibles'),
       (null, 16, 163, 'Autres emprunts obligataires'),
       (null, 16, 164, 'Emprunts auprès des établissements de crédit'),
       (null, 16, 165, 'Dépôts et cautionnements reçus'),
       (null, 16, 167, 'Dettes sur contrat de location-financement'),
       (null, 16, 168, 'Autres emprunts et dettes assimilés'),
       (null, 16, 169, 'Primes de remboursement des obligations'),

   (3, null, 17, 'Dettes rattachées à des participations'),
       (null, 17, 171, 'Dettes rattachées à des participations groupe'),
       (null, 17, 172, 'Dettes rattachées à des participations hors groupe'),
       (null, 17, 173, 'Dettes rattachées à des sociétés en participation'),
       (null, 17, 178, 'Autres dettes rattachées à des participations'),

   (3, null, 18, 'Comptes de liaison des établissements et sociétés en participation'),
       (null, 18, 181, 'Comptes de liaison entre établissements'),
       (null, 18, 188, 'Comptes de liaison entre sociétés en participation');

--passif courant
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (4, null, 400, 'Fournisseurs et comptes rattachés'),
        (null, 400, 401, 'Fournisseurs de biens et services'),
        (null, 400, 403, 'Fournisseurs effets à payer'),
        (null, 400, 404, 'Fournisseurs d''immobilisations'),
        (null, 400, 405, 'Fournisseurs d''immobilisations effets à payer'),
        (null, 400, 408, 'Fournisseurs factures non parvenues'),

    (4, null, 410, 'Clients et comptes rattachés'),
        (null, 410, 419, 'Clients créditeurs'),

    (4, null, 42, 'Personnel et comptes rattachés'),
        (null, 42, 421, 'Personnel, rémunérations dues'),
        (null, 42, 422, 'Fonds sociaux - œuvres sociales'),
        (null, 42, 425, 'Personnel, avances et acomptes accordés'),
        (null, 42, 426, 'Personnel, dépôts reçus'),
        (null, 42, 427, 'Personnel, oppositions'),
        (null, 42, 428, 'Personnel, charges à payer et produits à recevoir'),

    (4, null, 43, 'Organismes sociaux et comptes rattachés'),
        (null, 43, 431, 'Organismes sociaux A'),
        (null, 43, 432, 'Organismes sociaux B'),
        (null, 43, 438, 'Organismes sociaux, charges à payer'),

    (4, null, 44, 'Etat, collectivités publiques, organismes internationaux'),
        (null, 44, 441, 'Etat, subventions à recevoir'),
        (null, 44, 442, 'Etat, impôts et taxes recouvrables sur des tiers'),
        (null, 44, 443, 'Opérations particulières avec l''Etat et autres organismes publics'),
        (null, 44, 444, 'Etat, impôts sur les résultats'),
        (null, 44, 445, 'Etat, taxes sur le chiffre d''affaires'),
        (null, 44, 447, 'Autres impôts, taxes et versements assimilés'),
        (null, 44, 448, 'Etat, charges à payer et produits à recevoir'),

    (4, null, 45, 'Groupe et Associés'),
        (null, 45, 451, 'Opérations Groupe'),
        (null, 45, 455, 'Associés - comptes courants'),
        (null, 45, 456, 'Associés, opérations sur le capital'),
        (null, 45, 457, 'Associés, dividendes à payer'),
        (null, 45, 458, 'Associés, opérations faites en commun ou en groupement'),

    (4, null, 460, 'Débiteurs divers et créditeurs divers'),
        (null, 460, 464, 'Dettes sur acquisitions de valeurs mobilières de placement'),
        (null, 460, 468, 'Divers charges à payer ou produits à recevoir'),

    (4, null, 47, 'Comptes transitoires ou d''attente'),

    (4, null, 48, 'Charges ou produits constatés d''avance et provisions'),
        (null, 48, 481, 'Provisions - passifs courants'),
        (null, 48, 486, 'Charges constatées d''avance'),
        (null, 48, 487, 'Produits constatés d''avance'),

    (4, null, 49, 'Pertes de valeur sur comptes de tiers'),
        (null, 49, 491, 'Pertes de valeur sur comptes de clients'),
        (null, 49, 495, 'Pertes de valeur sur comptes du groupe et des associés'),
        (null, 49, 496, 'Pertes de valeur sur comptes de débiteurs divers');

--charge
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (5, null, 60, 'Achats consommés'),
        (null, 60, 6010, 'Matières premières'),
        (null, 60, 6020, 'Autres approvisionnements'),
        (null, 60, 603, 'Variations des stocks'),
        (null, 60, 604, 'Achats d''études et de prestations de service'),
        (null, 60, 605, 'Achats de matériels, équipements et travaux'),
        (null, 60, 6060, 'Achats non stockés de matières et fournitures'),
        (null, 60, 607, 'Achats de marchandises'),
        (null, 60, 608, 'Frais accessoires d''achat'),
        (null, 60, 609, 'Rabais, remises, ristournes obtenus sur achats'),

    (5, null, 61, 'Services extérieurs'),
        (null, 61, 611, 'Sous-traitance générale'),
        (null, 61, 613, 'Locations'),
        (null, 61, 614, 'Charges locatives et charges de copropriété'),
        (null, 61, 615, 'Entretien, réparations et maintenance'),
        (null, 61, 616, 'Primes d''assurances'),
        (null, 61, 617, 'Etudes et recherches'),
        (null, 61, 618, 'Documentation et divers'),
        (null, 61, 619, 'Rabais, remises, ristournes obtenus sur services extérieurs'),

    (5, null, 62, 'Autres services extérieurs'),
        (null, 62, 621, 'Personnel extérieur à l''entreprise'),
        (null, 62, 622, 'Rémunérations d''intermédiaires et honoraires'),
        (null, 62, 623, 'Publicité, publication, relations publiques'),
        (null, 62, 624, 'Transports de biens et transport collectif du personnel'),
        (null, 62, 625, 'Déplacements, missions et réceptions'),
        (null, 62, 626, 'Frais postaux et de télécommunications'),
        (null, 62, 627, 'Services bancaires et assimilés'),
        (null, 62, 628, 'Cotisations et divers'),
        (null, 62, 629, 'Rabais, remises, ristournes obtenus sur autres services extérieurs'),

    (5, null, 63, 'Impôts, taxes et versements assimilés'),
        (null, 63, 631, 'Impôts, taxes et versements assimilés sur rémunérations'),
        (null, 63, 635, 'Autres impôts et taxes'),

    (5, null, 64, 'Charges de personnel'),
        (null, 64, 641, 'Rémunérations du personnel'),
        (null, 64, 644, 'Rémunérations des dirigeants'),
        (null, 64, 645, 'Cotisations aux organismes sociaux'),
        (null, 64, 646, 'Charges sociales sur rémunérations des dirigeants'),
        (null, 64, 647, 'Autres charges sociales'),
        (null, 64, 648, 'Autres charges de personnel'),

    (5, null, 65, 'Autres charges des activités ordinaires'),
        (null, 65, 651, 'Redevances pour concessions, brevets, licences, logiciels et valeurs similaires'),
        (null, 65, 652, 'Moins-values sur cessions d''actifs non courants'),
        (null, 65, 653, 'Jetons de présence'),
        (null, 65, 654, 'Pertes sur créances irrécouvrables'),
        (null, 65, 655, 'Quote-part de résultat sur opérations faites en commun'),
        (null, 65, 656, 'Amendes et pénalités, subventions accordées, dons et libéralités'),
        (null, 65, 657, 'Charges exceptionnelles de gestion courante'),
        (null, 65, 658, 'Autres charges de gestion courante'),

    (5, null, 66, 'Charges financières'),
        (null, 66, 661, 'Charges d''intérêts'),
        (null, 66, 664, 'Pertes sur créances liées à des participations'),
        (null, 66, 665, 'Moins-values sur titres de placement'),
        (null, 66, 666, 'Pertes de change'),
        (null, 66, 667, 'Moins-values sur instruments financiers et assimilés'),
        (null, 66, 668, 'Autres charges financières'),

    (5, null, 67, 'Eléments extraordinaires (charges)'),

    (5, null, 68, 'Dotations aux amortissements, provisions, pertes de valeur'),
        (null, 68, 681, 'Dotations - actifs non courants'),
        (null, 68, 685, 'Dotations - actifs courants'),

    (5, null, 69, 'Impôts sur les bénéfices'),
        (null, 69, 692, 'Imposition différée actif'),
        (null, 69, 693, 'Imposition différée passif'),
        (null, 69, 695, 'Impôts sur les bénéfices basés sur le résultat des activités ordinaires'),
        (null, 69, 698, 'Autres impôts sur les résultats');

--produit
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (6, null, 70, 'Ventes de produits fabriqués, marchandises, prestations'),
        (null, 70, 701, 'Ventes de produits finis'),
        (null, 70, 702, 'Ventes de produits intermédiaires'),
        (null, 70, 703, 'Ventes de produits résiduels'),
        (null, 70, 704, 'Vente de travaux'),
        (null, 70, 705, 'Vente d''études'),
        (null, 70, 706, 'Vente de prestations de service'),
        (null, 70, 707, 'Ventes de marchandises'),
        (null, 70, 708, 'Produits des activités annexes'),
        (null, 70, 709, 'Rabais, remises et ristournes accordés'),

    (6, null, 71, 'Production stockée (ou déstockage)'),
        (null, 71, 713, 'Variation de stocks d''en-cours'),
        (null, 71, 714, 'Variation de stocks de produits'),

    (6, null, 72, 'Production immobilisée'),
        (null, 72, 721, 'Production immobilisée d''actif incorporel'),
        (null, 72, 722, 'Production immobilisée d''actif corporel'),

    (6, null, 74, 'Subventions d''exploitation'),
        (null, 74, 741, 'Subvention d''équilibre'),
        (null, 74, 748, 'Autres subventions d''exploitation'),

    (6, null, 75, 'Autres produits opérationnels'),
        (null, 75, 751, 'Redevances pour concessions, brevets, licences, logiciels et valeurs similaires'),
        (null, 75, 752, 'Plus-values sur cessions d''actifs non courants'),
        (null, 75, 753, 'Jetons de présence et rémunérations d''administrateurs ou de gérant'),
        (null, 75, 754, 'Quotes-parts de subventions d''investissement virées au résultat de l''exercice'),
        (null, 75, 755, 'Quote-part de résultat sur opérations faites en commun'),
        (null, 75, 756, 'Libéralités perçues, rentrées sur créances amorties'),
        (null, 75, 757, 'Produits exceptionnels sur opérations de gestion'),
        (null, 75, 758, 'Autres produits de gestion courante'),

    (6, null, 76, 'Produits financiers'),
        (null, 76, 761, 'Produits de participations'),
        (null, 76, 762, 'Produits des autres immobilisations financières'),
        (null, 76, 763, 'Revenus des autres créances'),
        (null, 76, 764, 'Revenus et plus-values des valeurs mobilières de placement'),
        (null, 76, 766, 'Gains de change'),
        (null, 76, 767, 'Produits nets sur cessions de valeurs mobilières de placement'),
        (null, 76, 768, 'Autres produits financiers'),

    (6, null, 77, 'Eléments extraordinaires (produits)'),

    (6, null, 78, 'Reprises sur provisions et pertes de valeur'),
        (null, 78, 781, 'Reprise d''exploitation - actifs non courants'),
        (null, 78, 785, 'Reprise d''exploitation - actifs courants'),
        (null, 78, 786, 'Reprises financières');

--capitaux propre
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle)
VALUES
    (7, null, 10, 'Capital, réserves et assimilés'),
        (null, 10, 101, 'Capital'),
        (null, 10, 104, 'Primes liées au capital social') ,
        (null, 10, 105, 'Ecart d''évaluation'),
        (null, 10, 106, 'Réserves'),
        (null, 10, 107, 'Ecart d''équivalence'),
        (null, 10, 108, 'Compte de l''exploitant'),
        (null, 10, 109, 'Actionnaires, capital souscrit non appelé'),

    (7, null, 11, 'Report à nouveau'),
        (null, 11, 119, 'Report à nouveau solde débiteur'),
        (null, 11, 110, 'Report à nouveau solde créditeur'),

    (7, null, 12, 'Résultat de l''exercice'),
        (null, 12, 120, 'Résultat de l''exercice (bénéfice)'),
        (null, 12, 129, 'Résultat de l''exercice (perte)'),

    (7, null, 13, 'Produits et charges différés - hors cycle d''exploitation'),
        (null, 13, 131, 'Subventions d''équipement'),
        (null, 13, 132, 'Autres subventions d''investissement'),
        (null, 13, 133, 'Impôts différés actif'),
        (null, 13, 134, 'Impôts différés passif'),
        (null, 13, 138, 'Autres produits et charges différés');
