package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.Poste.PosteService;
import com.source.meuble.etatFinancier.nomPoste.NomPosteRepository;
import com.source.meuble.etatFinancier.posteFille.PosteFilleValue.PosteFilleValue;
import com.source.meuble.etatFinancier.posteFille.PosteFilleValue.PosteFilleValueService;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/poste-fille")
public class PosteFilleController {
    @Autowired
    private PosteFilleService posteFilleService;

    @Autowired
    private PosteFilleValueService posteFilleValueService;

    private final LayoutService layoutService;
    private final PosteService posteService;
    private final NomPosteRepository nomPosteRepository;
    private final PosteFilleRepository posteFilleRepository;

    public PosteFilleController(LayoutService layoutService, PosteService posteService,
                                NomPosteRepository nomPosteRepository, HttpSession httpSession,
                                PosteFilleRepository posteFilleRepository) {
        this.layoutService = layoutService;
        this.posteService = posteService;
        this.nomPosteRepository = nomPosteRepository;
        this.posteFilleRepository = posteFilleRepository;
    }

    @GetMapping("/form")
    public ModelAndView form() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("etat-financier/form");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("postesMeres", posteService.findAllPoste());
        return mav;
    }

    /*@PostMapping("/save")
    public String save(
            @RequestParam("posteMere") Poste mere,
            @RequestParam("posteFille") NomPoste nomPoste,
            @RequestParam("montant") double montant,
            HttpSession session
            ) {
        Exercice exercice = ((Exercice) session.getAttribute("exo"));
        if(exercice == null) return new Redirection("/exercice").getUrl();

        PosteFille posteFille = new PosteFille();
        posteFille.setLibelle(nomPoste.getLibelle());
        posteFille.setIdMere(mere);
        posteFille.setMontant(montant);
        posteFille.setIdExercice(exercice);

        posteFilleRepository.save(posteFille);
        return "redirect:/poste-fille/form";
    }*/

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        /*Optional<PosteFille> posteFille = posteFilleRepository.findById(id);
        if (posteFille.isPresent()) {
            posteFilleRepository.delete(posteFille.get());
        }*/

        posteFilleValueService.deleteByCompte(id);
        return "redirect:/etat-financier/analyse";
    }

    @SneakyThrows
    @PostMapping("/traitement")
    public String posteFilleTraitement(
            @RequestParam("posteMere") Poste mere,
            HttpServletRequest request,
            @RequestParam("montant") double montant,
            HttpSession session
    ) {
        Exercice exercice = ((Exercice) session.getAttribute("exo"));
        if(exercice == null) return new Redirection("/exercice").getUrl();

        String[] posteFilles = request.getParameterValues("posteFille");
        if(posteFilles == null){
            throw new Exception("Poste fille est requis");
        }
        String libelle = request.getParameter("libelle");
        String compte = request.getParameter("compte");

        Optional<PosteFille> posteFilleOptional = posteFilleService.findByCompte(posteFilles[posteFilles.length-1]);
        if(posteFilleOptional.isPresent()){
            PosteFille posteFille = posteFilleOptional.get();
            if(libelle == null || libelle.isEmpty()){

                PosteFilleValue posteFilleValue = new PosteFilleValue();
                posteFilleValue.setCompte(posteFille.getId());
                posteFilleValue.setMontant(montant);
                posteFilleValue.setIdExercice(exercice);

                posteFilleValueService.save(posteFilleValue);

            }else if (montant == 0 && libelle != null){

                PosteFille newPosteFille = new PosteFille();
                newPosteFille.setLibelle(libelle);
                newPosteFille.setCompteMere(posteFille);
                newPosteFille.setCompte(Integer.parseInt(compte));
                newPosteFille = posteFilleService.save(newPosteFille);

                posteFilleRepository.save(newPosteFille);

            } else {

                PosteFille newPosteFille = new PosteFille();
                newPosteFille.setLibelle(libelle);
                newPosteFille.setCompteMere(posteFille);

                newPosteFille = posteFilleService.save(newPosteFille);

                PosteFilleValue posteFilleValue = new PosteFilleValue();
                posteFilleValue.setCompte(newPosteFille.getId());
                posteFilleValue.setMontant(montant);
                posteFilleValue.setIdExercice(exercice);

                posteFilleValueService.save(posteFilleValue);
            }
        }

        return "redirect:/poste-fille/form";
    }
}
