package com.source.meuble.talent.contrat.ContratEmploye;

import com.source.meuble.talent.contrat.typeContrat.TypeContrat;
import com.source.meuble.talent.contrat.typeContrat.TypeContratService;
import com.source.meuble.talent.personnel.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ContratService {
    @Autowired
    ContratRepository contratRepository;

    @Autowired
    private TypeContratService typeContratService;

    public ContratEmploye insertContrat (ContratEmploye contratEmploye)throws  Exception{
        return  contratRepository.save(contratEmploye);
    }

    public ContratEmploye genererContrat(Personnel nouveau, int type)throws Exception{
        ContratEmploye contratEmploye = new ContratEmploye();
        contratEmploye.setDateDebut(nouveau.getDateEmbauche());

        LocalDate dateFin = null;
        if(type == 3){
            dateFin = nouveau.getDateEmbauche().plusYears(2);
        }

        contratEmploye.setDateFin(dateFin);
        contratEmploye.setPersonnel(nouveau);

        Optional<TypeContrat> option = typeContratService.getById(type);
        TypeContrat typeContrat = option.get();
        contratEmploye.setTypeContrat(typeContrat);

        return contratEmploye;
    }
}
