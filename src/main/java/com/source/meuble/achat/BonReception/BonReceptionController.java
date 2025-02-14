package com.source.meuble.achat.BonReception;

import com.source.meuble.achat.Facture.Facture;
import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.achat.proformat.Proformat;
import com.source.meuble.analytique.centre.CentreRepository;
import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.analytique.produit.ProduitService;
import com.source.meuble.auth.AuthService;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.stock.mouvementStock.MouvementStockService;
import com.source.meuble.util.AlertType;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import com.source.meuble.utilisateur.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bon-reception")
public class BonReceptionController {

    private final BonReceptionService bonReceptionService;
    private final CentreRepository centreRepository;
    private final ProduitService marchandiseService;
    private final AuthService authService;
    private final LayoutService layoutService;
    private final MouvementStockService mouvementStockService;

    public BonReceptionController(BonReceptionService bonReceptionService1, CentreRepository centreRepository, ProduitService marchandiseService, AuthService authService, LayoutService layoutService, MouvementStockService mouvementStockService){
        this.bonReceptionService = bonReceptionService1;
        this.centreRepository = centreRepository;
        this.marchandiseService = marchandiseService;
        this.authService = authService;
        this.layoutService = layoutService;
        this.mouvementStockService = mouvementStockService;
    }

    @PostMapping("/transfert")
    public String transfertToBr(@RequestParam("date") LocalDate daty, @RequestParam("idBc") int id){
        bonReceptionService.transferBcToBr(id,daty);
        return  new Redirection("test/home").getUrl();
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-reception/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("brs", bonReceptionService.findAll());
        return mav;
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
        @RequestParam("id") BonReception br
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-reception/details");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("br", br);
        mav.addObject("brf", br.getFille());
        return mav;
    }

    @PostMapping("/generer")
    public String genererBR(
        @RequestParam("idBc")BonCommande bc,
        @RequestParam("dateReception") LocalDate dateReception,
        RedirectAttributes atts
    ) throws Exception {
        authService.requireUser();
        bonReceptionService.genererBRAvecStock(bc, dateReception);
        atts.addFlashAttribute("swal", Alert.success("Bon Reception et stock géneré avec succès pour le bon de commande: BC000" + bc.getId()));
        return new Redirection("/bon-commande/details?id="+bc.getId()+ "&type=fournisseur").getUrl();
    }

    @PostMapping("/generer-stock")
    public String genererStock(
        @RequestParam("idBr") BonReception br,
        RedirectAttributes atts
    ) throws Exception {
        authService.requireUser();
        authService.allowRoles(UserRole.DEPT_LOGISTIQUE);
        try {
            mouvementStockService.genererMvtStockAvecEtatFromBR(br);
            atts.addFlashAttribute("swal", Alert.success("Stock Generé avec succès pour le Bon de Reception: BR000" + br.getId()));
        } catch (Exception e) {
            throw new Alert(AlertType.WARNING, "Echec", e.getMessage());
        }
        return new Redirection("/bon-reception/details?id="+br.getId()).getUrl();
    }

//    @GetMapping("/details")
//    public ModelAndView showDetails(
//            @RequestParam("id") BonReception bonReception
//    ) {
//        ModelAndView modelAndView = new ModelAndView("template");
//
//        String content = "landingAchat.jsp";
//        String sidebar = "template/floating-sidebar-achat.jsp";
//        String validation = "achat/bon-reception-detail.jsp";
//        modelAndView.addObject("content", content);
//        modelAndView.addObject("sidebar", sidebar);
//        modelAndView.addObject("insideContent", validation);
//        modelAndView.addObject("centres", centreRepository.findAll());
//        modelAndView.addObject("produits", marchandiseService.findAll());
//        modelAndView.addObject("brFille", bonReceptionService.findFilleByIdMere(bonReception.getId()));
//        return modelAndView;
//    }
}
