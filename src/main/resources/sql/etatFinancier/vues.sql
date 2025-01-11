create or replace view poste_cpl as
select * from poste join (select id_mere,sum(montant) as total from poste_fille group by id_mere) cpl on poste.id_poste = cpl.id_mere;

create or replace view poste_cpl as
select * from poste join (select id_mere,sum(somme_montant) as total from calculer_somme_poste_fille() group by id_mere) cpl on poste.id_poste = cpl.id_mere;









