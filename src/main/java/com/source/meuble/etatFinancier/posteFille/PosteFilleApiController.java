package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.nomPoste.NomPoste;
import com.source.meuble.etatFinancier.nomPoste.NomPosteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poste-fille")
public class PosteFilleApiController {

    private final NomPosteService nomPosteService;
    private final HttpSession httpSession;

    public PosteFilleApiController(NomPosteService nomPosteService, HttpSession httpSession) {
        this.nomPosteService = nomPosteService;
        this.httpSession = httpSession;
    }

    @GetMapping("/nomposte-corres")
    public List<NomPoste> listeNom(@RequestParam("idPosteMere") int idPosteMere) {
        Exercice exercice = (Exercice) httpSession.getAttribute("exo");
        return nomPosteService.findByPosteMere(idPosteMere, exercice);
    }
}
