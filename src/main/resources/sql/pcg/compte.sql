-- Insertion pour 10 Capital, réserves et assimilés
INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle, montant, id_exercice)
VALUES (1, null, 10, 'Capital, réserves et assimilés', 0, 1),
(1, null, 11, 'Report à nouveau', 0, 1),
(1, null, 12, 'Résultat de l''exercice', 0, 1),
(1, null, 13, 'Produits et charges différés - hors cycle d''exploitation', 0, 1),
(1, null, 15, 'Provisions pour charges - passifs non courants', 0, 1),
(1, null, 16, 'Emprunts et dettes assimilés', 0, 1);



INSERT INTO poste_fille (id_mere, id_compte_mere, compte, libelle, montant, id_exercice)
VALUES (null, 10, 101, 'Capital', 0, 1),
(null, 10, 104, 'Primes liées au capital social', 0, 1),
(null, 10, 105, 'Ecart d''évaluation', 0, 1),
(null, 10, 106, 'Réserves', 0, 1),
(null, 10, 107, 'Ecart d''équivalence', 0, 1),
(null, 10, 108, 'Compte de l''exploitant', 0, 1),
(null, 10, 109, 'Actionnaires, capital souscrit non appelé', 0, 1),



(null, 11, 110, 'Report à nouveau solde créditeur', 0, 1),
(null, 11, 119, 'Report à nouveau solde débiteur', 0, 1),


(null, 12, 120, 'Résultat de l''exercice (bénéfice)', 0, 1),
(null, 12, 129, 'Résultat de l''exercice (perte)', 0, 1),



(null, 13, 131, 'Subventions d''équipement', 0, 1),
(null, 13, 132, 'Autres subventions d''investissement', 0, 1),
(null, 13, 133, 'Impôts différés actif', 0, 1),
(null, 13, 134, 'Impôts différés passif', 0, 1),
(null, 13, 138, 'Autres produits et charges différés', 0, 1),


(null, 15, 153, 'Provisions pour pensions et obligations similaires', 0, 1),
(null, 15, 155, 'Provisions pour impôts', 0, 1),
(null, 15, 156, 'Provisions pour renouvellement des immobilisations (concession)', 0, 1),
(null, 15, 158, 'Autres provisions pour charges - passifs non courants', 0, 1),



(null, 16, 161, 'Emprunts obligataires convertibles', 0, 1),
(null, 16, 163, 'Autres emprunts obligataires', 0, 1),
(null, 16, 164, 'Emprunts auprès des établissements de crédit', 0, 1),
(null, 16, 165, 'Dépôts et cautionnements reçus', 0, 1);