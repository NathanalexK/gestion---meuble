package com.source.meuble.etatFinancier;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.etatFinancier.bilan.BilanEtatFinancier;
import com.source.meuble.etatFinancier.bilan.BilanEtatFinancierService;
import com.source.meuble.etatFinancier.posteFille.PosteFilleViewRepository;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.util.Layout;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/etat-financier")
public class EtatFinancierController {

    private final LayoutService layoutService;
    private final EtatFinancierService etatFinancierService;
    private final BilanEtatFinancierService bilanEtatFinancierService;

    public EtatFinancierController(LayoutService layoutService, EtatFinancierService etatFinancierService,
            PosteFilleViewRepository posteFilleViewRepository, BilanEtatFinancierService bilanEtatFinancierService) {
        this.layoutService = layoutService;
        this.etatFinancierService = etatFinancierService;
        this.bilanEtatFinancierService = bilanEtatFinancierService;
    }

    @GetMapping
    public ModelAndView analyse(HttpSession httpSession) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("etat-financier/analyse");
        ModelAndView mv = layout.getModelAndView();

        Exercice exercice = (Exercice) httpSession.getAttribute("exo");
        mv.addObject("exercice", exercice);
        mv.addObject("etatFinancier", etatFinancierService.build(exercice));
        return mv;
    }

    @GetMapping("/interpretation")
    public ModelAndView showInterpretation() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("etat-financier/interpretation");
        ModelAndView mv = layout.getModelAndView();
        BilanEtatFinancier bilan = bilanEtatFinancierService.getBilanEtatFinancier(layout.getExercice());
        mv.addObject("bilan", bilan);
        return mv;
    }

}
