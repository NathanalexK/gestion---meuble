package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.Poste;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "poste_fille")
public class PosteFille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste_fille", nullable = false)
    private Integer id;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "montant")
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mere")
    private Poste idMere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exercice")
    private Exercice idExercice;

}