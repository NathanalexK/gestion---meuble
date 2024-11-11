package com.source.meuble.talent.entretient;

import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.talent.cv.Cv;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "entretient")
public class Entretient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entretient", nullable = false)
    private Integer id;

    @Column(name = "date_entretient")
    private LocalDate dateEntretient;

    @OneToOne
    @JoinColumn(name = "id_cv", nullable = false)
    private Cv idCv;
}
