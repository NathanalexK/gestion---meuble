package com.source.meuble.talent.test;

import com.source.meuble.talent.cv.Cv;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test", nullable = false)
    private Integer id;

    @Column(name = "date_test")
    private LocalDate dateTest;

    @Column(name = "etat")
    private Integer etat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
    private Cv idCv;

}