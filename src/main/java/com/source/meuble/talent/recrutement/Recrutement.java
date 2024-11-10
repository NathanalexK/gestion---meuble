package com.source.meuble.talent.recrutement;

import com.source.meuble.talent.diplome.Diplome;
import com.source.meuble.utilisateur.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "recrutement")
@Table(name = "besoin_recrutement")
@Getter
@Setter
public class Recrutement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_besoin_recrutement")
    private int idBesoin;

    @Column(name = "id_role")
    private UserRole idRole;
    private String details;

    @ManyToOne
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome diplome;

    @Column(name = "date_demande")
    private LocalDate dateDemande;

    @Column(name = "annees_experience")
    private int anneesExperience;

    private int etat;
}
