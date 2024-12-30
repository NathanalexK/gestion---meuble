package com.source.meuble.etatFinancier;

import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.Poste.PosteCpl;
import com.source.meuble.etatFinancier.posteFille.PosteFille;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EtatFinancierDTO {
    List<PosteCpl> bilan;
    List<PosteCpl> resultat;
    Double resultatNet;
}