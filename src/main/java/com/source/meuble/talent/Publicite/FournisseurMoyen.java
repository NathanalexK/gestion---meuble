package com.source.meuble.talent.Publicite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fournisseur_moyen")
public class FournisseurMoyen {
    @EmbeddedId
    private FournisseurMoyenId id;

    @MapsId("idMoyenPub")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_moyen_pub", nullable = false)
    private MoyenPub idMoyenPub;

    @MapsId("idFournisseurPub")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fournisseur_pub", nullable = false)
    private FournisseurPub idFournisseurPub;

}