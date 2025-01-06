create or replace view poste_cpl as
select row_number() over () as id, poste.id_poste as id_mere , coalesce(default_cpl.total, 0) as total from poste left join
(SELECT row_number() OVER ()     AS id,
poste_fille.id_mere,
sum(poste_fille.montant) AS total
FROM poste_fille
GROUP BY poste_fille.id_mere) as default_cpl
on poste.id_poste = default_cpl.id_mere