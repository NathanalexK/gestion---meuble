package com.source.meuble.talent.offreEmploi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "fournisseur_pub")
public class FournisseurPub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fournisseur_pub", nullable = false)
    private Integer id;

    @Column(name = "contact", length = 50)
    private String contact;

    @Column(name = "prix", precision = 15, scale = 2)
    private BigDecimal prix;


    @Column(name = "nom", length = 50)
    private String nom;

}