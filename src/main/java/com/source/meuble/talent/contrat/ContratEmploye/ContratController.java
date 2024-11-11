package com.source.meuble.talent.contrat.ContratEmploye;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.contrat.typeContrat.TypeContrat;
import com.source.meuble.talent.contrat.typeContrat.TypeContratService;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.talent.personnel.Personnel;
import com.source.meuble.talent.personnel.PersonnelService;
import com.source.meuble.util.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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

    @GetMapping("/showCe")
    public ModelAndView showCe(Personnel nouveau, ContratEmploye nouveauContrat) throws NoUserLoggedException, NoExerciceFoundException{
        Layout layout = layoutService.getLayout("contrat/CE/ce");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("personnel", nouveau);
        mav.addObject("contrat", nouveauContrat);
        return mav;
    }

    @GetMapping("/embaucher")
    @Transactional
    public ModelAndView embaucher(
            @ModelAttribute("pers") Personnel personnel
    ) throws Exception{
        ModelAndView mav = null;

        Personnel nouveau = personnelService.insertPersonnel(personnel);

        ContratEmploye contratEmploye = contratService.genererContrat(nouveau, 1);

        ContratEmploye nouveauContrat = contratService.insertContrat(contratEmploye);

        /*if(type == 2){
            mav = this.showCdi(nouveau, nouveauContrat);
        } else if (type == 3) {
            mav = this.showCdd(nouveau, nouveauContrat);
        }*/
        mav = this.showCe(nouveau, nouveauContrat);
        return mav;
    }

    @GetMapping("/promotion")
    public ModelAndView promotion(
            @RequestParam("personnel") Personnel personnel,
            @RequestParam("contrat") ContratEmploye contrat,
            @RequestParam("date")LocalDate date
            ) throws Exception{
        ContratEmploye nouveau = new ContratEmploye();
        nouveau.setPersonnel(personnel);
        nouveau.setDateDebut(date);
        nouveau.setDateFin(contrat.getDateDebut().plusMonths(6));
        nouveau.setTypeContrat(contrat.getTypeContrat());

        contratService.insertContrat(nouveau);

        ModelAndView mav = this.showCdi(personnel, nouveau);
        return  mav;
    }
}
