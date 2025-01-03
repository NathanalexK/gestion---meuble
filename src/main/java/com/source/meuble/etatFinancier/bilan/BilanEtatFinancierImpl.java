package com.source.meuble.etatFinancier.bilan;

import com.source.meuble.etatFinancier.posteFille.PosteFille;
import lombok.Setter;

import java.util.List;

@Setter
public class BilanEtatFinancierImpl extends BilanEtatFinancier{
    private List<PosteFille> posteFilles;

    public BilanEtatFinancierImpl(List<PosteFille> posteFilles) {
        this.setPosteFilles(posteFilles);
    }

    @Override
    Double getRevenu() {
        return 0.0;
    }

    @Override
    Double getBenefice() {
        return 0.0;
    }

    @Override
    Double getResultatNet() {
        return 0.0;
    }

    @Override
    Double getTotalActifs() {
        return 0.0;
    }

    @Override
    Double getTotalPassifs() {
        return 0.0;
    }

    @Override
    Double getPassifCourrant() {
        return 0.0;
    }

    @Override
    Double getActifCourant() {
        return 0.0;
    }

    @Override
    Double getTotalDettes() {
        return 0.0;
    }

    @Override
    Double getChargeFinanciere() {
        return 0.0;
    }

    @Override
    Double getResultatExploitation() {
        return 0.0;
    }

    @Override
    Double getCapitauxPropres() {
        return 0.0;
    }

    @Override
    Double getValeurStock() {
        return 0.0;
    }
}
