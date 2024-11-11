package com.source.meuble.talent.personnel;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.util.Redirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @Autowired
    LayoutService layoutService;

    @GetMapping("/insert-personnel")
    public ModelAndView embaucher(
            @RequestParam("id") Cv cv
    ) throws NoUserLoggedException, NoExerciceFoundException {
        ModelAndView mav = layoutService.getLayout("talent/personnel/form").getModelAndView();
        mav.addObject("cv", cv);
        return mav;
    }

    @GetMapping("generer-contrat")
    public ModelAndView genererContrat(@ModelAttribute Personnel pers) {

    }
}
