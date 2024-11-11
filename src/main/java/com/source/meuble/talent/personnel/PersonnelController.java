package com.source.meuble.talent.personnel;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.talent.entretien.Entretien;
import com.source.meuble.talent.entretien.EntretienService;
import com.source.meuble.util.Redirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @Autowired
    LayoutService layoutService;

    @Autowired
    EntretienService entretienService;

    @GetMapping("/insert-personnel")
    public ModelAndView embaucher(
            @RequestParam("id") Cv cv,
            @RequestParam("entretien")Entretien entretien
            ) throws NoUserLoggedException, NoExerciceFoundException, Exception {
        entretien.setEtat(1);
        entretienService.save(entretien);

        ModelAndView mav = layoutService.getLayout("talent/personnel/form").getModelAndView();
        mav.addObject("cv", cv);
        return mav;
    }

    @PostMapping("generer-contrat")
    public String genererContrat(@ModelAttribute Personnel pers, RedirectAttributes attr) throws Exception {
        Personnel p = personnelService.insertPersonnel(pers);
        attr.addFlashAttribute("pers", p);
        return "redirect:/contrat/embaucher";
    }
}
