package com.source.meuble.stock.mouvementStock;

import com.source.meuble.achat.BonReception.BonReception;
import com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFille;
import com.source.meuble.achat.Facture.Facture;
import com.source.meuble.achat.bonCommande.bonCommandeFille.BonCommandeFille;
import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.analytique.produit.ProduitService;
import com.source.meuble.auth.AuthService;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.stock.etatStock.EtatStock;
import com.source.meuble.stock.etatStock.EtatStockService;
import com.source.meuble.stock.produitMarchandise.ProduitMarchandise;
import com.source.meuble.stock.produitMarchandise.ProduitMarchandiseService;
import com.source.meuble.util.AlertType;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import com.source.meuble.utilisateur.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mouvement-stock")
public class MouvementStockController {

    @Autowired
    MouvementStockService mouvementStockService;

    @Autowired
    EtatStockService etatStockService;

    @Autowired
    ProduitService marchandiseService;

    @Autowired
    ProduitMarchandiseService produitMarchandiseService;
    @Autowired
    private LayoutService layoutService;
    @Autowired
    private AuthService authService;

    @GetMapping("/achatForm")
    public String achatForm() {
        return "achat";
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("stock/mouvement-stock/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("mvts", mouvementStockService.findAllMouvement());
        return mav;
    }

    @PostMapping("/generer-stock")
    public String genererStock(
        @RequestParam("idFacture") Facture facture,
        RedirectAttributes atts
    ) throws Exception {
        authService.requireUser();
        authService.allowRoles(UserRole.DEPT_LOGISTIQUE);
        try {
            mouvementStockService.genererMvtStockAvecEtatFromFacture(facture);
            atts.addFlashAttribute("swal", Alert.success("Stock Generé avec succès pour la facture: FC000" + facture.getId()));
        } catch (Exception e) {
            throw new Alert(AlertType.WARNING, "Echec", e.getMessage());
        }
        return new Redirection("/facture/details?id="+facture.getId()).getUrl();
    }

//    @PostMapping("/achat")
//    public String achatWithMouvementEtat(
//            @RequestParam("idMarchandise") int idMarchandise,
//            @RequestParam("quantite") int qt,
//            @RequestParam("prixUnitaire") double pu,
//            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateString
//    ){
//        int nat = 0;
//
//        MouvementStock mouvementStock = null;
//
//        System.out.println(qt);
//        System.out.println(pu);
//        try{
//            LocalDate date = dateString.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            System.out.println(date.getDayOfMonth());
//
//            mouvementStock = new MouvementStock();
//
//            mouvementStock.setDateEnregistrement(date);
//            mouvementStock.setQuantite(qt);
//            mouvementStock.setPrixUnitaire(pu);
//            mouvementStock.setNature(nat);
//            mouvementStock.calculPrixTotal();
//
//            Optional<Produit> optionalMarchandise = marchandiseService.findById(idMarchandise);
//            if (optionalMarchandise.isPresent()) {
//                mouvementStock.setMarchandise(optionalMarchandise.get());
//            } else {
//                throw new RuntimeException("Marchandise non trouvée avec l'ID: " + idMarchandise);
//            }
//
//            EtatStock etatStock = mouvementStockService.saveMouvementStockWithEtat(mouvementStock, etatStockService);
//
//            System.out.println("Success");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        Redirection redirection = new Redirection("/home");
//        return redirection.getUrl();
//    }


//    @PostMapping("/vente")
//    public String venteWithMouvementEtat(
//            @RequestParam("idProduit") int idProduit,
//            @RequestParam("quantite") int qt,
//            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateString
//    ){
//        int nat = 1;
//
//        MouvementStock mouvementStock = null;
//
//        try{
//            LocalDate date = dateString.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//            List<ProduitMarchandise> produitMarchandises = produitMarchandiseService.findProduitMarchandisesByIdProduit(idProduit);
//
//            for(int i=0; i<produitMarchandises.size(); i++){
//                ProduitMarchandise produitMarchandise = produitMarchandises.get(i);
//
//                mouvementStock = new MouvementStock();
//
//                mouvementStock.setDateEnregistrement(date);
//                mouvementStock.setQuantite(qt*produitMarchandise.getQuantite());
//                mouvementStock.setNature(nat);
//
//                Optional<Produit> optionalMarchandise = marchandiseService.findById(produitMarchandise.getMarchandise().getId());
//                if (optionalMarchandise.isPresent()) {
//                    mouvementStock.setMarchandise(optionalMarchandise.get());
//                } else {
//                    throw new RuntimeException("Marchandise non trouvée avec l'ID: " + produitMarchandise.getMarchandise().getId());
//                }
//
//                EtatStock etatStock = mouvementStockService.saveMouvementStockWithEtat(mouvementStock, etatStockService);
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

    @GetMapping("stock/mouvementStock")
    public ModelAndView allMouvementStock() {
        ModelAndView modelAndView = new ModelAndView("template");

        List<MouvementStock> mouvementStocks = mouvementStockService.findAllMouvement();
        modelAndView.addObject("mouvement", mouvementStocks);

        String content = "landingStock.jsp";
        String sidebar = "template/floating-sidebar-stock.jsp";
        String validation = "stock/mouvementStock.jsp";
        modelAndView.addObject("content", content);
        modelAndView.addObject("sidebar", sidebar);
        modelAndView.addObject("insideContent", validation);

        return modelAndView;
    }
}
