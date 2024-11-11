create table role (
    id smallint primary key ,
    nom varchar(35)
);
alter table utilisateur add column id_role smallint references role(id);

insert into role(id, nom) values (1, 'DIRECTEUR');
insert into role(id, nom) values (2, 'FINANCE');
insert into role(id, nom) values (3, 'ACHAT');
insert into role(id, nom) values (4, 'VENTE');
insert into role(id, nom) values (5, 'INVENTAIRE');
insert into role(id, nom) values (6, 'PRODUCTION');
insert into role(id, nom) values (7, 'RH');


alter table besoin drop column id_demandeur;
alter table besoin add column id_departement INTEGER references role(id);

drop table produit;

create table produit (
    id serial primary key,
    nom varchar(50),
    id_unite_oeuvre integer references unite_oeuvre(id_unite_oeuvre),
    is_achat boolean,
    is_vente boolean
);

create table fabrication (
    id serial primary key,
    id_recette integer references recette_fabrication(id),
    date_debut date,
    statut int
);

create table recette_fabrication (
    id serial primary key,
    id_produit_fini integer references produit(id),
    id_matiere integer references produit(id),
    qte numeric(15,2)
);

alter table etat_stock drop column id_marchandise;
alter table etat_stock add column id_produit INTEGER references produit(id_produit);

alter table mouvement_stock drop column id_marchandise;
alter table mouvement_stock add column id_produit INTEGER references produit(id_produit);

alter table besoin drop column id_marchandise;
alter table besoin add column id_produit INTEGER references produit(id_produit);

alter table bon_commande_fille drop column id_marchandise;
alter table bon_commande_fille add column id_produit INTEGER references produit(id_produit);

-- alter table bon_commande_fille drop column id_marchandise;
alter table bon_commande_fille add column id_produit INTEGER references produit(id_produit);

alter table facture_fille drop column id_marchandise;
alter table facture_fille add column id_produit INTEGER references produit(id_produit);

alter table bon_reception_fille drop column id_marchandise;
alter table bon_reception_fille add column id_produit INTEGER references produit(id_produit);

alter table proformat_fille drop column id_marchandise;

-- drop table marchandise;

alter table produit drop column quantite;
alter table produit drop column id_centre;
alter table produit drop column date_sortie;
alter table produit drop column id_exercice;

alter table proformat add column etat integer default 0;

alter table bon_reception add column etat integer default 0;

alter table mouvement_stock add column entree numeric(15,2);
alter table mouvement_stock add column sortie numeric(15,2);

alter table etat_stock add column qte numeric(15,2);

alter table facture drop column date_facture;
alter table facture add column date_facture date;

alter table mouvement_stock add column designation varchar(100);

alter table mouvement_stock drop column quantite;
alter table mouvement_stock add column quantite numeric(15,2);

create table type_mvt (
    id smallint primary key,
    nom varchar(20)
);

insert into type_mvt values (0, 'ENTREE');
insert into type_mvt values (1, 'SORTIE');

alter table facture add column etat integer default 0;

select * from etat_stock where id_produit = 1 order by id_etat_stock desc whe;






