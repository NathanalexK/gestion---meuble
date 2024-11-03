package com.source.meuble.vente.BonLivraison;

import com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFille;
import com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFilleRepository;
import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.achat.bonCommande.BonCommandeRepository;
import com.source.meuble.achat.bonCommande.BonCommandeService;
import com.source.meuble.achat.bonCommande.bonCommandeFille.BonCommandeFille;
import com.source.meuble.stock.mouvementStock.MouvementStockService;
import com.source.meuble.vente.BonLivraison.BonLivraisonFille.BonLivraisonFille;
import com.source.meuble.vente.BonLivraison.BonLivraisonFille.BonLivraisonFilleRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BonLivraisonService {

    private final BonLivraisonRepository bonLivraisonRepository;
    private final BonCommandeService bonCommandeService;
    private final MouvementStockService mouvementStockService;
    private final BonCommandeRepository bonCommandeRepository;
    private final BonLivraisonFilleRepository bonLivraisonFilleRepository;

    @Autowired
    public BonLivraisonService(BonLivraisonRepository bonLivraisonRepository, BonCommandeService bonCommandeService,
                               MouvementStockService mouvementStockService,
                               BonCommandeRepository bonCommandeRepository,
                               BonLivraisonFilleRepository bonLivraisonFilleRepository) {
        this.bonLivraisonRepository = bonLivraisonRepository;
        this.bonCommandeService = bonCommandeService;
        this.mouvementStockService = mouvementStockService;
        this.bonCommandeRepository = bonCommandeRepository;
        this.bonLivraisonFilleRepository = bonLivraisonFilleRepository;
    }

    public List<BonLivraison> findAll() {
        return bonLivraisonRepository.findAll();
    }

    public Optional<BonLivraison> findById(Integer id) {
        return bonLivraisonRepository.findById(id);
    }

    public BonLivraison save(BonLivraison bonReception) {
        return bonLivraisonRepository.save(bonReception);
    }

    public void deleteById(Integer id) {
        bonLivraisonRepository.deleteById(id);
    }

    public void transferBcToBl(int idBc , LocalDate daty){
        Optional<BonCommande> optionalBonCommande=bonCommandeService.findById(idBc);
        if (optionalBonCommande.isPresent()) {
            BonCommande bon = optionalBonCommande.get();
            BonLivraison br=this.genererBl(bon,daty);
            List<BonCommandeFille> bcFilles= bonCommandeService.findFilleByIdMere(bon.getId());
            this.genereBonLivraisonFille(bcFilles,br);
//            mouvementStockService.achatWithMouvementEtat2(br);
        } else {
            // Gérer le cas où l'objet n'existe pas
        }
    }

    @Transactional
    public BonLivraison genererBL(@NonNull BonCommande bc, LocalDate dateReception) {
        if(dateReception == null) dateReception = LocalDate.now();

        BonLivraison bl = new BonLivraison();
        bl.setDateLivraison(dateReception);
        bl.setEtat(0);
        bl.setIdBc(bc);
        bl = bonLivraisonRepository.save(bl);

        List<BonCommandeFille> bcfs = bc.getFilles();
        List<BonLivraisonFille> blfs = new ArrayList<>();

        for(BonCommandeFille bcf: bcfs) {
            BonLivraisonFille blf = new BonLivraisonFille();
            blf.setIdBl(bl);
            blf.setIdProduit(bcf.getIdMarchandise());
            blf.setPrix(bcf.getPrix());
            blf.setQuantite(bcf.getQuantite());
            blfs.add(blf);
        }

        bonLivraisonFilleRepository.saveAll(blfs);

        bc.setEtat(4);
        bonCommandeRepository.save(bc);

        return bl;
    }

    public BonLivraison genererBl(BonCommande bonCommande, LocalDate daty){
        BonLivraison br=new BonLivraison();
        br.setIdBc(bonCommande);
        br.setDateLivraison(daty);
        return bonLivraisonRepository.save(br);
    }

    public void genereBonLivraisonFille(List<BonCommandeFille> bonCommandeFilles, BonLivraison bonMere){
        for (BonCommandeFille bcFille: bonCommandeFilles){
            BonLivraisonFille blFille=new BonLivraisonFille();
            blFille.setIdProduit(bcFille.getIdMarchandise());
            blFille.setPrix(bcFille.getPrix());
            blFille.setIdBl(bonMere);
            blFille.setQuantite(bcFille.getQuantite());
            bonLivraisonFilleRepository.save(blFille);
        }
    }

    public List<BonLivraisonFille> findFilleByIdMere(Integer idBr) {

        return bonLivraisonFilleRepository.findByIdBl_Id(idBr);
    }

}
