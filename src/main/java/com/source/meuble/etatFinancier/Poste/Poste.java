package com.source.meuble.etatFinancier.Poste;

import com.source.meuble.etatFinancier.nomPoste.NomPoste;
import com.source.meuble.etatFinancier.posteFille.PosteFille;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste", nullable = false)
    private Integer id;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "categorie")
    private Integer categorie;

    @OneToMany(mappedBy = "idMere")
    private List<PosteFille> posteFilles = new ArrayList<>();

    @Transient
    private List<NomPoste> vides;



}