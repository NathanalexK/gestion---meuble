package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.nomPoste.NomPosteService;
import com.source.meuble.etatFinancier.posteFille.PosteFilleService;
import com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poste-fille")
public class PosteFilleApiController {
    @Autowired
    private PosteFilleService posteFilleService;

    private final NomPosteService nomPosteService;
    private final HttpSession httpSession;

    public PosteFilleApiController(NomPosteService nomPosteService, HttpSession httpSession) {
        this.nomPosteService = nomPosteService;
        this.httpSession = httpSession;
    }

    @GetMapping("/nomposte-corres")
    public List<PosteFilleSelectDTO> listeNom(@RequestParam("idPosteMere") int idPosteMere) {
        Exercice exercice = (Exercice) httpSession.getAttribute("exo");

        List<PosteFilleSelectDTO> posteFilles = posteFilleService.findByIdMereAndExercice(idPosteMere, exercice);

        System.out.println(posteFilles.size());

        return posteFilles;
    }


    @GetMapping("/compte-corres")
    public List<PosteFilleSelectDTO> listeCompte(@RequestParam("compteMere") int compte) {
        Exercice exercice = (Exercice) httpSession.getAttribute("exo");

        List<PosteFilleSelectDTO> posteFilles = posteFilleService.findByCompteAndExercice(compte, exercice);

        System.out.println(posteFilles.size());

        return posteFilles;
    }
}
