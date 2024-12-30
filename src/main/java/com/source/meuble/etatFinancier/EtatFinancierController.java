package com.source.meuble.etatFinancier;

import com.source.meuble.auth.LayoutService;
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

    public EtatFinancierController(LayoutService layoutService, EtatFinancierService etatFinancierService) {
        this.layoutService = layoutService;
        this.etatFinancierService = etatFinancierService;
    }

    @GetMapping
    public ModelAndView analyse(HttpSession httpSession) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("etat-financier/analyse");
        ModelAndView mv = layout.getModelAndView();

        mv.addObject("exercice", httpSession.getAttribute("exo"));
        mv.addObject("etatFinancier", etatFinancierService.build());
        return mv;
    }

}
