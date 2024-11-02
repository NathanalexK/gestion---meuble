package com.source.meuble.vente.BonLivraison;

import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.analytique.centre.CentreRepository;
import com.source.meuble.analytique.produit.ProduitService;
import com.source.meuble.auth.AuthService;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/bon-livraison")
public class BonLivraisonController {

    private final BonLivraisonService bonLivraisonService;
    private final CentreRepository centreRepository;
    private final ProduitService marchandiseService;
    private final AuthService authService;
    private final LayoutService layoutService;

    public BonLivraisonController(BonLivraisonService bonLivraisonService1, CentreRepository centreRepository, ProduitService marchandiseService, AuthService authService, LayoutService layoutService){
        this.bonLivraisonService = bonLivraisonService1;
        this.centreRepository = centreRepository;
        this.marchandiseService = marchandiseService;
        this.authService = authService;
        this.layoutService = layoutService;
    }

    @PostMapping("/transfert")
    public String transfertToBl(@RequestParam("date") LocalDate daty, @RequestParam("idBc") int id){
        bonLivraisonService.transferBcToBl(id,daty);
        return  new Redirection("test/home").getUrl();
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("bon-reception/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("brs", bonLivraisonService.findAll());
        return mav;
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
        @RequestParam("id") BonLivraison br
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
        @RequestParam("dateReception") LocalDate dateReception
    ) throws NoUserLoggedException {
        authService.requireUser();
        bonLivraisonService.genererBL(bc, dateReception);
        return new Redirection("/bon-commande/details?id="+bc.getId()).getUrl();
    }


}
