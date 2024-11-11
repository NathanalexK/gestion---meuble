package com.source.meuble.talent.contrat.ContratEmploye;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.contrat.typeContrat.TypeContrat;
import com.source.meuble.talent.contrat.typeContrat.TypeContratService;
import com.source.meuble.talent.personnel.Personnel;
import com.source.meuble.talent.personnel.PersonnelService;
import com.source.meuble.util.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    private LayoutService layoutService;

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private ContratService contratService;

    @GetMapping("/showCdi")
    public ModelAndView showCdi(Personnel nouveau, ContratEmploye nouveauContrat) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("contrat/CDI/cdi");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("personnel", nouveau);
        return mav;
    }

    @GetMapping("/showCdd")
    public ModelAndView showCdd(Personnel nouveau, ContratEmploye nouveauContrat) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("contrat/CDD/cdd");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("personnel", nouveau);
        mav.addObject("contrat", nouveauContrat);
        return mav;
    }

    @GetMapping("/embaucher")
    @Transactional
    public ModelAndView embaucher(
            @ModelAttribute Personnel personnel,
            @RequestParam("type_contrat") int type
    ) throws Exception{
        ModelAndView mav = null;

        Personnel nouveau = personnelService.insertPersonnel(personnel);

        ContratEmploye contratEmploye = contratService.genererContrat(nouveau, type);

        ContratEmploye nouveauContrat = contratService.insertContrat(contratEmploye);

        if(type == 2){
            mav = this.showCdi(nouveau, nouveauContrat);
        } else if (type == 3) {
            mav = this.showCdd(nouveau, nouveauContrat);
        }
        return mav;
    }
}
