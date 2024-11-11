package com.source.meuble.talent.contrat.ContratEmploye;

import com.source.meuble.talent.contrat.typeContrat.TypeContrat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "contrat_employe")
public class ContratEmploye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrat_employe", nullable = false)
    private Integer id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

//    IdPersonnel

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private TypeContrat typeContrat;
}
