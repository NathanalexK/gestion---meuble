package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "v_poste_fille_montant")
public class PosteFilleMontant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste_fille")
    private Integer idPosteFille;

    @Column(name = "compte", unique = true)
    private Integer compte;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "id_mere")
    private Integer idMere;

    @Column(name = "id_compte_mere")
    private Integer idCompteMere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exercice")
    private Exercice idExercice;
}