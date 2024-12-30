package com.source.meuble.etatFinancier;

import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.posteFille.PosteFille;

import java.util.List;

public class MembreEtatFinancierDTO {
    int categorie;
    Poste mere;
    List<PosteFille> postes;
}
