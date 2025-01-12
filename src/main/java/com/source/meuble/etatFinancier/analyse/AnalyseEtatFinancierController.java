package com.source.meuble.etatFinancier.analyse;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.util.Layout;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/etat-financier/analyse")
public class AnalyseEtatFinancierController {
    @Autowired
    private  LayoutService layoutService;

    @Autowired
    private AnalyseEtatFinancierService analyseEtatFinancierService;

    @GetMapping
    public ModelAndView analyse(HttpSession httpSession) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("etat-financier/analyseFinale");

        ModelAndView mv = layout.getModelAndView();

        Exercice exercice = (Exercice) httpSession.getAttribute("exo");
        mv.addObject("exercice", exercice);

        AnalyseEtaFinancier analyseEtaFinancier = analyseEtatFinancierService.generateAnalyseEtatFinancier(exercice);
        mv.addObject("analyse", analyseEtaFinancier);
        return mv;
    }
}
