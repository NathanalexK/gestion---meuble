package com.source.meuble.talent.recrutement;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.diplome.Diplome;
import com.source.meuble.talent.diplome.DiplomeService;
import com.source.meuble.util.AlertType;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recrutement")
public class RecrutementController {

    @Autowired
    private DiplomeService diplomeService;
    @Autowired
    private LayoutService layoutService;
    @Autowired
    private RecrutementService recrutementService;

    @GetMapping("/add")
    public ModelAndView goToRecrutementForm() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("talent/recrutement/form");
        ModelAndView mav = layout.getModelAndView();

        List<Diplome> dipl = diplomeService.findAll();

        mav.addObject("dipl", dipl);
        return mav;
    }

    @PostMapping("/save")
    public String saveRecrutement(@ModelAttribute Recrutement recr, RedirectAttributes attr) {
        if (recr.getDiplome() != null && recr.getDiplome().getId_diplome() != 0) {
            Optional<Diplome> diplome = diplomeService.findById(recr.getDiplome().getId_diplome());
            recr.setDiplome(diplome.get());
        }
        recrutementService.save(recr);
        attr.addFlashAttribute("swal", new Alert(AlertType.SUCCESS, "Succès", "Demande de recrutement validé"));
        return new Redirection("/recrutement/list").getUrl();
    }

    @GetMapping("/list")
    public ModelAndView goToRecrutementList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("talent/recrutement/list");
        ModelAndView mav = layout.getModelAndView();

        List<Recrutement> recr = recrutementService.findAllEnCours();

        mav.addObject("recr", recr);
        return mav;
    }

    @GetMapping("/detail")
    public ModelAndView goToRecrutementDetail(@RequestParam("id") int id) throws NoUserLoggedException, NoExerciceFoundException {
        Optional<Recrutement> rec = recrutementService.findById(id);
        Layout layout = layoutService.getLayout("talent/recrutement/details");
        ModelAndView mav = layout.getModelAndView();

        mav.addObject("recr", rec.get());
        return mav;
    }

}
