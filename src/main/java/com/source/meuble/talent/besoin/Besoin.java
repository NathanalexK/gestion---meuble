package com.source.meuble.talent.besoin;

import com.source.meuble.talent.diplome.Diplome;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "besoin")
@Table(name = "besoin_recrutement")
@Getter
@Setter
public class Besoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_besoin_recrutement")
    private int idBesoin;

    @Column(name = "id_role")
    private int idRole;

    @ManyToOne
    @JoinColumn(name = "id_diplome", nullable = false)
    private Diplome diplome;

    @Column(name = "date_demande")
    private Date dateDemande;

    @Column(name = "annees_experience")
    private int anneesExperience;
}
