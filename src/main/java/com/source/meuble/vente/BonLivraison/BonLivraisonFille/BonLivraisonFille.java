package com.source.meuble.vente.BonLivraison.BonLivraisonFille;

import com.source.meuble.achat.BonReception.BonReception;
import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.vente.BonLivraison.BonLivraison;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bon_reception_fille")
public class BonLivraisonFille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_br_fille", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_br")
    private BonLivraison idBl;

    @Column(name = "quantite")
    private Double quantite;

    @Column(name = "prix")
    private Double prix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit idProduit;

}