package com.source.meuble.etatFinancier.interpretation;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.util.Layout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/socle")
public class SocleController {

    private final LayoutService layoutService;

    public SocleController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

    @PostMapping("/interpretation")
    public ModelAndView retrieveIndicateurEtat(@RequestParam("idIndicateur[]") List<Integer> idIndicateur, @RequestParam("data[]") List<Double> data) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("etat-financier/interpretation-resultat");
        List<Socle> socles = new ArrayList<>();
        for (int i = 0; i < idIndicateur.size(); i++) {
            socles.add(new Socle(idIndicateur.get(i), data.get(i)));
        }
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("data", socles);
        System.out.println(socles);
        return mav;
    }


}
