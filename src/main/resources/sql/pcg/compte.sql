-- Insertion pour 10 Capital, réserves et assimilés
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle, montant, id_exercice)
VALUES
--actif non-courant
    (1, null, 20, 'Immobilisations incorporelles', 0, 1),
        (null, 20, 203, 'Frais de développement immobilisables', 0, 1),
        (null, 20, 204, 'Logiciels informatiques et assimilés', 0, 1),
        (null, 20, 205, 'Concessions et droits similaires, brevets, licences, marques', 0, 1),
        (null, 20, 207, 'Fonds commercial', 0, 1),
        (null, 20, 208, 'Autres immobilisations incorporelles', 0, 1),

    (1, null, 21, 'Immobilisations corporelles', 0, 1),
        (null, 21, 211, 'Terrains', 0, 1),
        (null, 21, 212, 'Agencements et aménagements de terrain', 0, 1),
        (null, 21, 213, 'Constructions', 0, 1),
        (null, 21, 215, 'Installations techniques', 0, 1),
        (null, 21, 218, 'Autres immobilisations corporelles', 0, 1),

    (1, null, 22, 'Immobilisations mises en concession', 0, 1),
        (null, 22, 221, 'Terrains en concession', 0, 1),
        (null, 22, 222, 'Agencements et aménagements de terrain en concession', 0, 1),
        (null, 22, 223, 'Constructions en concession', 0, 1),
        (null, 22, 225, 'Installations techniques en concession', 0, 1),
        (null, 22, 228, 'Autres immobilisations corporelles en concession', 0, 1),
        (null, 22, 229, 'Droits du concédant', 0, 1),

    (1, null, 23, 'Immobilisations en cours', 0, 1),
        (null, 23, 232, 'Immobilisations corporelles en cours', 0, 1),
        (null, 23, 237, 'Immobilisations incorporelles en cours', 0, 1),
        (null, 23, 238, 'Avances et acomptes versés sur commandes d''immobilisations', 0, 1),

    (1, null, 26, 'Participations et créances rattachées à des participations', 0, 1),
        (null, 26, 261, 'Titres de participation', 0, 1),
        (null, 26, 262, 'Autres formes de participations', 0, 1),
        (null, 26, 265, 'Titres de participation évalués par équivalence', 0, 1),
        (null, 26, 266, 'Créances rattachées à des participations groupe', 0, 1),
        (null, 26, 267, 'Créances rattachées à des participations hors groupe', 0, 1),
        (null, 26, 268, 'Créances rattachées à des sociétés en participation', 0, 1),
        (null, 26, 269, 'Versements restant à effectuer sur titres de participation non libérés', 0, 1);

    (1, null, 27, 'Autres immobilisations financières', 0, 1),
        (null, 27, 271, 'Titres immobilisés autres que les titres immobilisés de l''activité de portefeuille', 0, 1),
        (null, 27, 272, 'Titres représentatifs de droit de créance (obligations, bons)', 0, 1),
        (null, 27, 273, 'Titres immobilisés de l''activité de portefeuille', 0, 1),
        (null, 27, 274, 'Prêts', 0, 1),
        (null, 27, 275, 'Dépôts et cautionnements versés', 0, 1),
        (null, 27, 276, 'Autres créances immobilisées', 0, 1),
        (null, 27, 277, 'Actions propres (ou parts propres)', 0, 1),
        (null, 27, 279, 'Versements restant à effectuer sur titres immobilisés non libérés', 0, 1),

    (1, null, 28, 'Amortissement des immobilisations', 0, 1),
        (null, 28, 280, 'Amortissement des immobilisations incorporelles', 0, 1),
        (null, 28, 281, 'Amortissement des immobilisations corporelles', 0, 1),
        (null, 28, 282, 'Amortissement des immobilisations mises en concession', 0, 1),

    (1, null, 29, 'Pertes de valeur sur immobilisations', 0, 1),
        (null, 29, 290, 'Perte de valeur sur immobilisations incorporelles', 0, 1),
        (null, 29, 291, 'Perte de valeur sur immobilisations corporelles', 0, 1),
        (null, 29, 292, 'Dépréciation sur immobilisations mises en concession', 0, 1),
        (null, 29, 293, 'Perte de valeur sur immobilisations en cours', 0, 1),
        (null, 29, 296, 'Perte de valeur sur participations et créances rattachées à participations', 0, 1),
        (null, 29, 297, 'Perte de valeur sur autres immobilisations financières', 0, 1);







--actif courant
    (2, null, 31, 'Matières premières et fournitures', 0, 1),
        (null, 31, 601, 'Matières premières', 0, 1),
        (null, 31, 602, 'Autres approvisionnements', 0, 1),
        (null, 31, 606, 'Achats non stockés de matières et fournitures', 0, 1),

    (2, null, 32, 'Autres approvisionnements', 0, 1),
        (null, 32, 321, 'Matières consommables', 0, 1),
        (null, 32, 322, 'Fournitures consommables', 0, 1),
        (null, 32, 326, 'Emballages', 0, 1),

    (2, null, 33, 'En cours de production de biens', 0, 1),
        (null, 33, 331, 'Produits en cours', 0, 1),
        (null, 33, 335, 'Travaux en cours', 0, 1),

    (2, null, 34, 'En cours de production de services', 0, 1),
        (null, 34, 341, 'Etudes en cours', 0, 1),
        (null, 34, 345, 'Prestations de service en cours', 0, 1),

    (2, null, 35, 'Stocks de produits', 0, 1),
        (null, 35, 351, 'Produits intermédiaires', 0, 1),
        (null, 35, 355, 'Produits finis', 0, 1),
        (null, 35, 358, 'Produits résiduels ou matières de récupération (déchets, rebuts)', 0, 1),

    (2, null, 37, 'Stocks de marchandises', 0, 1),

    (2, null, 38, 'Stocks à l''extérieur (en cours de route, en dépôt ou en consignation)', 0, 1),

    (2, null, 39, 'Pertes de valeur sur stocks et en cours', 0, 1),
        (null, 39, 391, 'Pertes de valeur Matières premières et fournitures', 0, 1),
        (null, 39, 392, 'Pertes de valeur Autres approvisionnements', 0, 1),
        (null, 39, 393, 'Pertes de valeur En cours de production de biens', 0, 1),
        (null, 39, 394, 'Pertes de valeur En cours de production de services', 0, 1),
        (null, 39, 395, 'Pertes de valeur Stocks de produits', 0, 1),
        (null, 39, 397, 'Pertes de valeur Stocks de marchandises', 0, 1),
        (null, 39, 398, 'Pertes de valeur Stocks à l''extérieur', 0, 1),

    (2, null, 40, 'Fournisseurs et comptes rattachés', 0, 1),
        (null, 40, 409, 'Fournisseurs débiteurs : avances et acomptes, RRR à obtenir, autres créances', 0, 1),

    (2, null, 41, 'Clients et comptes rattachés', 0, 1),
        (null, 41, 411, 'Clients', 0, 1),
        (null, 41, 413, 'Clients effets à recevoir', 0, 1),
        (null, 41, 416, 'Clients douteux', 0, 1),
        (null, 41, 417, 'Créances sur travaux non encore facturables', 0, 1),
        (null, 41, 418, 'Clients - produits non encore facturés', 0, 1),

    (2, null, 46, 'Débiteurs divers et créditeurs divers', 0, 1),
        (null, 46, 462, 'Créances sur cessions d''immobilisations', 0, 1),
        (null, 46, 465, 'Créances sur cessions de valeurs mobilières de placement', 0, 1),
        (null, 46, 467, 'Autres comptes débiteurs ou créditeurs', 0, 1),

    (2, null, 50, 'Valeurs mobilières de placement', 0, 1),
        (null, 50, 501, 'Parts dans des entreprises liées', 0, 1),
        (null, 50, 503, 'Actions', 0, 1),
        (null, 50, 504, 'Autres titres conférant un droit de propriété', 0, 1),
        (null, 50, 505, 'Obligations et bons émis par la société et rachetés par elle', 0, 1),
        (null, 50, 506, 'Obligations', 0, 1),
        (null, 50, 507, 'Bons du trésor et bons de caisse à court terme', 0, 1),
        (null, 50, 508, 'Autres valeurs mobilières de placement et créances assimilées', 0, 1),
        (null, 50, 509, 'Versements restant à effectuer sur VMP non libérées', 0, 1),

    (2, null, 51, 'Banques, établissements financiers et assimilés', 0, 1),
        (null, 51, 511, 'Valeurs à l''encaissement', 0, 1),
        (null, 51, 512, 'Banques comptes courants', 0, 1),
        (null, 51, 515, 'Caisse du Trésor Public et établissements publics', 0, 1),
        (null, 51, 517, 'Autres organismes financiers', 0, 1),
        (null, 51, 518, 'Intérêts courus', 0, 1),
        (null, 51, 519, 'Concours bancaires courants', 0, 1),

    (2, null, 52, 'Instruments de trésorerie', 0, 1),

    (2, null, 53, 'Caisse', 0, 1),

    (2, null, 54, 'Régies d''avances et accréditifs', 0, 1),

    (2, null, 58, 'Virements internes', 0, 1),
        (null, 58, 581, 'Virements de fonds', 0, 1),
        (null, 58, 588, 'Autres virements internes', 0, 1),

    (2, null, 59, 'Pertes de valeur sur comptes financiers', 0, 1),
        (null, 59, 591, 'Pertes de valeur sur valeurs en banque et établissements financiers', 0, 1),
        (null, 59, 594, 'Pertes de valeur sur régies d''avances et accréditifs', 0, 1);







--passif non-courant

    (3, null, 15, 'Provisions pour charges - passifs non courants', 0, 1),
        (null, 15, 153, 'Provisions pour pensions et obligations similaires', 0, 1),
        (null, 15, 155, 'Provisions pour impôts', 0, 1),
        (null, 15, 156, 'Provisions pour renouvellement des immobilisations (concession)', 0, 1),
        (null, 15, 158, 'Autres provisions pour charges - passifs non courants', 0, 1),

   (3, null, 16, 'Emprunts et dettes assimilés', 0, 1),
       (null, 16, 161, 'Emprunts obligataires convertibles', 0, 1),
       (null, 16, 163, 'Autres emprunts obligataires', 0, 1),
       (null, 16, 164, 'Emprunts auprès des établissements de crédit', 0, 1),
       (null, 16, 165, 'Dépôts et cautionnements reçus', 0, 1),
       (null, 16, 167, 'Dettes sur contrat de location-financement', 0, 1),
       (null, 16, 168, 'Autres emprunts et dettes assimilés', 0, 1),
       (null, 16, 169, 'Primes de remboursement des obligations', 0, 1),

   (3, null, 17, 'Dettes rattachées à des participations', 0, 1),
       (null, 17, 171, 'Dettes rattachées à des participations groupe', 0, 1),
       (null, 17, 172, 'Dettes rattachées à des participations hors groupe', 0, 1),
       (null, 17, 173, 'Dettes rattachées à des sociétés en participation', 0, 1),
       (null, 17, 178, 'Autres dettes rattachées à des participations', 0, 1),

   (3, null, 18, 'Comptes de liaison des établissements et sociétés en participation', 0, 1),
       (null, 18, 181, 'Comptes de liaison entre établissements', 0, 1),
       (null, 18, 188, 'Comptes de liaison entre sociétés en participation', 0, 1);





--passif courant

    (4, null, 40, 'Fournisseurs et comptes rattachés', 0, 1),
        (null, 40, 401, 'Fournisseurs de biens et services', 0, 1),
        (null, 40, 403, 'Fournisseurs effets à payer', 0, 1),
        (null, 40, 404, 'Fournisseurs d''immobilisations', 0, 1),
        (null, 40, 405, 'Fournisseurs d''immobilisations effets à payer', 0, 1),
        (null, 40, 408, 'Fournisseurs factures non parvenues', 0, 1),

    (4, null, 41, 'Clients et comptes rattachés', 0, 1),
        (null, 41, 419, 'Clients créditeurs', 0, 1),

    (4, null, 42, 'Personnel et comptes rattachés', 0, 1),
        (null, 42, 421, 'Personnel, rémunérations dues', 0, 1),
        (null, 42, 422, 'Fonds sociaux - œuvres sociales', 0, 1),
        (null, 42, 425, 'Personnel, avances et acomptes accordés', 0, 1),
        (null, 42, 426, 'Personnel, dépôts reçus', 0, 1),
        (null, 42, 427, 'Personnel, oppositions', 0, 1),
        (null, 42, 428, 'Personnel, charges à payer et produits à recevoir', 0, 1),

    (4, null, 43, 'Organismes sociaux et comptes rattachés', 0, 1),
        (null, 43, 431, 'Organismes sociaux A', 0, 1),
        (null, 43, 432, 'Organismes sociaux B', 0, 1),
        (null, 43, 438, 'Organismes sociaux, charges à payer', 0, 1),

    (4, null, 44, 'Etat, collectivités publiques, organismes internationaux', 0, 1),
        (null, 44, 441, 'Etat, subventions à recevoir', 0, 1),
        (null, 44, 442, 'Etat, impôts et taxes recouvrables sur des tiers', 0, 1),
        (null, 44, 443, 'Opérations particulières avec l''Etat et autres organismes publics', 0, 1),
        (null, 44, 444, 'Etat, impôts sur les résultats', 0, 1),
        (null, 44, 445, 'Etat, taxes sur le chiffre d''affaires', 0, 1),
        (null, 44, 447, 'Autres impôts, taxes et versements assimilés', 0, 1),
        (null, 44, 448, 'Etat, charges à payer et produits à recevoir', 0, 1);

    (4, null, 45, 'Groupe et Associés', 0, 1),
        (null, 45, 451, 'Opérations Groupe', 0, 1),
        (null, 45, 455, 'Associés - comptes courants', 0, 1),
        (null, 45, 456, 'Associés, opérations sur le capital', 0, 1),
        (null, 45, 457, 'Associés, dividendes à payer', 0, 1),
        (null, 45, 458, 'Associés, opérations faites en commun ou en groupement', 0, 1),

    (4, null, 46, 'Débiteurs divers et créditeurs divers', 0, 1),
        (null, 46, 464, 'Dettes sur acquisitions de valeurs mobilières de placement', 0, 1),
        (null, 46, 468, 'Divers charges à payer ou produits à recevoir', 0, 1),

    (4, null, 47, 'Comptes transitoires ou d''attente', 0, 1),

    (4, null, 48, 'Charges ou produits constatés d''avance et provisions', 0, 1),
        (null, 48, 481, 'Provisions - passifs courants', 0, 1),
        (null, 48, 486, 'Charges constatées d''avance', 0, 1),
        (null, 48, 487, 'Produits constatés d''avance', 0, 1),

    (4, null, 49, 'Pertes de valeur sur comptes de tiers', 0, 1),
        (null, 49, 491, 'Pertes de valeur sur comptes de clients', 0, 1),
        (null, 49, 495, 'Pertes de valeur sur comptes du groupe et des associés', 0, 1),
        (null, 49, 496, 'Pertes de valeur sur comptes de débiteurs divers', 0, 1);



--charge

    (5, null, 60, 'Achats consommés', 0, 1),
        (null, 60, 601, 'Matières premières', 0, 1),
        (null, 60, 602, 'Autres approvisionnements', 0, 1),
        (null, 60, 603, 'Variations des stocks', 0, 1),
        (null, 60, 604, 'Achats d''études et de prestations de service', 0, 1),
        (null, 60, 605, 'Achats de matériels, équipements et travaux', 0, 1),
        (null, 60, 606, 'Achats non stockés de matières et fournitures', 0, 1),
        (null, 60, 607, 'Achats de marchandises', 0, 1),
        (null, 60, 608, 'Frais accessoires d''achat', 0, 1),
        (null, 60, 609, 'Rabais, remises, ristournes obtenus sur achats', 0, 1),

        (5, null, 61, 'Services extérieurs', 0, 1),
        (null, 61, 611, 'Sous-traitance générale', 0, 1),
        (null, 61, 613, 'Locations', 0, 1),
        (null, 61, 614, 'Charges locatives et charges de copropriété', 0, 1),
        (null, 61, 615, 'Entretien, réparations et maintenance', 0, 1),
        (null, 61, 616, 'Primes d''assurances', 0, 1),
        (null, 61, 617, 'Etudes et recherches', 0, 1),
        (null, 61, 618, 'Documentation et divers', 0, 1),
        (null, 61, 619, 'Rabais, remises, ristournes obtenus sur services extérieurs', 0, 1),

        (5, null, 62, 'Autres services extérieurs', 0, 1),
        (null, 62, 621, 'Personnel extérieur à l''entreprise', 0, 1),
        (null, 62, 622, 'Rémunérations d''intermédiaires et honoraires', 0, 1),
        (null, 62, 623, 'Publicité, publication, relations publiques', 0, 1),
        (null, 62, 624, 'Transports de biens et transport collectif du personnel', 0, 1),
        (null, 62, 625, 'Déplacements, missions et réceptions', 0, 1),
        (null, 62, 626, 'Frais postaux et de télécommunications', 0, 1),
        (null, 62, 627, 'Services bancaires et assimilés', 0, 1),
        (null, 62, 628, 'Cotisations et divers', 0, 1),
        (null, 62, 629, 'Rabais, remises, ristournes obtenus sur autres services extérieurs', 0, 1),

        (5, null, 63, 'Impôts, taxes et versements assimilés', 0, 1),
        (null, 63, 631, 'Impôts, taxes et versements assimilés sur rémunérations', 0, 1),
        (null, 63, 635, 'Autres impôts et taxes', 0, 1),

        (5, null, 64, 'Charges de personnel', 0, 1),
        (null, 64, 641, 'Rémunérations du personnel', 0, 1),
        (null, 64, 644, 'Rémunérations des dirigeants', 0, 1),
        (null, 64, 645, 'Cotisations aux organismes sociaux', 0, 1),
        (null, 64, 646, 'Charges sociales sur rémunérations des dirigeants', 0, 1),
        (null, 64, 647, 'Autres charges sociales', 0, 1),
        (null, 64, 648, 'Autres charges de personnel', 0, 1),

        (5, null, 65, 'Autres charges des activités ordinaires', 0, 1),
        (null, 65, 651, 'Redevances pour concessions, brevets, licences, logiciels et valeurs similaires', 0, 1),
        (null, 65, 652, 'Moins-values sur cessions d''actifs non courants', 0, 1),
        (null, 65, 653, 'Jetons de présence', 0, 1),
        (null, 65, 654, 'Pertes sur créances irrécouvrables', 0, 1),
        (null, 65, 655, 'Quote-part de résultat sur opérations faites en commun', 0, 1),
        (null, 65, 656, 'Amendes et pénalités, subventions accordées, dons et libéralités', 0, 1),
        (null, 65, 657, 'Charges exceptionnelles de gestion courante', 0, 1),
        (null, 65, 658, 'Autres charges de gestion courante', 0, 1),

        (5, null, 66, 'Charges financières', 0, 1),
        (null, 66, 661, 'Charges d''intérêts', 0, 1),
        (null, 66, 664, 'Pertes sur créances liées à des participations', 0, 1),
        (null, 66, 665, 'Moins-values sur titres de placement', 0, 1),
        (null, 66, 666, 'Pertes de change', 0, 1),
        (null, 66, 667, 'Moins-values sur instruments financiers et assimilés', 0, 1),
        (null, 66, 668, 'Autres charges financières', 0, 1),

        (5, null, 67, 'Eléments extraordinaires (charges)', 0, 1),

        (5, null, 68, 'Dotations aux amortissements, provisions, pertes de valeur', 0, 1),
        (null, 68, 681, 'Dotations - actifs non courants', 0, 1),
        (null, 68, 685, 'Dotations - actifs courants', 0, 1),

        (5, null, 69, 'Impôts sur les bénéfices', 0, 1),
        (null, 69, 692, 'Imposition différée actif', 0, 1),
        (null, 69, 693, 'Imposition différée passif', 0, 1),
        (null, 69, 695, 'Impôts sur les bénéfices basés sur le résultat des activités ordinaires', 0, 1),
        (null, 69, 698, 'Autres impôts sur les résultats', 0, 1),




--produit

    (6, null, 70, 'Ventes de produits fabriqués, marchandises, prestations', 0, 1),
        (null, 70, 701, 'Ventes de produits finis', 0, 1),
        (null, 70, 702, 'Ventes de produits intermédiaires', 0, 1),
        (null, 70, 703, 'Ventes de produits résiduels', 0, 1),
        (null, 70, 704, 'Vente de travaux', 0, 1),
        (null, 70, 705, 'Vente d''études', 0, 1),
        (null, 70, 706, 'Vente de prestations de service', 0, 1),
        (null, 70, 707, 'Ventes de marchandises', 0, 1),
        (null, 70, 708, 'Produits des activités annexes', 0, 1),
        (null, 70, 709, 'Rabais, remises et ristournes accordés', 0, 1),

    (6, null, 71, 'Production stockée (ou déstockage)', 0, 1),
        (null, 71, 713, 'Variation de stocks d''en-cours', 0, 1),
        (null, 71, 714, 'Variation de stocks de produits', 0, 1),

    (6, null, 72, 'Production immobilisée', 0, 1),
        (null, 72, 721, 'Production immobilisée d''actif incorporel', 0, 1),
        (null, 72, 722, 'Production immobilisée d''actif corporel', 0, 1),

    (6, null, 74, 'Subventions d’exploitation', 0, 1),
        (null, 74, 741, 'Subvention d''équilibre', 0, 1),
        (null, 74, 748, 'Autres subventions d''exploitation', 0, 1),

    (6, null, 75, 'Autres produits opérationnels', 0, 1),
        (null, 75, 751, 'Redevances pour concessions, brevets, licences, logiciels et valeurs similaires', 0, 1),
        (null, 75, 752, 'Plus-values sur cessions d''actifs non courants', 0, 1),
        (null, 75, 753, 'Jetons de présence et rémunérations d''administrateurs ou de gérant', 0, 1),
        (null, 75, 754, 'Quotes-parts de subventions d''investissement virées au résultat de l''exercice', 0, 1),
        (null, 75, 755, 'Quote-part de résultat sur opérations faites en commun', 0, 1),
        (null, 75, 756, 'Libéralités perçues, rentrées sur créances amorties', 0, 1),
        (null, 75, 757, 'Produits exceptionnels sur opérations de gestion', 0, 1),
        (null, 75, 758, 'Autres produits de gestion courante', 0, 1);

    (6, null, 76, 'Produits financiers', 0, 1),
        (null, 76, 761, 'Produits de participations', 0, 1),
        (null, 76, 762, 'Produits des autres immobilisations financières', 0, 1),
        (null, 76, 763, 'Revenus des autres créances', 0, 1),
        (null, 76, 764, 'Revenus et plus-values des valeurs mobilières de placement', 0, 1),
        (null, 76, 766, 'Gains de change', 0, 1),
        (null, 76, 767, 'Produits nets sur cessions de valeurs mobilières de placement', 0, 1),
        (null, 76, 768, 'Autres produits financiers', 0, 1),

    (6, null, 77, 'Eléments extraordinaires (produits)', 0, 1),

    (6, null, 78, 'Reprises sur provisions et pertes de valeur', 0, 1),
        (null, 78, 781, 'Reprise d''exploitation - actifs non courants', 0, 1),
        (null, 78, 785, 'Reprise d''exploitation - actifs courants', 0, 1),
        (null, 78, 786, 'Reprises financières', 0, 1);





--capitaux propre

    (7, null, 10, 'Capital, réserves et assimilés', 0, 1),
        (null, 10, 101, 'Capital', 0, 1),
        (null, 10, 104, 'Primes liées au capital social', 0, 1) ,
        (null, 10, 105, 'Ecart d''évaluation', 0, 1),
        (null, 10, 106, 'Réserves', 0, 1),
        (null, 10, 107, 'Ecart d''équivalence', 0, 1),
        (null, 10, 108, 'Compte de l''exploitant', 0, 1),
        (null, 10, 109, 'Actionnaires, capital souscrit non appelé', 0, 1),

    (7, null, 11, 'Report à nouveau', 0, 1),
        (null, 11, 119, 'Report à nouveau solde débiteur', 0, 1),
        (null, 11, 110, 'Report à nouveau solde créditeur', 0, 1),

    (7, null, 12, 'Résultat de l''exercice', 0, 1),
        (null, 12, 120, 'Résultat de l''exercice (bénéfice)', 0, 1),
        (null, 12, 129, 'Résultat de l''exercice (perte)', 0, 1),

    (7, null, 13, 'Produits et charges différés - hors cycle d''exploitation', 0, 1),
        (null, 13, 131, 'Subventions d''équipement', 0, 1),
        (null, 13, 132, 'Autres subventions d''investissement', 0, 1),
        (null, 13, 133, 'Impôts différés actif', 0, 1),
        (null, 13, 134, 'Impôts différés passif', 0, 1),
        (null, 13, 138, 'Autres produits et charges différés', 0, 1),







