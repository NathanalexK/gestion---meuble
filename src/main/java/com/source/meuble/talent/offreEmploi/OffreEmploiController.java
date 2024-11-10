package com.source.meuble.talent.offreEmploi;

import com.source.meuble.achat.bonCommande.BonCommande;
import com.source.meuble.achat.bonCommande.BonCommandeService;
import com.source.meuble.achat.proformat.Proformat;
import com.source.meuble.achat.proformat.ProformatRepository;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.Publicite.FournisseurPubRepository;
import com.source.meuble.talent.recrutement.Recrutement;
import com.source.meuble.talent.recrutement.RecrutementRepository;
import com.source.meuble.util.Redirection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/offre-emploi")
public class OffreEmploiController {
    private final LayoutService layoutService;
    private final OffreEmploiRepository offreEmploiRepository;
    private final RecrutementRepository recrutementRepository;
    private final FournisseurPubRepository fournisseurPubRepository;
    private final ProformatRepository proformatRepository;
    private final BonCommandeService bonCommandeService;

    public OffreEmploiController(LayoutService layoutService,
                                 OffreEmploiRepository offreEmploiRepository,
                                 RecrutementRepository recrutementRepository,
                                 FournisseurPubRepository fournisseurPubRepository,
                                 ProformatRepository proformatRepository, BonCommandeService bonCommandeService) {
        this.layoutService = layoutService;
        this.offreEmploiRepository = offreEmploiRepository;
        this.recrutementRepository = recrutementRepository;
        this.fournisseurPubRepository = fournisseurPubRepository;
        this.proformatRepository = proformatRepository;
        this.bonCommandeService = bonCommandeService;
    }

    @GetMapping("/list")
    public ModelAndView liste() throws NoUserLoggedException, NoExerciceFoundException {
        ModelAndView mv = layoutService.getLayout("talent/offreEmploi/list").getModelAndView();
        mv.addObject("offreEmplois", offreEmploiRepository.findAll());
        return mv;
    }

    @GetMapping("/form")
    public ModelAndView form() throws NoUserLoggedException, NoExerciceFoundException {
        ModelAndView mv = layoutService.getLayout("talent/offreEmploi/form").getModelAndView();
        mv.addObject("recrutements", recrutementRepository.findAll());
        mv.addObject("proformats", proformatRepository.findByFilles_IdMarchandise_Type(1));
        return mv;
    }

    @PostMapping("/annoncer")
    public String annoncer(
            @RequestParam("recru[]") List<Recrutement> recrutements,
            @RequestParam("proformat")Proformat proformat
            ) throws Alert {
        if (recrutements.size() > 1)
            throw new Alert("Nombre de poste a publier superieur à 1");

        BonCommande bc = bonCommandeService.genererBonCommande(proformat);
        OffreEmploi of = new OffreEmploi();

        of.setIdBesoinRecrutement(recrutements.get(0));
        of.setDatePublication(LocalDate.now());
        of.setIdBc(bc);
        offreEmploiRepository.save(of);

        return new Redirection("/offre-emploi/list").getUrl();
    }
}