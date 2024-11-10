package com.source.meuble.talent.cv;

import com.source.meuble.talent.diplome.Diplome;
import com.source.meuble.talent.offreEmploi.OffreEmploi;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cv")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cv", nullable = false)
    private Integer id;

    @Column(name = "date_postulation", nullable = false)
    private LocalDate datePostulation;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "annees_experience")
    private Integer anneesExperience;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_offre_emploi", nullable = false)
    private OffreEmploi idOffreEmploi;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome idDiplome;

}