package com.source.meuble.talent.test;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.talent.test.resultatTest.ResultatTest;
import com.source.meuble.talent.test.resultatTest.ResultatTestRepository;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/test")
public class TestController {
    private final TestService testService;
    private final LayoutService layoutService;
    private final ResultatTestRepository resultatTestRepository;

    public TestController(TestService testService, LayoutService layoutService, ResultatTestRepository resultatTestRepository) {
        this.testService = testService;
        this.layoutService = layoutService;
        this.resultatTestRepository = resultatTestRepository;
    }

    @GetMapping("/form")
    public ModelAndView form(@RequestParam("id")Cv cv) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("talent/test/form");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("cv", cv);
        return mav;
    }

    @PostMapping("/save")
    @Transactional
    public String save(@RequestParam("id") Cv cv, @RequestParam("note")Double note, @RequestParam("daty")LocalDate date){
        Test test= new Test();
        test.setDateTest(date);
        test.setIdCv(cv);
        if (note>10){
            test.setEtat(0);
        }else {
            test.setEtat(1);
        }
        Test last=testService.save(test);

        ResultatTest resultatTest=new ResultatTest();
        resultatTest.setIdTest(last);
        resultatTest.setPoints(note);
        resultatTestRepository.save(resultatTest);

        return new Redirection("/test/list").getUrl();
    }

    @GetMapping("list")
    public ModelAndView list() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("talent/test/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("tests", testService.getAll());
        return mav;
    }
}
