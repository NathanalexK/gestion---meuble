package com.source.meuble.achat.Facture;

import com.source.meuble.achat.BonReception.BonReception;
import com.source.meuble.achat.BonReception.BonReceptionService;
import com.source.meuble.auth.AuthService;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.exception.UnallowedRoleException;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import com.source.meuble.utilisateur.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/facture")
public class FactureController {
    private final BonReceptionService bonReceptionService;
    private final FactureService factureService;
    private final AuthService authService;
    private final LayoutService layoutService;

    public FactureController(BonReceptionService bonReceptionService, FactureService factureService, AuthService authService, LayoutService layoutService) {
        this.bonReceptionService = bonReceptionService;
        this.factureService = factureService;
        this.authService = authService;
        this.layoutService = layoutService;
    }
    @GetMapping("/transfert")
    public String transfertBrToFact(@RequestParam("id") BonReception bonReception){
        factureService.genererFacture(bonReception);
//        factureService.genererFactureWithFille(bonReception);
        return  new Redirection("achat/validation-facture").getUrl();
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("facture/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("factures", factureService.findAll());
        return mav;
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
        @RequestParam("id") Facture facture
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("facture/details");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("facture", facture);
        mav.addObject("filles", facture.getFilles());
        return mav;
    }

    @PostMapping("/valider")
    public String validerFacture(
        @RequestParam("idFacture") Facture facture,
        RedirectAttributes atts
    ) throws UnallowedRoleException, NoUserLoggedException, Alert {
        authService.requireUser();
        authService.allowRoles(UserRole.DIRECTION);

        factureService.validerFacture(facture);
        atts.addFlashAttribute("alert", "Facture: FC000" +facture.getId() + " validée");

        return new Redirection("/facture/details?id="+facture.getId()).getUrl();
    }

//    @GetMapping("/details")
//    public ModelAndView showDetails(
//            @RequestParam("id") Facture facture
//    ) {
//        ModelAndView modelAndView = new ModelAndView("template");
//
//        String content = "landingAchat.jsp";
//        String sidebar = "template/floating-sidebar-achat.jsp";
//        String validation = "achat/facture-detail.jsp";
//        modelAndView.addObject("content", content);
//        modelAndView.addObject("sidebar", sidebar);
//        modelAndView.addObject("insideContent", validation);
//        modelAndView.addObject("factFille", factureService.findFilleByIdMere(facture.getId()));
//        return modelAndView;
//    }
//HERE
//    @PostMapping("/generer")
//    public String genererFactureAvecStock(
//        @RequestParam("idBr") BonReception br
//    ) throws Exception {
//        authService.requireUser();
//        factureService.genererFactureAvecStock(br);
//        return new Redirection("/bon-reception/details?id="+br.getId()).getUrl();
//    }

//    @PostMapping("/generer-facture")
//    public String genererFactureAvecStock2(
//        @RequestParam("id") Facture facture
//    ) throws Exception {
//        authService.requireUser();
//        factureService.genererFactureAvecStock(br);
//        return new Redirection("/bon-reception/details?id="+br.getId()).getUrl();
//    }

}
