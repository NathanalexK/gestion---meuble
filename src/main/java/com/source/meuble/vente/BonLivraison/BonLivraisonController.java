package com.source.meuble.vente.BonLivraison;

import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.analytique.centre.CentreRepository;
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
@RequestMapping("/bon-livraison")
public class BonLivraisonController {

    private final BonLivraisonService bonLivraisonService;
    private final CentreRepository centreRepository;
    private final ProduitService marchandiseService;
    private final AuthService authService;
    private final LayoutService layoutService;
    private final BonLivraisonRepository bonLivraisonRepository;

    public BonLivraisonController(BonLivraisonService bonLivraisonService1, CentreRepository centreRepository, ProduitService marchandiseService, AuthService authService, LayoutService layoutService,
                                  BonLivraisonRepository bonLivraisonRepository){
        this.bonLivraisonService = bonLivraisonService1;
        this.centreRepository = centreRepository;
        this.marchandiseService = marchandiseService;
        this.authService = authService;
        this.layoutService = layoutService;
        this.bonLivraisonRepository = bonLivraisonRepository;
    }

    @PostMapping("/transfert")
    public String transfertToBl(@RequestParam("date") LocalDate daty, @RequestParam("idBc") int id){
        bonLivraisonService.transferBcToBl(id,daty);
        return  new Redirection("test/home").getUrl();
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-livraison/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bls", bonLivraisonService.findAll());
        return mav;
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
        @RequestParam("id") BonLivraison bl
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-livraison/details");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bl", bl);
        mav.addObject("blf", bl.getFille());
        return mav;
    }

    @PostMapping("/generer")
    public String genererBR(
        @RequestParam("idBc")BonCommande bc,
        @RequestParam("dateReception") LocalDate dateReception
    ) throws NoUserLoggedException {
        authService.requireUser();
        bonLivraisonService.genererBL(bc, dateReception);
        return new Redirection("/bon-commande/details?id="+bc.getId()).getUrl();
    }

    @GetMapping("/valider")
    public String valider(
            @RequestParam("id") BonLivraison bonCommande, RedirectAttributes atts
    ) throws NoUserLoggedException, UnallowedRoleException, Alert {
        Utilisateur u = authService.requireUser();
        if(bonCommande.getEtat() == 0) {
            authService.allowRoles(UserRole.DEPT_LOGISTIQUE);
        }
        bonLivraisonService.validerBonLivraison(bonCommande);
        atts.addFlashAttribute("swal", new Alert(AlertType.SUCCESS, "Succès", "Bon de Commande: BC000" + bonCommande.getId() + " a été bien validé par: " + u.getRole().name()));
        return new Redirection("/bon-livraison/validation").getUrl();
    }

    @GetMapping("/validation")
    public ModelAndView showListValidation(Model model) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout(model, "bon-livraison/validation");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("bls", bonLivraisonService.getAllBcByUtilisateur(layout.getUtilisateur()));
        return mav;
    }



}
