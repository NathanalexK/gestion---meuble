package com.source.meuble.stock.mouvementStock;

import com.source.meuble.achat.BonReception.BonReception;
import com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFille;

import com.source.meuble.achat.BonReception.BonReceptionRepository;
import com.source.meuble.achat.BonReception.BonReceptionService;
import com.source.meuble.achat.Facture.Facture;
import com.source.meuble.achat.Facture.FactureFille.FactureFille;
import com.source.meuble.achat.Facture.FactureRepository;
import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.achat.bonCommande.BonCommandeRepository;
import com.source.meuble.achat.bonCommande.bonCommandeFille.BonCommandeFille;
import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.analytique.produit.ProduitService;
import com.source.meuble.exception.Alert;
import com.source.meuble.stock.etatStock.EtatStock;
import com.source.meuble.stock.etatStock.EtatStockService;
import com.source.meuble.util.Redirection;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MouvementStockService {
    private final MouvementStockRepository mouvementStockRepository;
    private final EtatStockService etatStockService;
   private final ProduitService marchandiseService;
    private final FactureRepository factureRepository;
    private final BonReceptionRepository bonReceptionRepository;
    private final BonCommandeRepository bonCommandeRepository;

    public MouvementStockService(MouvementStockRepository mouvementStockRepository, EtatStockService etatStockService, ProduitService marchandiseService,
                                 FactureRepository factureRepository, BonReceptionRepository bonReceptionRepository, BonCommandeRepository bonCommandeRepository) {
        this.mouvementStockRepository = mouvementStockRepository;
        this.etatStockService = etatStockService;
        this.marchandiseService = marchandiseService;
        this.factureRepository = factureRepository;
        this.bonReceptionRepository = bonReceptionRepository;
        this.bonCommandeRepository = bonCommandeRepository;
    }

    public MouvementStock saveMouvementStock(MouvementStock mouvementStock){
        return mouvementStockRepository.save(mouvementStock);
    }

    public List<MouvementStock> findAllMouvement(){
        return mouvementStockRepository.findAll();
    }

//    public EtatStock saveMouvementStockWithEtat(MouvementStock mouvementStock, EtatStockService etatStockService)throws Exception{
//        EtatStock etatStock = null;
//        if(etatStockService.findAllEtat(mouvementStock.getMarchandise().getId()).size()==0){
//
//            EtatStock etatStockDernier = new EtatStock(mouvementStock.getDateEnregistrement(), 0, 0);
//
//            EtatStock etatStockNouveau = etatStockService.calculateData(mouvementStock, etatStockDernier);
//
//            saveMouvementStock(mouvementStock);
//
//            etatStock = etatStockService.saveEtatStock(etatStockNouveau);
//        }
//        else {
//
//            EtatStock etatStockDernier = etatStockService.findLastEtat(mouvementStock.getMarchandise().getId());
//            etatStockDernier.calculPrixTotal();
//
//            if(mouvementStock.getNature()==1){
//
//                mouvementStock.setPrixUnitaire(etatStockDernier.getPrixUnitaire().doubleValue());
//                mouvementStock.calculPrixTotal();
//            }
//
//            EtatStock etatStockNouveau = etatStockService.calculateData(mouvementStock, etatStockDernier);
//            saveMouvementStock(mouvementStock);
//
//            etatStock = etatStockService.saveEtatStock(etatStockNouveau);
//        }
//        return etatStock;
//    }
//    public String achatWithMouvementEtat2(BonReception idBonReception){
//        int nat = 0;
//
//        MouvementStock mouvementStock = null;
//
//        try{
//            LocalDate date = idBonReception.getDateReception();
//
//            for (int i=0; i<idBonReception.getFille().size(); i++){
//                BonReceptionFille bonReceptionFille = idBonReception.getFille().get(i);
//                mouvementStock = new MouvementStock();
//
//                mouvementStock.setDateEnregistrement(date);
//                mouvementStock.setQuantite(Integer.parseInt((bonReceptionFille.getQuantite()).toString()));
//                mouvementStock.setPrixUnitaire(bonReceptionFille.getPrix());
//                mouvementStock.setNature(nat);
//                mouvementStock.calculPrixTotal();
//
//                Optional<Produit> optionalMarchandise = marchandiseService.findById(bonReceptionFille.getIdMarchandise().getId());
//                if (optionalMarchandise.isPresent()) {
//                    mouvementStock.setMarchandise(optionalMarchandise.get());
//                } else {
//                    throw new RuntimeException("Marchandise non trouvée avec l'ID: " + bonReceptionFille.getIdMarchandise().getId());
//                }
//
//                EtatStock etatStock = saveMouvementStockWithEtat(mouvementStock, etatStockService);
//
//                System.out.println("Success");
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        Redirection redirection = new Redirection("/home");
//        return redirection.getUrl();
//    }

    @Transactional
    public void genererFromFactureAchatAvecStock(Facture facture) throws Exception {
        List<FactureFille> filles = facture.getFilles();
        List<MouvementStock> mvts = new ArrayList<>();

        for(FactureFille fille: filles) {
            MouvementStock mvt = new MouvementStock();
            mvt.setMarchandise(fille.getIdMarchandise());
            mvt.setQte(fille.getQuantite().doubleValue());
            mvt.setTypeMvt(TypeMvt.ENTREE);
            mvt.setPrixUnitaire(fille.getPrix().doubleValue());
            mvt.setDateEnregistrement(facture.getDateFacture());
            mvts.add(mvt);
        }

        mouvementStockRepository.saveAll(mvts);

        for(MouvementStock mvt: mvts) {
            etatStockService.genererEtatStock(mvt);
        }
    }

    @Transactional
    public List<MouvementStock> genererMvtStockFromFacture(Facture facture) throws Exception {
        if(facture.getEtat() == 0) {
            throw new Alert("Facture doit etre validé avant de generer stock");
        }

        if(facture.getEtat() == 2) {
            throw new Alert("Stock déjà generé pour cette Facture");
        }

        List<FactureFille> filles = facture.getFilles();
        List<MouvementStock> mvts = new ArrayList<>();

        for(FactureFille fille: filles) {
            MouvementStock mvt = new MouvementStock();
            mvt.setMarchandise(fille.getIdMarchandise());
            mvt.setQte(fille.getQuantite().doubleValue());
            mvt.setTypeMvt(TypeMvt.ENTREE);
            mvt.setPrixUnitaire(fille.getPrix().doubleValue());
            mvt.setDateEnregistrement(facture.getDateFacture());
            mvts.add(mvt);
        }

        mvts = mouvementStockRepository.saveAll(mvts);
        facture.setEtat(2);
        factureRepository.save(facture);
        return mvts;
    }

    @Transactional
    public List<MouvementStock> genererMvtStockFromBR(BonReception br) throws Exception {
        if(br.getId() == 1) {
            throw Alert.warning("Stock déjà généré pour cet bon de reception");
        }
//        if(facture.getEtat() == 0) {
//            throw new Alert("Facture doit etre validé avant de generer stock");
//        }
//
//        if(facture.getEtat() == 2) {
//            throw new Alert("Stock déjà generé pour cette Facture");
//        }

        List<BonReceptionFille> filles = br.getFille();
        List<MouvementStock> mvts = new ArrayList<>();

        for(BonReceptionFille fille: filles) {
            MouvementStock mvt = new MouvementStock();
            mvt.setMarchandise(fille.getIdMarchandise());
            mvt.setQte(fille.getQuantite().doubleValue());
            mvt.setTypeMvt(TypeMvt.ENTREE);
            mvt.setPrixUnitaire(fille.getPrix().doubleValue());
            mvt.setDateEnregistrement(br.getDateReception());
            mvts.add(mvt);
        }

        mvts = mouvementStockRepository.saveAll(mvts);
        br.setEtat(1);
        bonReceptionRepository.save(br);
        return mvts;
    }

    @Transactional
    public List<MouvementStock> genererMvtStockFromBCVente(BonCommande bc) throws Exception {
        List<BonCommandeFille> filles = bc.getFilles();
        List<MouvementStock> mvts = new ArrayList<>();

        for(BonCommandeFille fille: filles) {
            MouvementStock mvt = new MouvementStock();
            mvt.setMarchandise(fille.getIdMarchandise());
            mvt.setQte(fille.getQuantite().doubleValue());
            mvt.setTypeMvt(TypeMvt.SORTIE);
            mvt.setPrixUnitaire(fille.getPrix().doubleValue());
            mvt.setDateEnregistrement(bc.getDateLivraison());
            mvts.add(mvt);
        }
        mvts = mouvementStockRepository.saveAll(mvts);
        bc.setEtat(4);
        bonCommandeRepository.save(bc);
        return mvts;
    }


    @Transactional
    public void genererMvtStockAvecEtatFromFacture(Facture facture) throws Exception {
        List<MouvementStock> mvts = genererMvtStockFromFacture(facture);
        etatStockService.genererEtatStockFromMvtStock(mvts);
    }

    @Transactional
    public void genererMvtStockAvecEtatFromBR(BonReception br) throws Exception {
        List<MouvementStock> mvts = genererMvtStockFromBR(br);
        etatStockService.genererEtatStockFromMvtStock(mvts);
    }

    @Transactional
    public void genererMvtStockAvecEtatFromBCVente(BonCommande bc) throws Exception {
        List<MouvementStock> mvts = genererMvtStockFromBCVente(bc);
        etatStockService.genererEtatStockFromMvtStock(mvts);
    }




}
