package com.source.meuble.talent.entretien;

import com.source.meuble.talent.cv.Cv;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entretien", nullable = false)
    private Integer id;

    @Column(name = "date_entretien")
    private LocalDate dateEntretien;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cv", nullable = false)
    private Cv idCv;

}