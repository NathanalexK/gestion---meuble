package com.source.meuble.achat.bonCommande;

import com.source.meuble.achat.BonReception.BonReception;
import com.source.meuble.achat.BonReception.BonReceptionService;
import com.source.meuble.achat.proformat.Proformat;
import com.source.meuble.analytique.centre.CentreRepository;
import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.analytique.produit.ProduitService;
import com.source.meuble.auth.AuthService;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.exception.UnallowedRoleException;
import com.source.meuble.util.AlertType;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import com.source.meuble.utilisateur.UserRole;
import com.source.meuble.utilisateur.Utilisateur;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("/bon-commande")
public class BonCommandeController {

    private final BonCommandeService bonCommandeService;
    private final BonReceptionService bonReceptionService;
    private final CentreRepository centreRepository;
    private final ProduitService marchandiseService;
    private final LayoutService layoutService;
    private final AuthService authService;

    public BonCommandeController(BonCommandeService bonCommandeService, BonReceptionService bonReceptionService, CentreRepository centreRepository, ProduitService marchandiseService, LayoutService layoutService, AuthService authService) {
        this.bonCommandeService = bonCommandeService;
        this.bonReceptionService = bonReceptionService;
        this.centreRepository = centreRepository;
        this.marchandiseService = marchandiseService;
        this.layoutService = layoutService;
        this.authService = authService;
    }

    @GetMapping("/generer")
    public String genererBC(@RequestParam("id") Proformat proformat, @RequestParam("type")String type, RedirectAttributes atts) {
        bonCommandeService.genererBonCommande(proformat);
        atts.addFlashAttribute("swal", Alert.success("Bon de Commande généré pour le proformat: PF000" + proformat.getId()));
        if (Objects.equals(type, "client"))
            return new Redirection("/proformat/detailsClient?id=" + proformat.getId()).getUrl();

        return new Redirection("/proformat/details?id=" + proformat.getId()).getUrl();
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-commande/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bcs", bonCommandeService.findAllFournisseur());
        return mav;
    }

    @GetMapping("/listClient")
    public ModelAndView showListClient() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-commande/listClient");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bcs", bonCommandeService.findAllClient());
        return mav;
    }

    @GetMapping("/validation")
    public ModelAndView showListValidation(Model model) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout(model, "bon-commande/validation");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bcs", bonCommandeService.getAllBcByUtilisateur(layout.getUtilisateur()));
        return mav;
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
            @RequestParam("id") BonCommande bc, @RequestParam("type" ) String type
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = null;
        if (type.equals("client"))
            layout = layoutService.getLayout("bon-commande/detailsClient");
        else
            layout = layoutService.getLayout("bon-commande/details");

        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bc", bc);
        mav.addObject("bcf", bc.getFilles());
        return mav;
    }

    @GetMapping("/valider")
    public String valider(
        @RequestParam("id") BonCommande bonCommande, RedirectAttributes atts
    ) throws NoUserLoggedException, UnallowedRoleException, Alert {
        Utilisateur u = authService.requireUser();
        if(bonCommande.getEtat() == 0) {
            authService.allowRoles(UserRole.DEPT_FINANCE);
        }
        if(bonCommande.getEtat() == 1) {
            authService.allowRoles(UserRole.DIRECTION);
        }
        bonCommandeService.validerBonCommande(bonCommande);
        atts.addFlashAttribute("swal", new Alert(AlertType.SUCCESS, "Succès", "Bon de Commande: BC000" + bonCommande.getId() + " a été bien validé par: " + u.getRole().name()));
        return new Redirection("/bon-commande/validation").getUrl();
    }

    @PostMapping("/commander")
    public String commander(
        @RequestParam("idBc") BonCommande bc,
        @RequestParam("dateCommande") LocalDate dateCom,
        @RequestParam("dateLivraison") LocalDate dateLivr,
        RedirectAttributes atts
    ) throws Exception {
        bonCommandeService.commander(bc, dateCom, dateLivr);
        atts.addFlashAttribute("swal", Alert.success("Bon de commande: BC000" + bc.getId() +" a été commandé avec succès!"));
        return new Redirection("/bon-commande/details?id="+bc.getId() + "&type=fournisseur").getUrl();
    }


    @PostMapping("/transferer")
    public String transferer(
        @RequestParam("id")  BonCommande bc,
        @RequestParam("date") LocalDate date
    ) {
        bonReceptionService.transferBcToBr(bc.getId(), date);
        return new Redirection("/home/achat/validation-bon-reception").getUrl();
    }

//    @GetMapping("/details")
//    public ModelAndView showDetails(
//        @RequestParam("id") BonCommande bonCommande
//    ) {
//        ModelAndView modelAndView = new ModelAndView("template");
//
//        String content = "landingAchat.jsp";
//        String sidebar = "template/floating-sidebar-achat.jsp";
//        String validation = "achat/bon-commande-detail.jsp";
//        modelAndView.addObject("content", content);
//        modelAndView.addObject("sidebar", sidebar);
//        modelAndView.addObject("insideContent", validation);
//        modelAndView.addObject("centres", centreRepository.findAll());
//        modelAndView.addObject("produits", marchandiseService.findAll());
//        modelAndView.addObject("bcFille", bonCommande.getFilles());
//        return modelAndView;
//    }

}
