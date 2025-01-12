package com.source.meuble.etatFinancier.analyse;

import com.source.meuble.etatFinancier.Poste.PosteCpl;
import com.source.meuble.etatFinancier.bilan.BilanEtatFinancier;
import com.source.meuble.etatFinancier.bilan.BilanEtatFinancierImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnalyseEtaFinancier {
    private boolean isValide;
    private String messageValidite;
    private List<Double> totaux;
    private List<PosteCpl> actifs;
    private List<PosteCpl> passifs;
    private List<PosteCpl> bilan;
    private List<PosteCpl> resultat;
    private BilanEtatFinancierImpl bilanEtatFinancier;
    private Double resultatNet;

}
