package com.source.meuble.vente.BonLivraison;

import com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFille;
import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.pieces.Etat;
import com.source.meuble.pieces.EtatCPL;
import com.source.meuble.vente.BonLivraison.BonLivraisonFille.BonLivraisonFille;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bon_livraison")
public class BonLivraison extends Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bl", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bc")
    private BonCommande idBc;

    @Column(name = "date_livraison")
    private LocalDate dateLivraison;

    @Column(name = "etat")
    private Integer etat;

    @Override
    public EtatCPL transferer(Etat etat) {
        return null;
    }

    @OneToMany(mappedBy = "idBl", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<BonLivraisonFille> fille;

//    @Override
//    public List<Object> getFille() {
//        return null;
//    }
}