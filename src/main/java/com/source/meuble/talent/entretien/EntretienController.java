package com.source.meuble.talent.entretien;

import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.mail.MailService;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.talent.test.Test;
import com.source.meuble.talent.test.TestRepository;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

@Controller
@RequestMapping("entretien")
public class EntretienController {
    private final EntretienRepository entretienRepository;
    private final LayoutService layoutService;
    private final TestRepository testRepository;
    private final MailService mailService;

    public EntretienController(EntretienRepository entretienRepository, LayoutService layoutService,
                               TestRepository testRepository, MailService mailService) {
        this.entretienRepository = entretienRepository;
        this.layoutService = layoutService;
        this.testRepository = testRepository;
        this.mailService = mailService;
    }

    @GetMapping("/list")
    public ModelAndView list() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("talent/entretien/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("etr", entretienRepository.findAll());
        return mav;
    }

    @PostMapping("/save")
    public String save(@RequestParam("id")Cv cv, @RequestParam("daty")LocalDate daty, @RequestParam("test") Test test) throws MessagingException, UnsupportedEncodingException, Alert {
        Entretien entretien=new Entretien();
        entretien.setDateEntretien(daty);
        entretien.setIdCv(cv);
        test.setEtat(1);
        testRepository.save(test);
        entretienRepository.save(entretien);
        new Thread(() -> {
            try {
                System.out.println("Mail begin");
                mailService.accepterCV(cv, daty);
                System.out.println("Mail finished");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();
        return new Redirection("/entretien/list").getUrl();
    }
}
