package com.source.meuble.talent.entretien;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.talent.test.Test;
import com.source.meuble.talent.test.TestRepository;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("entretien")
public class EntretienController {
    private final EntretienRepository entretienRepository;
    private final LayoutService layoutService;
    private final TestRepository testRepository;

    public EntretienController(EntretienRepository entretienRepository, LayoutService layoutService,
                               TestRepository testRepository) {
        this.entretienRepository = entretienRepository;
        this.layoutService = layoutService;
        this.testRepository = testRepository;
    }

    @GetMapping("/list")
    public ModelAndView list() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("talent/entretien/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("etr", entretienRepository.findAll());
        return mav;
    }

    @PostMapping("/save")
    public String save(@RequestParam("id")Cv cv, @RequestParam("daty")LocalDate daty, @RequestParam("test") Test test){
        Entretien entretien=new Entretien();
        entretien.setDateEntretien(daty);
        entretien.setIdCv(cv);
        test.setEtat(1);
        testRepository.save(test);
        entretienRepository.save(entretien);
        return new Redirection("/entretien/list").getUrl();
    }
}
