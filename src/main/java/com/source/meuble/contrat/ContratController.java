package com.source.meuble.contrat;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.util.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    private LayoutService layoutService;

    @GetMapping("/showCdi")
    public ModelAndView showCdi() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("contrat/CDI/cdi");
        ModelAndView mav = layout.getModelAndView();
        return mav;
    }

    @GetMapping("/showCdd")
    public ModelAndView showCdd() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("contrat/CDD/cdd");
        ModelAndView mav = layout.getModelAndView();
        return mav;
    }
}
