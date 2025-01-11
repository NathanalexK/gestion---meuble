package com.source.meuble.etatFinancier.posteFille.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "poste_fille_view")
public class PosteFilleView {
    @Id
    @Column(name = "id_poste_fille")
    private Integer idPosteFille;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "id_mere")
    private Integer idMere;

    @Column(name = "id_exercice")
    private Integer idExercice;

    @Column(name = "montant")
    private BigDecimal montant;

}