create or replace view poste_cpl as
select * from poste join (select id_mere,sum(montant) as total from poste_fille group by id_mere) cpl on poste.id_poste = cpl.id_mere;