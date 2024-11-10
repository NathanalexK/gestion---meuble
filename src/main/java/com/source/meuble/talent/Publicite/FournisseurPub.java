package com.source.meuble.talent.Publicite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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


    @ManyToMany
    @JoinTable(name = "fournisseur_moyen",
            joinColumns = @JoinColumn(name = "id_fournisseur_pub"),
            inverseJoinColumns = @JoinColumn(name = "id_moyen_pub"))
    private List<MoyenPub> moyenPubs = new ArrayList<>();

    public String getMoyensStr() {
        String moyens = "";
        for (MoyenPub mp : moyenPubs) {
            moyens += mp.getLibelle();
            moyens += " - ";
        }

        return moyens;
    }

}