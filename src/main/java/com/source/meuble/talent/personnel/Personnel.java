package com.source.meuble.talent.personnel;

import com.source.meuble.talent.cv.Cv;
import com.source.meuble.utilisateur.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personnel", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "adresse")
    private String adresse;
    private String email;
    private String telephone;

    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;

    @Column(name = "salaire")
    private BigDecimal salaire;

    @Column(name = "id_role")
    private UserRole idRole;

    @Column(name = "poste")
    private String poste;

    @ManyToOne
    @JoinColumn(name = "id_cv")
    private Cv idCv;
}
