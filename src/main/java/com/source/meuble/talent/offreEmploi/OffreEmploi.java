package com.source.meuble.talent.offreEmploi;

import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.talent.Publicite.FournisseurPub;
import com.source.meuble.talent.recrutement.Recrutement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "offre_emploi")
public class OffreEmploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_offre_emploi", nullable = false)
    private Integer id;

    @Column(name = "date_publication", nullable = false)
    private LocalDate datePublication;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_besoin_recrutement", nullable = false)
    private Recrutement idBesoinRecrutement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bc")
    private BonCommande idBc;

}