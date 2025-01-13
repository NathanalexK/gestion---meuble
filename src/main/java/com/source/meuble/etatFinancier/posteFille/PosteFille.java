package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.etatFinancier.Poste.Poste;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "compte", unique = true)
    private Integer compte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mere")
    private Poste idMere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compte_mere", referencedColumnName = "compte")
    private PosteFille compteMere;

    @OneToMany(mappedBy = "compteMere", fetch = FetchType.EAGER)
    private List<PosteFille> posteFilles = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compte", referencedColumnName = "compte", insertable = false, updatable = false)
    private PosteFilleMontant posteFilleMontant;



    @Transient
    public Double getMontant() {
        return posteFilleMontant != null ? posteFilleMontant.getMontant() : null;
    }
}