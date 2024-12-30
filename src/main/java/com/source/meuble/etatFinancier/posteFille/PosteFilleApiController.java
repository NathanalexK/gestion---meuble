package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.etatFinancier.models.NomPoste;
import com.source.meuble.etatFinancier.models.NomPosteRepository;
import com.source.meuble.etatFinancier.models.NomPosteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poste-fille")
public class PosteFilleApiController {

    private final NomPosteService nomPosteService;

    public PosteFilleApiController(NomPosteService nomPosteService) {
        this.nomPosteService = nomPosteService;
    }

    @GetMapping("/nomposte-corres")
    public List<NomPoste> listeNom(@RequestParam("idPosteMere") int idPosteMere) {
        return nomPosteService.findByPosteMere(idPosteMere);
    }
}
