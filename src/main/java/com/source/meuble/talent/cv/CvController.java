package com.source.meuble.talent.cv;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.diplome.DiplomeRepository;
import com.source.meuble.talent.offreEmploi.OffreEmploi;
import com.source.meuble.talent.offreEmploi.OffreEmploiRepository;
import com.source.meuble.util.Redirection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cv")
public class CvController {

    private final LayoutService layoutService;
    private final DiplomeRepository diplomeRepository;
    private final OffreEmploiRepository offreEmploiRepository;
    private final CvRepository cvRepository;

    public CvController(LayoutService layoutService,
                        DiplomeRepository diplomeRepository,
                        OffreEmploiRepository offreEmploiRepository,
                        CvRepository cvRepository) {
        this.layoutService = layoutService;
        this.diplomeRepository = diplomeRepository;
        this.offreEmploiRepository = offreEmploiRepository;
        this.cvRepository = cvRepository;
    }

//    @GetMapping("/form")
//    public ModelAndView form(
//
//    ) throws NoUserLoggedException, NoExerciceFoundException {
//        int idOffre = 1;
//        ModelAndView mv = layoutService.getLayout("talent/cv/form").getModelAndView();
//        mv.addObject("diplomes", diplomeRepository.findAll());
//        mv.addObject("offre", offreEmploiRepository.findById(idOffre).orElse(null));
//        return mv;
//    }

    @GetMapping("/form/{idOffre}")
    public ModelAndView form(
            @PathVariable int idOffre
    ) throws NoUserLoggedException, NoExerciceFoundException {
        ModelAndView mv = layoutService.getLayout("talent/cv/form").getModelAndView();
        mv.addObject("diplomes", diplomeRepository.findAll());
        mv.addObject("offre", offreEmploiRepository.findById(idOffre).orElse(null));
        return mv;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cv cv, RedirectAttributes redirectAttributes) {
        cvRepository.save(cv);

        redirectAttributes.addFlashAttribute("swal", Alert.success("Le CV a bien été ajouté à l'offre d emploi"));
        return new Redirection("/cv/list/" + cv.getIdOffreEmploi().getId()).getUrl();
    }

    @GetMapping("/list/{idOffre}")
    public ModelAndView list(
            @PathVariable int idOffre
    ) throws NoUserLoggedException, NoExerciceFoundException, Alert {
        ModelAndView mv = layoutService.getLayout("talent/cv/list").getModelAndView();
        OffreEmploi of = offreEmploiRepository.findById(idOffre).orElse(null);
        List<Cv> cvs = cvRepository.findByIdOffreEmploi(of);

        if (cvs.isEmpty())
            throw new Alert("Il n y a aucun cv pour cet offre");

        mv.addObject("offreEmploi", of);
        mv.addObject("cvs", cvs);
        return mv;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id) throws NoUserLoggedException, NoExerciceFoundException {
        ModelAndView mav = layoutService.getLayout("talent/cv/details").getModelAndView();
        Optional<Cv> cv = cvRepository.findById(id);

        mav.addObject("cv", cv.get());
        return mav;
    }

}
