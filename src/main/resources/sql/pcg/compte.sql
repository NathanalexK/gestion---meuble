-- Insertion pour 10 Capital, réserves et assimilés
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle, montant, id_exercice)
VALUES (1, null, 10, 'Capital, réserves et assimilés'),
            (null, 10, 101, 'Capital'),
            (null, 10, 104, 'Primes liées au capital social') ,
            (null, 10, 105, 'Ecart d''évaluation'),
            (null, 10, 106, 'Réserves'),
            (null, 10, 107, 'Ecart d''équivalence'),
            (null, 10, 108, 'Compte de l''exploitant'),
            (null, 10, 109, 'Actionnaires, capital souscrit non appelé'),

       (1, null, 11, 'Report à nouveau'),
            (null, 11, 119, 'Report à nouveau solde débiteur'),
            (null, 11, 110, 'Report à nouveau solde créditeur'),

       (1, null, 12, 'Résultat de l''exercice'),
            (null, 12, 120, 'Résultat de l''exercice (bénéfice)'),
            (null, 12, 129, 'Résultat de l''exercice (perte)'),

       (1, null, 13, 'Produits et charges différés - hors cycle d''exploitation'),
            (null, 13, 131, 'Subventions d''équipement'),
            (null, 13, 132, 'Autres subventions d''investissement'),
            (null, 13, 133, 'Impôts différés actif'),
            (null, 13, 134, 'Impôts différés passif'),
            (null, 13, 138, 'Autres produits et charges différés'),

       (1, null, 15, 'Provisions pour charges - passifs non courants'),
            (null, 15, 153, 'Provisions pour pensions et obligations similaires'),
            (null, 15, 155, 'Provisions pour impôts'),
            (null, 15, 156, 'Provisions pour renouvellement des immobilisations (concession)'),
            (null, 15, 158, 'Autres provisions pour charges - passifs non courants'),

        (1, null, 16, 'Emprunts et dettes assimilés'),
            (null, 16, 161, 'Emprunts obligataires convertibles'),
            (null, 16, 163, 'Autres emprunts obligataires'),
            (null, 16, 164, 'Emprunts auprès des établissements de crédit'),
            (null, 16, 165, 'Dépôts et cautionnements reçus'),

INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle, montant, id_exercice)
VALUES
        (3, null, 20, 'Immobilisation Incorporelle'),
            (null, 20, 203, 'Frais de developpement immobilisable'),
            (null, 20, 204, 'Logiciel informatique et assimile'),
            (null, 20, 205, 'Concessions et droits similaires, brevets, licences, marques');













