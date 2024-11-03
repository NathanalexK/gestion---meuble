create table bon_livraison(
  id_bl serial primary key ,
  id_bc int,
  date_livraison date,
  etat integer ,
  foreign key (id_bc) references bon_commande(id_bc)
);


create table bon_livraison_fille(
        id_bl_fille serial primary key,
        id_bl int,
        id_produit int,
        quantite decimal(10,2),
        prix decimal(18,2),
        foreign key (id_bl) references bon_livraison(id_bl),
        foreign key (id_produit) references produit(id_produit)
);