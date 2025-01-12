package com.source.meuble.etatFinancier.analyse;


import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.PosteCpl;
import com.source.meuble.etatFinancier.Poste.PosteCplRepository;
import com.source.meuble.etatFinancier.bilan.BilanEtatFinancierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyseEtatFinancierService {
    @Autowired
    private PosteCplRepository posteCplRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isValide(){
        double actif = posteCplRepository.sumTotalByCategorie(0);
        double passif = posteCplRepository.sumTotalByCategorie(1);

        if(actif>passif){
            return false;
        }
        return true;
    }

    public String generateMessageValidite(){
        double actif = posteCplRepository.sumTotalByCategorie(0);
        double passif = posteCplRepository.sumTotalByCategorie(1);

        String message = "Le total des actifs est de "+actif+" et celui des passifs est "+passif+", il reste "+(actif-passif)+" a complete";
        return message;
    }

    public List<Double> generateTotaux(){
        double actif = posteCplRepository.sumTotalByCategorie(0);
        double passif = posteCplRepository.sumTotalByCategorie(1);
        double resultats = posteCplRepository.sumTotalByCategorie(2);

        List<Double> totaux = new ArrayList<Double>();
        totaux.add(actif);
        totaux.add(passif);
        totaux.add(resultats);
        return totaux;
    }

    public AnalyseEtaFinancier generateAnalyseEtatFinancier(Exercice exercice){
        AnalyseEtaFinancier analyseEtaFinancier = new AnalyseEtaFinancier();

        analyseEtaFinancier.setValide(this.isValide());
        analyseEtaFinancier.setMessageValidite(this.generateMessageValidite());
        analyseEtaFinancier.setTotaux(this.generateTotaux());
        analyseEtaFinancier.setBilanEtatFinancier(new BilanEtatFinancierImpl(jdbcTemplate, 1));



        analyseEtaFinancier.setActifs(posteCplRepository.findByIdMere_CategorieAndIdMere_PosteFilles_IdExercice(0, exercice));
        analyseEtaFinancier.setPassifs(posteCplRepository.findByIdMere_CategorieAndIdMere_PosteFilles_IdExercice(1, exercice));
        analyseEtaFinancier.setResultat(posteCplRepository.findByIdMere_CategorieAndIdMere_PosteFilles_IdExercice(2, exercice));

        /*List<PosteCpl> bilan = new ArrayList<>();
        bilan.addAll(analyseEtaFinancier.getActifs());
        bilan.addAll(analyseEtaFinancier.getPassifs());
        analyseEtaFinancier.setBilan(bilan);

        analyseEtaFinancier.setResultatNet(analyseEtaFinancier.getResultat().get(0).getTotal()-analyseEtaFinancier.getResultat().get(1).getTotal());*/

        return analyseEtaFinancier;
    }
}
