select (select sum(montant) as montant from poste_fille where id_mere = 5 and id_exercice =1)
           - (select sum(montant) as montant from poste_fille where id_mere = 6 and id_exercice =1) as montant;

select sum(montant) as montant from poste_fille where id_mere in (select id_poste from poste where categorie = 0) and id_exercice = 1 ;


select sum(montant) as montant from poste_fille where id_mere=4 and id_exercice=1;


SELECT sum(montant)
FROM poste_fille
WHERE LOWER(libelle) LIKE '%dette%'
   OR LOWER(libelle) LIKE '%emprunt%'
   OR LOWER(libelle) LIKE '%fournisseurs%'
    AND id_exercice=1
;

select (select montant from poste_fille where id_mere=5 and id_exercice=1)
           - (select montant from poste_fille where libelle='Charges d’exploitation' and id_exercice=1) as montant;

select sum(montant) as montant from poste_fille where id_mere=7 and id_exercice=1;

SELECT sum(montant)
FROM poste_fille
WHERE LOWER(libelle) LIKE '%stock%'
  AND id_exercice=1
;