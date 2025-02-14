package com.source.meuble.achat.proformat.proformatFille;

import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.achat.proformat.Proformat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "proformat_fille")
public class ProformatFille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proformat_fille", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proformat")
    private Proformat idProformat;


    @Column(name = "prix", precision = 18, scale = 2)
    private BigDecimal prix;

    @Column(name = "qte")
    private Double qte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit idMarchandise;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_produit")
//    private Produit idProduit;

}