package com.source.meuble.achat.BonReception;

import com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFille;
import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.pieces.Etat;
import com.source.meuble.pieces.EtatCPL;
import com.source.meuble.stock.mouvementStock.TypeMvt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bon_reception")
public class BonReception extends Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_br", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bc")
    private BonCommande idBc;

    @Column(name = "date_reception")
    private LocalDate dateReception;

    //0: Stock non Generé
    //1: Generer stock
    @Column(name = "etat")
    private Integer etat;

    @Override
    public EtatCPL transferer(Etat etat) {
        return null;
    }

    @OneToMany(mappedBy = "idBr", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<BonReceptionFille> fille;

//    @Override
//    public List<Object> getFille() {
//        return null;
//    }

    public String getEtatHtml() {
        String html = "";
        if(etat < 2) {
            html += "<span class=\"badge bg-label-warning me-1\">Pas De Facture</span>";

        } else if (etat == 2) {
            html += "<span class=\"badge bg-label-primary me-1\">Facturé</span>";
        }
        return html;
    }
}