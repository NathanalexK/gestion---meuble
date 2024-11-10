package com.source.meuble.talent.offreEmploi;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.recrutement.Recrutement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/offre-emploi")
public class OffreEmploiController {
    private final LayoutService layoutService;
    private final OffreEmploiRepository offreEmploiRepository;

    public OffreEmploiController(LayoutService layoutService,
                                 OffreEmploiRepository offreEmploiRepository) {
        this.layoutService = layoutService;
        this.offreEmploiRepository = offreEmploiRepository;
    }

    @GetMapping("/list")
    public ModelAndView liste() throws NoUserLoggedException, NoExerciceFoundException {
        ModelAndView mv = layoutService.getLayout("talent/offreEmploi/list").getModelAndView();
        mv.addObject("offreEmplois", offreEmploiRepository.findAll());
        return mv;
    }
}