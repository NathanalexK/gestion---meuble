package com.source.meuble.talent.contrat.typeContrat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "type_contrat")
public class TypeContrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private Integer nom;

    @Column(name = "abreviation")
    private  String abr;

}
